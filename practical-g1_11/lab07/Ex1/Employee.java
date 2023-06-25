package Ex1;

import java.util.Date;

public class Employee implements EmployeeInterface{

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String Start(Date d) {
        return "Employee (" + name + ") started on " + d;
    }

    @Override
    public String Terminate(Date d) {
        return "Employee terminated on " + d;
    }

    @Override
    public String work() {
        return "Employee is working";
    }

}
