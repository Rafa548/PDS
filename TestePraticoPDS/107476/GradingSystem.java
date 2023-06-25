import java.util.ArrayList;
import java.util.List;

// GradingSystem class
public class GradingSystem {
    List<StudentAdm> studentsAdm = new ArrayList<>();
    List<Director> directs = new ArrayList<>();
    List<Professor> profs = new ArrayList<>();

    // Add a student to the system
    // The director of student's course is added as Monitor
    public StudentAdm addStudent(Student student) {
        StudentAdm studentAdm = new StudentAdm(student);
        studentsAdm.add(studentAdm);
        for (Director d: directs) {
            if (d.getCourseName() == studentAdm.getStudent().getCourse())
                studentAdm.attach(d);
        }
        return studentAdm;
    }   

    // Add a director to the system
    // The director is added as monitor of the students in the same course
    public void addDirector(Course course) {
        Director d = new Director(course);
        directs.add(d);
        for (StudentAdm s_adm: studentsAdm){
            if (d.getCourseName() == s_adm.getStudent().getCourse())
            s_adm.attach(d);
        }
    } 

    public void addProfessor(Professor professor) {
        profs.add(professor);
    }

    public void ListLei(){
        VectorGeneric<StudentAdm> vec = new VectorGeneric<StudentAdm>();
        for (int i = 0; i < studentsAdm.size(); i++) {
            if (studentsAdm.get(i).getStudent().getCourse() == Course.LEI)
                vec.addElem(studentsAdm.get(i));
        }
        java.util.Iterator<StudentAdm> it = vec.iterator();
        while (it.hasNext()) {
            StudentAdm stdm = it.next();
            String name = stdm.getStudent().getName();
            int id = stdm.getStudent().getId();
            System.out.println(name + " " + "(" + id + ")");
        }
    }


    public List<Director> getDirectors() {
        return directs;
    }

    public List<Professor> getProfessors() {
        return profs;
    }

}