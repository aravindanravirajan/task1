package in;
import java.util.Scanner;
import in.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import in.*;
class sqlhelper extends singleton  {
    singleton object = new singleton();
    Connection a = object.getConnection();
    void update() {
        int id = 0;
        String name = null;
        String dept = null;
        String date = null;
        try {
            Scanner ip = new Scanner(System.in);
            System.out.println("Enter How Many data's to entered;");
            int a1 = ip.nextInt();
            for (int i = 0; i < a1; i++) {
                System.out.println("Enter your name :");
                name = ip.next();
                String c = name.substring(0, 1);
                c = c.toUpperCase();
                String b = name.substring(1);
                name = c + b;
                System.out.println("Enter your ID :");
                id = ip.nextInt();
                System.out.println("Enter your date of Birth:" + " yyyy-mm-dd");
                date = ip.next();
                System.out.println("Enter Your department:");
                dept = ip.next();
                dept = dept.toUpperCase();
            }
            Statement stmt = a.createStatement();
            String Query = "insert into student (Person_Id ,Name,DOB,Department)values(" + id + ",'"+name+"','"+date+"','"+ dept +"');";
            stmt.executeUpdate(Query);
            stmt.close();
            a.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    void fetch() {
        try {
            System.out.println("Do you want to fetch by dob or department");
            Scanner ip = new Scanner(System.in);
            Statement stmt = a.createStatement();
            String choose = ip.next();
            choose = choose.toUpperCase();
            if (choose.equals("DOB")) {

                ResultSet rs = stmt.executeQuery("SELECT *  from student where DOB = (Select min(DOB)FROM student );");
                while(rs.next()){
                    System.out.println("The oldest person in the class is");
                    System.out.println(rs.getInt("Person_id")+"  "+rs.getString("Name")+"  "+rs.getString("DOB")+"  "+rs.getString("Department"));
                }
            }
            if(choose.equals("DEPARTMENT")){
                System.out.println("Enter the Department to be fetched");
                String depart = ip.next();
                ResultSet rs = stmt.executeQuery("select * from student where Department ='"+depart+"';");
                int count = 0;
                while(rs.next()){
                    count=count+1;
                }
                System.out.println("The no of Students in the "+depart+" Department is: "+count);
            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }}
