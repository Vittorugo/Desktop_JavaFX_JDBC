package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable{

	private Department department;
	private DepartmentService service;
	
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
	public void onBtnSaveAction(ActionEvent event) { // save or update database
		if (department == null) {
			throw new IllegalStateException("Department entity was null");
		}
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		try {
			department = getFormData();
			service.saveOrUpdate(department);
			Utils.currentStage(event).close();
		} catch (DbException e) {
			Alerts.showAlert("Error saving department!", null, e.getMessage(), AlertType.ERROR);
		}
		
	}
	
	private Department getFormData() { // instantiating department object with form data
		Department department = new Department();
		department.setId(Utils.tryParseToInt(textFieldId.getText()));
		department.setName(textFieldName.getText());
		return department;
	}

	@FXML
	public void onBtnCancelAction() {
		
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
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
