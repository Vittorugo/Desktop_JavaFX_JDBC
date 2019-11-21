package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService{
	
	private DepartmentDao dao = DaoFactory.createDepartmentDao(); // database department table access 
	
	public List<Department> findAll(){
		return dao.findAll();
	}
	
	// this method saves or update the database by checking id 
	public void saveOrUpdate(Department department) {
		if(department.getId() == null) {
			dao.insert(department);
		} else {
			dao.update(department);
		}
	}
	
}
