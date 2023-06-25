import java.util.ArrayList;
import java.util.List;

public class StudentAdm {
    private Student student;
    private List<Monitor> monitors = new ArrayList<>();


    public StudentAdm(Student stud) {
        this.student = stud;
    }

    public void addScore(String className, double score) {
        student.addScore(className, (Double) score);
        notifyObs(className);
    }

    public Student getStudent() {
        return student;
    }

    public void attach(Monitor m) {
        monitors.add(m);
    }

    private void notifyObs(String className) {
        for (Monitor m : monitors) {
            if (m.getType() == "Director")
                m.update(this);
            else 
                m.update(this);
        }
    }
    
}








