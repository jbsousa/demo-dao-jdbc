package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

    public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	
	System.out.println("=== TEST 1: departement findById ===");
	Department department = departmentDao.findById(1);
	System.out.println(department);
	
	System.out.println("\n=== TEST 2: departement findAll ===");
	List<Department> list = departmentDao.findAll();
	list.forEach(System.out::println);
	
	System.out.println("\n=== TEST 3: departement insert ===");
	Department newDep = new Department(null, "Games");
	departmentDao.insert(newDep);
	System.out.println("Inserted! New id = " + newDep.getId());
	
	System.out.println("\n=== TEST 4: departement update ===");
	department = departmentDao.findById(1);
	department.setName("Music");
	departmentDao.update(department);
	System.out.println("Update completed!");
	
	System.out.println("\n=== TEST 4: departement delete ===");
	System.out.print("Enter id for delete test: ");
	int id = sc.nextInt();
	departmentDao.deleteById(id);
	System.out.println("Delete completed!");
	
	sc.close();

    }

}
