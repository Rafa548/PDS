package Ex1;

import java.util.Date;

public class Test {
    
    public static void main(String[] args) {
        EmployeeInterface e = new Employee("John");
        Manager m = new Manager(new Employee("Zé"));
        TeamLeader tl = new TeamLeader(e);
        TeamMember tm = new TeamMember(tl);

        Manager m2 = new Manager(new TeamLeader(new TeamMember(new Employee("Maria"))));

        EmployeeInterface lista[] = {e, m, tl, tm, m2};

        for (EmployeeInterface employeeInterface : lista) {

            
            System.out.println(employeeInterface.Start(new Date()));
            System.out.println(employeeInterface.work());

            if(employeeInterface instanceof Manager){
                System.out.println(((Manager) employeeInterface).manage());
            }
            if(employeeInterface instanceof TeamLeader){
                System.out.println(((TeamLeader) employeeInterface).plan());
            }
            if(employeeInterface instanceof TeamMember){
                System.out.println(((TeamMember) employeeInterface).colaborate());
            }
            System.out.println(employeeInterface.Terminate(new Date()));
            System.out.println();
        }
    }
}
