package Ex1;

public class Adapter extends Database{

    private Registos reg;
    private Database db;

    public Adapter(Registos reg, Database db) {
        this.reg = reg;
        this.db = db;
    }

    @Override
    public void deleteEmployee(long emp_num) {
        reg.remove((int) emp_num);
        db.deleteEmployee(emp_num);

    }

    public boolean isEmployee (long emp_num) {
        for (int i = 0; i < reg.listaDeEmpregados().size(); i++) {
            if (reg.listaDeEmpregados().get(i).codigo() == emp_num) {
                return true;
            }
        }
        for (int i = 0; i < db.getAllEmployees().length; i++) {
            if (db.getAllEmployees()[i].getEmpNum() == emp_num) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Employee[] getAllEmployees() {
        Employee[] emp = new Employee[reg.listaDeEmpregados().size()+db.getAllEmployees().length];
        int counter = reg.listaDeEmpregados().size();
        for (int i = 0; i < reg.listaDeEmpregados().size(); i++) {
            emp[i] = new Employee(reg.listaDeEmpregados().get(i).nome(), reg.listaDeEmpregados().get(i).codigo(), reg.listaDeEmpregados().get(i).salario());
        }
        for (int i = 0; i < db.getAllEmployees().length; i++) {
            emp[counter] = db.getAllEmployees()[i];
            counter++;
        }
        return emp;
    }
    
}
