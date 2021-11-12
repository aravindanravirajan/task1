package in.cravejava.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public  class App {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?characterEncoding=latin1", "aravindan", "aravindan");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student;");
            if(rs.next() == false) {
                System.out.println("There is no element in the table");
            }
            if(rs.next() == true){
                int i = 0;
            HashMap<Integer,Integer> col1 = new HashMap<>();
            HashMap<Integer,String> col2 = new HashMap<>();
            HashMap<Integer,Date> col3 = new HashMap<>();
            HashMap<Integer,String> col4 = new HashMap<>();
            while (rs.next()) {
               i = i+1;
                 col1.put(i,rs.getInt("Person_id"));
                 col2.put(i,rs.getString("Name"));
                 col3.put(i,rs.getDate("DOB"));
                 col4.put(i,rs.getString("Department"));
            }
            int a = 0;
            for(Map.Entry<Integer,Date> entry: col3.entrySet()){
                if(entry.getValue() == (Collections.min(col3.values()))){
                    a = entry.getKey();
                }
            }
            System.out.println("The Oldest person in the class is :");
            System.out.println(col1.get(a) + "\t" +col2.get(a)+ "\t"+ col3.get(a)+"\t"+col4.get(a));
            System.out.println("Enter the department to be fetched:");
            Scanner ip = new Scanner(System.in);
            String c = ip.next();c=c.toUpperCase();
            int p = 0;
            for(Map.Entry<Integer,String> entry: col4.entrySet()){
                if(c.equals(entry.getValue())){

                    p= p +1;
                }
            }
            System.out.println("The number of students in "+c+" is :"+p);
            stmt.close();
            con.close();
            rs.close();
        }}

        catch (Exception e) {
            System.out.println(e);
        }

    }

}

