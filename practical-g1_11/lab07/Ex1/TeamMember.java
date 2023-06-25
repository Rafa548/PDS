package Ex1;

import java.util.Date;

public class TeamMember extends EmployeeDecorator{

    public TeamMember(EmployeeInterface employee) {
        super(employee);
    }
    
    @Override
    public String Start(Date d) {
        return super.Start(d) + " as a team member";
    }

    @Override
    public String Terminate(Date d) {
        return super.Terminate(d) + " as a team member";
    }

    @Override
    public String work() {
        return super.work() + " as a team member";
    }
     
    public String colaborate() {
        return "I am colaborating";
    }

}
