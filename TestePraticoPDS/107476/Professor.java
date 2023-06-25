
public class Professor extends Monitor{
    private String className;
    private String name;

    //private List<StudentAdm> students = new ArrayList<>();

    public Professor(StudentAdm adm, String name, String className) {
        this.name = name;
        this.className = className;
        adm.attach(this);
    }

    public void update(StudentAdm adm) {
        if (adm.getStudent().getScore(className) != null)
            System.out.println("Professor " + name + " of " + className + " class evaluated student " + adm.getStudent().getName() + " (" + adm.getStudent().getId() + ") with score:" + adm.getStudent().getScore(className));
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public String getType(){
        return "Professor";
    }

}
