package Ex1;

import java.util.Date;

public abstract class EmployeeDecorator implements EmployeeInterface{
    
    private EmployeeInterface employee;
    
    public EmployeeDecorator(EmployeeInterface employee){
        this.employee = employee;
    }
    
    @Override
    public String Start(Date d) {
        return employee.Start(d);
    }

    @Override
    public String Terminate(Date d) {
        return employee.Terminate(d);
    }

    @Override
    public String work() {
        return employee.work();
    }
    
}
    
