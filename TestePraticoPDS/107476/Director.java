public class Director extends Monitor{
    private Course degreeName;

    public Director (StudentAdm stud, Course course) {
        if (degreeName != stud.getStudent().getCourse()){
            System.out.println("Error: Directors course must be the same as student course");
        }
        this.degreeName = course;
        stud.attach(this);
    }

    public Director (Course course){
        this.degreeName = course;
    }

    public void update(StudentAdm adm) {
        System.out.println(degreeName + " director reports that student" + adm.getStudent().getName() + " (" + adm.getStudent().getId() + ") has changed the overall grade:" + adm.getStudent().getOverallGrade());
    }

    public Course getCourseName() {
        return degreeName;
    }

    public String getClassName(){
        return "";
    }

    public String getType(){
        return "Director";
    }

}
