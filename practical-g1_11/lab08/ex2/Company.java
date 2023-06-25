import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



class Company implements Facade{
	private SocialSecurity ss = new SocialSecurity();
	private Insurance ins = new Insurance();
	Parking p = new Parking();	
	private int nemployees = 0;
	private int averagesalary = 0;

	private List<Employee> emps = new ArrayList<>();

	public void admitEmployee(String name, double salary) {
		Employee e = new Employee(name, salary);
		nemployees++;
		averagesalary = (averagesalary * nemployees + (int) salary) / (nemployees + 1);
		EmpCard(e);
		ss.regist(e);
		ins.regist(e);
		if (salary > averagesalary) {
			p.allow(e);
		}
		emps.add(e);
	}

	public String EmpCard(Employee e) {
		return e.getName() + " earns " + e.getSalary();
	}
	
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}
}