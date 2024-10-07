package database_testing;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.PriorityQueue;

public class Curd_Operations extends BaseClass{

    Connection con;
    @Test()
    public void get_All_employees() throws SQLException, ClassNotFoundException {
       con=setUp();
        Statement ss=con.createStatement();
         ResultSet resultSet =ss.executeQuery("select * from employee");

         while(resultSet.next())
         {
             int id=resultSet.getInt(1);
             String name=resultSet.getString(2);
             int salary=resultSet.getInt(3);

             System.out.println(id+"--"+name+"--"+salary);
         }
         System.out.println("-----------------------------------");
    }

    @Test
    public void get_employee() throws SQLException, ClassNotFoundException {
        con=setUp();
        PreparedStatement pre=con.prepareStatement("select * from employee where employee_id=?");
        pre.setInt(1,3);
        ResultSet resultSet =pre.executeQuery();

        while(resultSet.next())
        {
            int id=resultSet.getInt(1);
            String name=resultSet.getString(2);
            int salary=resultSet.getInt(3);

            System.out.println(id+"--"+name+"--"+salary);
        }
        System.out.println("-----------------------------------");
    }

    @Test
    public void insert_employee() throws SQLException, ClassNotFoundException {
        con=setUp();
        PreparedStatement pre=con.prepareStatement("insert into employee values(?,?,?)");
        pre.setInt(1,1);
        pre.setString(2,"dhoni");
        pre.setInt(3,55000);

        pre.execute();

        get_All_employees();
        System.out.println("-----------------------------------");
    }

    @Test
    public void update_employee() throws SQLException, ClassNotFoundException {
        con=setUp();
        PreparedStatement pre=con.prepareStatement("update employee set employee_name=? where employee_id=?");
        pre.setString(1,"shiridisaiKolla");
        pre.setInt(2,4);

        pre.executeUpdate();

        get_All_employees();
        System.out.println("-----------------------------------");
    }

    @Test
    public void delete_employee() throws SQLException, ClassNotFoundException {
        con=setUp();
        PreparedStatement pre=con.prepareStatement("delete from employee where employee_id=?");
        pre.setInt(1,5);

        pre.executeUpdate();

        get_All_employees();

        System.out.println("-----------------------------------");
    }

}
