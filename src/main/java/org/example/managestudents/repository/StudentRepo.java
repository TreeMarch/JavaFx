package org.example.managestudents.repository;

import org.example.managestudents.entity.Students;

import java.sql.*;
import java.util.ArrayList;

public class StudentRepo {
    private final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/management_student";
    private final String MYSQL_USERNAME = "root";
    private final String MYSQL_PASSWORD = "";

    public void save(Students student){
        try{
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String strSql = "INSERT INTO students (code,full_name,phone_number,email)  VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(strSql);
            ps.setString(1,student.getCode());
            ps.setString(2,student.getFullName());
            ps.setString(3,student.getPhone());
            ps.setString(4,student.getEmail());
            ps.executeUpdate();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public ArrayList<Students> findAll(){
        ArrayList<Students> students = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String prSql = "SELECT * FROM students";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(prSql);
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String fullName = resultSet.getString("fullName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                Students obj = new Students();
                obj.setCode(code);
                obj.setFullName(fullName);
                obj.setPhone(phone);
                obj.setEmail(email);
                students.add(obj);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void update(Students student){

    }
    public void delete(Students student){

    }

}
