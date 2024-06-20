package org.example.managestudents.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.example.managestudents.entity.Students;
import org.example.managestudents.repository.StudentRepo;

public class studentForm {
    public TextField studentCode;
    public TextField studentName;
    public TextField studentPhone;
    public TextField studentEmail;
    private StudentRepo studentRepository = new StudentRepo();


    public void doSomething(ActionEvent actionEvent) {
        Students students = new Students();
        students.setStudentCode(studentCode.getText());
        students.setStudentName(studentName.getText());
        students.setStudentPhone(studentPhone.getText());
        students.setStudentEmail(studentEmail.getText());
        studentRepository.save(students);
        studentRepository.update(students);
        studentRepository.delete(students);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Action Successful");
        alert.setHeaderText("Action Saved!!!");
        alert.setContentText(studentRepository.toString());
        alert.show();

    }
}
