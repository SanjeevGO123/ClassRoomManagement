package connect.mysql;
/**
 * @author Sanjeev Kashyap
 * @since 12-Sep-2022
 */
public class MySQLMeetings extends MySQL{
    private Integer srNo;
    private String subjectLink;
    private String startingTime;
    private String endingTime;

    public MySQLMeetings() {
    }

    /**
     *
     * @param srNo
     * @param subjectLink
     * @param startingTime
     * @param endingTime
     */
    public MySQLMeetings(Integer srNo, String subjectLink, String startingTime, String endingTime) {
        this.srNo = srNo;
        this.subjectLink = subjectLink;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    /**
     *
     * @param databaseName
     * @param srNo
     * @param subjectLink
     * @param startingTime
     * @param endingTime
     */
    public MySQLMeetings(String databaseName, Integer srNo, String subjectLink, String startingTime, String endingTime) {
        super(databaseName);
        this.srNo = srNo;
        this.subjectLink = subjectLink;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public String getSubjectLink() {
        return subjectLink;
    }

    public void setSubjectLink(String subjectLink) {
        this.subjectLink = subjectLink;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }

    /**
     *
     * @param srNo
     * @param subjectLink
     * @param startingTime
     * @param endingTime
     * @return SQL Insert query for Meeting tables
     */
    public String insertMeeting(Integer srNo,String subjectLink,String startingTime,String endingTime){
        return "INSERT INTO "+super.getDatabaseName()+" VALUES ("+srNo+",\""+subjectLink+"\",\""+startingTime+"\",\""+endingTime+"\")";
    }

    /**
     *
     * @param subjectLink
     * @return SQL Update query for subjectLink
     */
    public String updateMeetingSubjectLink(String subjectLink){
        return "Update "+this.getDatabaseName()+" set subjectlink=\""+subjectLink+"\" where sr_no="+this.srNo;
    }

    /**
     *
     * @param startingTime
     * @return SQL Update query for startingTime
     */
    public String updateMeetingStartingTime(String startingTime){
        return "Update "+this.getDatabaseName()+" set starting_time=\""+startingTime+"\" where sr_no="+this.srNo;
    }

    /**
     *
     * @param endingTime
     * @return SQL Update query for endingTime
     */
    public String updateMeetingEndingTime(String endingTime){
        return "Update "+this.getDatabaseName()+" set ending_time=\""+endingTime+"\" where sr_no="+this.srNo;
    }
    @Override
    public String toString() {
        return "MySQLMeetings{" +
                "srNo=" + srNo +
                ", subjectLink='" + subjectLink + '\'' +
                ", startingTime='" + startingTime + '\'' +
                ", endingTime='" + endingTime + '\'' +
                '}';
    }
}
