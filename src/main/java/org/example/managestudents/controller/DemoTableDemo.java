package org.example.managestudents.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import org.example.managestudents.entity.Students;
import org.example.managestudents.repository.StudentRepo;

import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class DemoTableDemo implements Initializable {

    public TableView tableView;
    private StudentRepo studentRepository = new StudentRepo();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Students> data = FXCollections.observableArrayList(studentRepository.findAll());
        tableView.setItems(data);
    }
}
