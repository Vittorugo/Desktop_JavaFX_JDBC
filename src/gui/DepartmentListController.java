package gui;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {
	
	private DepartmentService service;
	
	@FXML
	private Button btnNew;
	
	@FXML
	private TableView<Department> tableViewDepartmentList;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department, String> tableColumnName;
	
	private ObservableList<Department> observableListDepartment;
	
	@FXML
	public void onBtnNewAction() {
		System.out.println("ClickNew!");
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartmentList.prefHeightProperty().bind(stage.heightProperty()); // tableViewDepartment windows size is the same as vbox. 
	}
	
	public void updateTableView() {
		if(service == null) {
			throw new IllegalStateException("Service was null!");
		}
		List<Department> list = service.findAll();
		observableListDepartment = FXCollections.observableArrayList(list);
		tableViewDepartmentList.setItems(observableListDepartment);
	}
}
