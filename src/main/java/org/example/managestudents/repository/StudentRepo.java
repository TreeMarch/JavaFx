package org.example.managestudents.repository;

import org.example.managestudents.entity.Students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentRepo {
    private final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/management_student";
    private final String MYSQL_USERNAME = "root";
    private final String MYSQL_PASSWORD = "";

    public void save(Students student){
        try{
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String strSql = "INSERT INTO students (code,full_name,phone_number,email)  VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(strSql);
            ps.setString(1,student.getStudentCode());
            ps.setString(2,student.getStudentName());
            ps.setString(3,student.getStudentPhone());
            ps.setString(4,student.getStudentEmail());
            ps.executeUpdate();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void tableView(Students student){ }

    public void update(Students student){

    }
    public void delete(Students student){

    }

}
