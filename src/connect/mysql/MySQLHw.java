package connect.mysql;

/**
 * @author Sanjeev Kashyap
 * @since 12-Sep-2022
 */
public class MySQLHw extends MySQL{
    private Integer srNo;
    private String chapterName;
    private String topic;
    private String dateOfSubmission;
    public MySQLHw(){
    }
    /**
     *
     * @param databaseName
     * @param srNo
     * @param chapterName
     * @param topic
     * @param dateOfSubmission
     */
    public MySQLHw(String databaseName, Integer srNo, String chapterName, String topic, String dateOfSubmission) {
        super(databaseName);
        this.srNo = srNo;
        this.chapterName = chapterName;
        this.topic = topic;
        this.dateOfSubmission = dateOfSubmission;
    }

    /**
     *
     * @param srNo
     * @param chapterName
     * @param topic
     * @param dateOfSubmission
     */
    public MySQLHw(Integer srNo, String chapterName, String topic, String dateOfSubmission) {
        this.srNo = srNo;
        this.chapterName = chapterName;
        this.topic = topic;
        this.dateOfSubmission = dateOfSubmission;
    }

    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(String dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    /**
     *
     * @param srNo
     * @param chapterName
     * @param topic
     * @param dateOfSubmission
     * @return SQL Insert query for HomeWork tables
     */
    public String insertHw(Integer srNo,String chapterName,String topic,String dateOfSubmission){
        return "INSERT INTO "+super.getDatabaseName()+" VALUES ("+srNo+",\""+chapterName+"\",\""+topic+"\",\""+dateOfSubmission+"\")";
    }

    /**
     *
     * @param chapterName
     * @return SQL Update query for chapterName
     */
    public String updateHwChapterName(String chapterName){
        return "Update "+this.getDatabaseName()+" set chapter_name=\""+chapterName+"\" where sr_no="+this.srNo;
    }

    /**
     *
     * @param topic
     * @return SQL Update query for topic
     */
    public String updateHwTopic(String topic){
        return "Update "+this.getDatabaseName()+" set topic=\""+topic+"\" where sr_no="+this.srNo;
    }

    /**
     *
     * @param dateOfSubmission
     * @return SQL Update query for dateOfSubmission
     */
    public String updateHwDateOfSubmission(String dateOfSubmission){
        return "Update "+this.getDatabaseName()+" set date_of_submission=\""+dateOfSubmission+"\" where sr_no="+this.srNo;
    }

    @Override
    public String toString() {
        return "MySQLHw{" +
                "srNo=" + srNo +
                ", chapterName='" + chapterName + '\'' +
                ", topic='" + topic + '\'' +
                ", dateOfSubmission='" + dateOfSubmission + '\'' +
                '}';
    }
}
