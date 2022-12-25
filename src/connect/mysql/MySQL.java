package connect.mysql;

/**
 * @author Sanjeev Kashyap
 * @since 12-Sep-2022
 *
 */
public class MySQL {
    private String databaseName;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public MySQL() {
    }

    /**
     * @param databaseName
     */
    public MySQL(String databaseName) {
        this.databaseName = databaseName;
    }

    @Override
    public String toString() {
        return "MySQL{" +
                "databaseName='" + databaseName + '\'' +
                '}';
    }

    /**
     *
     * @param databaseName
     * @return 0 for meeting tables and 1 for homework tables
     */
    public int nameCheck(String databaseName){
        StringBuilder stringBuilder=new StringBuilder(databaseName);
        stringBuilder.reverse();
        databaseName=stringBuilder.toString();
        if(databaseName.charAt(4)=='e' && databaseName.charAt(5)=='e'){
            return 0;
        }
        else if(databaseName.charAt(0)=='w' && databaseName.charAt(1)=='h'){
            return 1;
        }
        return -1;
    }
}
