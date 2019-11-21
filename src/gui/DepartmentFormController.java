package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable{

	private Department department;
	
	@FXML
	private TextField textFieldId;
	
	@FXML
	private TextField textFieldName;
	
	@FXML
	private Label labelError;
	
	@FXML
	private Button btnSave;
	
	@FXML
	private Button btnCancel;
	
	@FXML
	public void onBtnSaveAction() {
		
	}
	
	@FXML
	public void onBtnCancelAction() {
		
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNode();
	}
	
	private void initializeNode() {
		Constraints.setTextFieldInteger(textFieldId);
		Constraints.setTextFieldMaxLength(textFieldName, 20);
	}
	
	public void updateFormData() {
		
		if (department == null) {
			throw new IllegalStateException("Department entitys was null");
		}
		
		textFieldId.setText(String.valueOf(department.getId()));
		textFieldName.setText(department.getName());
	}

}
