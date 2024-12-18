package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import client.ChatClient;
import client.ClientController;
import client.ClientUI;
import common.ChatIF;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Faculty;
import logic.Student;

public class StudentFormController implements Initializable {
	private Student s;
		
	@FXML
	private Label lblName;
	@FXML
	private Label lblSurname;
	@FXML
	private Label lblFaculty;
	
	@FXML
	private Label lblStudentId;
	
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtSurname;
	
	@FXML
	private TextField txtStudentId;
	
	@FXML
	private Button btnclose=null;
	
	@FXML
	private Button btnSave=null;
	
	@FXML
	private ComboBox cmbFaculty;	
	
	ObservableList<String> list;
		
	public void loadStudent(Student s1) {
		this.s=s1;
		this.txtName.setText(s.getPName());
		this.txtSurname.setText(s.getLName());		
		this.cmbFaculty.setValue(s.getFc().getFName());
	}
	
	// creating list of Faculties
	private void setFacultyComboBox() {
		ArrayList<String> al = new ArrayList<String>();	
		al.add("ME");
		al.add("IE");
		al.add("SE");

		list = FXCollections.observableArrayList(al);
		cmbFaculty.setItems(list);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		setFacultyComboBox();		
	}
	
	public void closeStudentForm(ActionEvent closeButton) throws IOException {
		((Node)closeButton.getSource()).getScene().getWindow().hide(); //hiding primary window

		
		Parent root = FXMLLoader.load(getClass().getResource("/gui/AcademicFrame.fxml"));
		Stage primaryStage = new Stage();
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/gui/AcademicFrame.css").toExternalForm());
		primaryStage.setTitle("Academic Managment Tool");
		primaryStage.setScene(scene);
		
		primaryStage.show();	
	}
	
	public void saveStudentInServer(ActionEvent saveButton) {
		String msg;
		Faculty f=new Faculty(cmbFaculty.getValue().toString()," ");
		Student edittedStudent = new Student(txtStudentId.getText(), txtName.getText(), txtSurname.getText(), f);
		
		msg = "save "+edittedStudent.toString();
		
		ClientUI.chat.accept(msg);
	}	
}
