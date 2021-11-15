package in;
//import block
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import in.*;

public class App {
    public static void main(String[] args) {
        sqlhelper b = new sqlhelper();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an option do you want to fetch or enter the data");
        String option = sc.next();
        option = option.toUpperCase();
        try {
            if (option.equals("ENTER")) {
                b.update();
            }
            if (option.equals("FETCH")) {
                b.fetch();
            } else {
                System.out.println("There is no options like that");
            }
        }
       finally{
            singleton close = new singleton();
            close.conclose();
        }
    }
}







 



 
