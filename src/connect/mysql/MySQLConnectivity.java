package connect.mysql;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class MySQLConnectivity {
    public static void TestConnectivity() throws SQLException,ClassNotFoundException {
        Connection connection = null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "sanjeev123");
            statement = connection.createStatement();
            Scanner scanner=new Scanner(System.in);
            System.out.println("Press 1:Teacher\nPress 2:Student");
            Integer user=scanner.nextInt();
            scanner.nextLine();
            if(user.equals(1)) {
                System.out.print("Enter Username:");
                String userName = scanner.nextLine();
                System.out.print("Enter Password:");
                String passWord = scanner.nextLine();
                resultSet = statement.executeQuery("select * from userid_pwd_teacher where userid=\"" + userName + "\"");
                resultSet.next();
                if (passWord.equals(resultSet.getString("pwd"))) {
                    System.out.println("Enter Choice\nPress :Maths\nPress :CS\nPress :Chemistry\nPress :Physics");
                    System.out.println("Press :PE\nPress :Bio\nPress :English");
                    String subjectChoice = scanner.nextLine();
                    System.out.println("Press 1:Meetings\nPress 2:HomeWork");
                    Integer optionChoice = scanner.nextInt();
                    scanner.nextLine();
                    subjectChoice.toLowerCase();
                    MySQL mySQL = new MySQL();
                    MySQLMeetings mySQLMeetings = new MySQLMeetings();
                    MySQLHw mySQLHw = new MySQLHw();
                    //Meeting table
                    if (optionChoice == 1) {
                        ArrayList<String> meetings = new ArrayList<String>();
                        mySQL.setDatabaseName("12A_" + subjectChoice + "_meeting");
                        mySQLMeetings.setDatabaseName(mySQL.getDatabaseName());
                        System.out.println("Press 1:Insert\nPress 2:Update");
                        Integer itemChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (itemChoice.equals(1)) {
                            System.out.print("Enter SrNo:");
                            Integer srNo = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter Subject Link:");
                            String subLink = scanner.nextLine();
                            System.out.print("Enter Starting Time :");
                            String startTime = scanner.nextLine();
                            System.out.print("Enter Ending Time :");
                            String endTime = scanner.nextLine();
                            mySQLMeetings.setSrNo(srNo);
                            mySQLMeetings.setSubjectLink(subLink);
                            mySQLMeetings.setStartingTime(startTime);
                            mySQLMeetings.setEndingTime(endTime);
                            statement.executeUpdate(mySQLMeetings.insertMeeting(mySQLMeetings.getSrNo(), mySQLMeetings.getSubjectLink(), mySQLMeetings.getStartingTime(), mySQLMeetings.getEndingTime()));
                            resultSet = statement.executeQuery("select * from " + mySQL.getDatabaseName());

                            while (resultSet.next()) {
                                String entry="MySQLMeetings{" +
                                        "srNo=" +resultSet.getString("sr_no") +
                                        ", subjectLink='" +resultSet.getString("subjectlink") + '\'' +
                                        ", startingTime='" + resultSet.getString("starting_time") + '\'' +
                                        ", endingTime='" + resultSet.getString("ending_time") + '\'' +
                                        '}';
                                meetings.add(entry);
                            }
                            for(String s : meetings){
                                System.out.println(s);
                            }
                        } else if (itemChoice.equals(2)) {
                            System.out.print("Enter SrNo for Updation:");
                            Integer srNo = scanner.nextInt();
                            scanner.nextLine();
                            mySQLMeetings.setSrNo(srNo);
                            resultSet = statement.executeQuery("select * from " + mySQLMeetings.getDatabaseName() + " where sr_no=" + mySQLMeetings.getSrNo());
                            resultSet.next();
                            mySQLMeetings.setSubjectLink(resultSet.getString("subjectlink"));
                            mySQLMeetings.setStartingTime(resultSet.getString("starting_time"));
                            mySQLMeetings.setEndingTime(resultSet.getString("ending_time"));
                            do {
                                System.out.println(mySQLMeetings);
                            } while (resultSet.next());
                            System.out.println("Press 1:Subject Link\nPress 2:Starting Time\nPress 3:Ending Time");
                            Integer updateChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (updateChoice.equals(1)) {
                                System.out.print("Enter new Subject Link:");
                                String updatedSubLink = scanner.nextLine();
                                mySQLMeetings.setSubjectLink(updatedSubLink);
                                statement.executeUpdate(mySQLMeetings.updateMeetingSubjectLink(mySQLMeetings.getSubjectLink()));
                            } else if (updateChoice.equals(2)) {
                                System.out.print("Enter new Starting DateTime:");
                                String updatedStartTime = scanner.nextLine();
                                mySQLMeetings.setStartingTime(updatedStartTime);
                                statement.executeUpdate(mySQLMeetings.updateMeetingStartingTime(mySQLMeetings.getStartingTime()));
                            } else if (updateChoice.equals(3)) {
                                System.out.print("Enter new Ending DateTime:");
                                String updatedEndTime = scanner.nextLine();
                                mySQLMeetings.setEndingTime(updatedEndTime);
                                statement.executeUpdate(mySQLMeetings.updateMeetingEndingTime(mySQLMeetings.getEndingTime()));
                            }
                            resultSet = statement.executeQuery("select * from " + mySQLMeetings.getDatabaseName() + " where sr_no=" + mySQLMeetings.getSrNo());
                            while (resultSet.next()) {
                                String entry="MySQLMeetings{" +
                                        "srNo=" +resultSet.getString("sr_no") +
                                        ", subjectLink='" +resultSet.getString("subjectlink") + '\'' +
                                        ", startingTime='" + resultSet.getString("starting_time") + '\'' +
                                        ", endingTime='" + resultSet.getString("ending_time") + '\'' +
                                        '}';
                                meetings.add(entry);
                            }
                            for(String s : meetings){
                                System.out.println(s);
                            }
                        }
                    }

                    //HomeWork Table
                    else if (optionChoice == 2) {
                        ArrayList<String> homeWork=new ArrayList<String>();
                        mySQL.setDatabaseName("12A_" + subjectChoice + "_hw");
                        mySQLHw.setDatabaseName(mySQL.getDatabaseName());
                        System.out.println("Press 1:Insert\nPress 2:Update");
                        Integer itemChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (itemChoice.equals(1)) {
                            System.out.print("Enter SrNo:");
                            Integer srNo = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter Chapter Name:");
                            String chapName = scanner.nextLine();
                            System.out.print("Enter Topic :");
                            String topic = scanner.nextLine();
                            System.out.print("Enter Date of Submission:");
                            String dateOfSubmission = scanner.nextLine();
                            mySQLHw.setSrNo(srNo);
                            mySQLHw.setChapterName(chapName);
                            mySQLHw.setTopic(topic);
                            mySQLHw.setDateOfSubmission(dateOfSubmission);
                            statement.executeUpdate(mySQLHw.insertHw(mySQLHw.getSrNo(), mySQLHw.getChapterName(), mySQLHw.getTopic(), mySQLHw.getDateOfSubmission()));
                            resultSet = statement.executeQuery("select * from " + mySQL.getDatabaseName());
                            while (resultSet.next()) {
                                String entry="MySQLHw{" +
                                        "srNo=" +resultSet.getString("sr_no") +
                                        ", chapterName='" +resultSet.getString("chapter_name") + '\'' +
                                        ", topic='" + resultSet.getString("topic") + '\'' +
                                        ", dateOfSubmission='" + resultSet.getString("date_of_submission") + '\'' +
                                        '}';
                                homeWork.add(entry);
                            }
                            for( String s : homeWork){
                                System.out.println(s);
                            }
                        } else if (itemChoice.equals(2)) {
                            System.out.print("Enter SrNo for Updation:");
                            Integer srNo = scanner.nextInt();
                            scanner.nextLine();
                            mySQLHw.setSrNo(srNo);
                            resultSet = statement.executeQuery("select * from " + mySQLHw.getDatabaseName() + " where sr_no=" + mySQLHw.getSrNo());
                            resultSet.next();
                            mySQLHw.setChapterName(resultSet.getString("chapter_name"));
                            mySQLHw.setTopic(resultSet.getString("topic"));
                            mySQLHw.setDateOfSubmission(resultSet.getString("date_of_submission"));
                            do {
                                System.out.println(mySQLHw);
                            } while (resultSet.next());
                            System.out.println("Press 1:Chapter Name\nPress 2:Topic\nPress 3:Date of Submission");
                            Integer updateChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (updateChoice.equals(1)) {
                                System.out.print("Enter new Chapter name:");
                                String updatedChapName = scanner.nextLine();
                                mySQLHw.setChapterName(updatedChapName);
                                statement.executeUpdate(mySQLHw.updateHwChapterName(mySQLHw.getChapterName()));
                            } else if (updateChoice.equals(2)) {
                                System.out.print("Enter new Topic:");
                                String updatedTopic = scanner.nextLine();
                                mySQLHw.setTopic(updatedTopic);
                                statement.executeUpdate(mySQLHw.updateHwTopic(mySQLHw.getTopic()));
                            } else if (updateChoice.equals(3)) {
                                System.out.print("Enter new Date of Submission:");
                                String updatedDateOfSubmission = scanner.nextLine();
                                mySQLHw.setDateOfSubmission(updatedDateOfSubmission);
                                statement.executeUpdate(mySQLHw.updateHwDateOfSubmission(mySQLHw.getDateOfSubmission()));
                            }
                            resultSet = statement.executeQuery("select * from " + mySQLHw.getDatabaseName() + " where sr_no=" + mySQLHw.getSrNo());
                            while (resultSet.next()){
                                String entry = "MySQLHw{" +
                                        "srNo=" + resultSet.getString("sr_no") +
                                        ", chapterName='" + resultSet.getString("chapter_name") + '\'' +
                                        ", topic='" + resultSet.getString("topic") + '\'' +
                                        ", dateOfSubmission='" + resultSet.getString("date_of_submission") + '\'' +
                                        '}';
                                homeWork.add(entry);
                            }
                            for( String s : homeWork){
                                System.out.println(s);
                            }

                        }
                    }
                }
                else{
                    System.out.println("Invalid Credentials");
                }
            }
            else if(user.equals(2)){
                System.out.print("Enter Username:");
                String userName = scanner.nextLine();
                System.out.print("Enter Password:");
                String passWord = scanner.nextLine();
                resultSet = statement.executeQuery("select * from userid_pwd where userid=\"" + userName + "\"");
                resultSet.next();
                if (passWord.equals(resultSet.getString("pwd"))){
                    System.out.println("Enter Choice\nPress :Maths\nPress :CS\nPress :Chemistry");
                    System.out.println("Press :Physics\nPress :PE\nPress :Bio\nPress :English");
                    String subjectChoice = scanner.nextLine();
                    System.out.println("Press 1:Meetings");
                    System.out.println("Press 2:HomeWork");
                    Integer optionChoice = scanner.nextInt();
                    scanner.nextLine();
                    subjectChoice.toLowerCase();
                    MySQL mySQL = new MySQL();
                    MySQLMeetings mySQLMeetings=new MySQLMeetings();
                    MySQLHw mySQLHw=new MySQLHw();
                    if(optionChoice.equals(1)){
                        mySQL.setDatabaseName("12A_"+subjectChoice+"_meeting");
                        mySQLMeetings.setDatabaseName(mySQL.getDatabaseName());
                        resultSet=statement.executeQuery("select COUNT(sr_no) as sr_no from "+mySQLMeetings.getDatabaseName());
                        resultSet.next();
                        if((resultSet.getInt("sr_no"))==0){
                            System.out.println("No Class");
                        }
                        else if((resultSet.getInt("sr_no"))!=0){
                            resultSet=statement.executeQuery("select * from "+mySQLMeetings.getDatabaseName());
                            while(resultSet.next()){
                                mySQLMeetings.setSrNo(resultSet.getInt("sr_no"));
                                mySQLMeetings.setSubjectLink(resultSet.getString("subjectlink"));
                                mySQLMeetings.setStartingTime(resultSet.getString("starting_time"));
                                mySQLMeetings.setEndingTime(resultSet.getString("ending_time"));
                                System.out.println(mySQLMeetings);
                            }
                        }
                    }
                    else if(optionChoice.equals(2)){
                        mySQL.setDatabaseName("12A_"+subjectChoice+"_hw");
                        mySQLHw.setDatabaseName(mySQL.getDatabaseName());
                        resultSet=statement.executeQuery("select COUNT(sr_no) as sr_no from "+mySQLHw.getDatabaseName());
                        resultSet.next();
                        if((resultSet.getInt("sr_no"))==0){
                            System.out.println("No Class");
                        }
                        else if((resultSet.getInt("sr_no"))!=0){
                            resultSet=statement.executeQuery("select * from "+mySQLHw.getDatabaseName());
                            while(resultSet.next()){
                                mySQLHw.setSrNo(resultSet.getInt("sr_no"));
                                mySQLHw.setChapterName(resultSet.getString("chapter_name"));
                                mySQLHw.setTopic(resultSet.getString("topic"));
                                mySQLHw.setDateOfSubmission(resultSet.getString("date_of_submission"));
                                System.out.println(mySQLHw);
                            }
                        }
                    }
                }
                else{
                    System.out.println("Invalid Credentials");
                }
            }

        }
        catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            resultSet.close();
            statement.close();
            connection.close();
        }
    }
}
