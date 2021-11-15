package in;
import in.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;
 class singleton {
    private static Connection con = null;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?characterEncoding=latin1", "aravindan", "aravindan");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return con;
    }

void conclose() {
    try {
        con.close();
    }catch(Exception e){
        System.out.println(e);
    }
}
}

