package Ex1;

import java.util.Date;

public class TeamLeader extends EmployeeDecorator{

    public TeamLeader(EmployeeInterface employee) {
        super(employee);
    }
    
    @Override
    public String Start(Date d) {
        return super.Start(d) + " as a team leader";
    }

    @Override
    public String Terminate(Date d) {
        return super.Terminate(d) + " as a team leader";
    }

    @Override
    public String work() {
        return super.work() + " as a team leader";
    }

    public String plan(){
        return "I am planning";
    }
    
}
