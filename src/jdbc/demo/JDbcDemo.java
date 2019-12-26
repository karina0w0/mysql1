/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc.demo;
import java.sql.*;
import java.util.*;
/**
 *
 * @author student
 */
public class JDbcDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);
        
        
        String u,url,p;
        url="JDbc:mysql://localhost:3306/onlinestorea";
        u="karinashrestha";
        p="root";
        
        Connection con= DriverManager.getConnection(url,u,p);
        Statement st=con.createStatement();
        
        String pname,unit;
        int category_id,stock,discount;
        double price;
        
        System.out.println("Enter category_id:");
        category_id=sc.nextInt();
        
        System.out.println("Enter product name");
        pname=sc.next();
        
         System.out.println("Enter unit");
        unit=sc.next();
        
         System.out.println("Enter stock");
        stock=sc.nextInt();
        
         System.out.println("Enter discount");
       discount=sc.nextInt();
       
         System.out.println("Enter price");
        price=sc.nextDouble();
        
       int rowCount=st.executeUpdate("insert into products(category_id,name,price,discount,stock,unit) values("+category_id+",'"+pname+"',"+price+","
               +discount+","+stock+",'"+unit+"')");
        
        
       
        System.out.print(rowCount+" rows added sucessfully");
       
     
              
        
      ResultSet rs=st.executeQuery("select * from products");
        System.out.println("Name\t\t\tPrice\t\t\tunit\t\t\tStock");
        while(rs.next())
            System.out.println(rs.getString(3)+"\t\t\tRs"+rs.getString(4)+"\t\t\t"+rs.getString(7)+"\t\t\t\t"+rs.getString(6));
        con.close();
        
        
        
    }
    
}
