package Ex1;

import java.util.Vector;

public class Database {
    private Vector<Employee> employees; // Stores the employees
    public Database() {
        employees = new Vector<>();
    }
    public boolean addEmployee(Employee employee) {
        // Code to add employee
        return employees.add(employee);
    }

    public void deleteEmployee(long emp_num) {
        // Code to delete employee
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpNum() == emp_num) {
                employees.remove(i);
                break;
            }
        }
    }
    public Employee[] getAllEmployees() {
        // Code to retrieve collection
        Employee[] emp = new Employee[employees.size()];
        for (int i = 0; i < employees.size(); i++) {
            emp[i] = employees.get(i);
        }
        return emp;
    }


    
}
