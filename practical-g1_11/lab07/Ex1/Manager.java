package Ex1;

import java.util.Date;

public class Manager extends EmployeeDecorator{

    public Manager(EmployeeInterface employee) {
        super(employee);
    }
    
    @Override
    public String Start(Date d) {
        return super.Start(d) + " as a manager";
    }

    @Override
    public String Terminate(Date d) {
        return super.Terminate(d) + " as a manager";
    }

    @Override
    public String work() {
        return super.work() + " as a manager";
    }

    public String manage(){
        return "I am managing";
    }
    
}
