
class Employee {

private double salary;
private Person person;
private BankAccount bankAccount;
	
	public Employee(Person n, double s) {
		bankAccount = new BankAccountProxy("PeDeMeia", 0);
		person = n;
		salary = s;
	}

	public double getSalary() {
		return salary;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}
}