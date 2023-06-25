package Ex1;

public class Main {
    public static void main(String[] args) {
        //test adapter
        Registos reg = new Registos();
        Empregado emp = new Empregado("Joao", "Silva", 123, 1000);
        reg.insere(emp);
        Empregado emp2 = new Empregado("Maria", "Silva", 124, 1000);
        reg.insere(emp2);
        Empregado emp3 = new Empregado("Pedro", "Silva", 125, 1000);
        reg.insere(emp3);
        Database db = new Database();
        Employee emp4 = new Employee("Antonio", 126, 1000);
        db.addEmployee(emp4);
        Employee emp5 = new Employee("Belchior", 127, 1000);
        db.addEmployee(emp5);
        Employee emp6 = new Employee("Luis", 128, 1000);
        db.addEmployee(emp6);

        Adapter adapter = new Adapter(reg, db);
        Employee[] empregados = adapter.getAllEmployees();
        
        System.out.println("Before delete\n");
        for (int i = 0; i < empregados.length; i++) {
            System.out.println(empregados[i].getName());
        }
        adapter.deleteEmployee(126);
        adapter.deleteEmployee(123);
        System.out.println("\nAfter delete\n");

        empregados = adapter.getAllEmployees();
        for (int i = 0; i < empregados.length; i++) {
            System.out.println(empregados[i].getName());
        }
        System.out.println();
        System.out.println(adapter.isEmployee(123));
        System.out.println(adapter.isEmployee(124));
        System.out.println(adapter.isEmployee(126));

    }
    
}
