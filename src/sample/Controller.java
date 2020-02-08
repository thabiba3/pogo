package sample;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private ListView<Worker> employeeListView;
    //Handle for UI
    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField LastNameTextField;

    @FXML
    private CheckBox isActiveCheckBox;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //selection model handles in the UI selecting something
        //it also keep track of selected item and if nothing selected it goes to null
        //it adds listener to it and the observable value that i am listening it could be anything that extends the class value
        //it shoes the old value selected and the new value selected

        employeeListView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<?
                extends Worker> ov, Worker old_val, Worker new_val) ->
        {
         Worker selectedItem = employeeListView.getSelectionModel().getSelectedItem();
         //we know it is at the selected item
         firstNameTextField.setText(((Employee)selectedItem).firstName); //Casting here
            LastNameTextField.setText(((Employee)selectedItem).LastName);
            isActiveCheckBox.setSelected(((Employee)selectedItem).isActive);
            //you have to set it to true is active
            //you can try to Try to cast it before, it will not crash the code and it will tell you before it crashes
        }
        );





        ObservableList<Worker> items = employeeListView.getItems();
        Employee employee1 = new Employee();
        employee1.firstName = "Robert";
        employee1.LastName = "Sobert";
        Employee employee2 = new Employee();
        employee2.firstName = "Lisa";
        employee1.firstName = "Sobert";
        items.add(employee1);
       items.add(employee2);

        for(int i = 0; i < 10; i++)
        {
            Employee employee = new Employee();
            employee.firstName = "Generic";
            employee.LastName = "Employee" + " " + i;
            employee.hire();
            items.add(employee);
        }
        Staff staff1 = new Staff();
        staff1.firstName = "Staffperson";
        staff1.LastName = "GoodWorker";

        Faculty faculty1 = new Faculty();
        faculty1.firstName = "FirstPerson";
        faculty1.LastName = "TerriPerson";
        items.add(staff1);
        items.add(faculty1);
    }
}

//any numeric value default is zero