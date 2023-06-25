public class TestPart1 {
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        System.out.println("Alinea a) ----------------------------------------------------------");

        try {
            Student st1 = new Student("John", 97856, Course.LEI); 
            StudentAdm sAdm1 = new StudentAdm(st1);

            Director dir = new Director(sAdm1, Course.LEI);
            Professor prof1 = new Professor(sAdm1, "Mary", "Programming");
            Professor prof2 = new Professor(sAdm1, "Peter", "DB");
            Professor prof3 = new Professor(sAdm1, "Rute", "PDS");

            sAdm1.addScore("Programming", 16.0);
            sAdm1.addScore("DB",  15.0);
            sAdm1.addScore("PDS", 17.0);
 
            Student st2 = new Student("Silvester", 89855, Course.LEEC);
            StudentAdm sAdm2 = new StudentAdm(st2); 
            Director dir2 = new Director(sAdm2, Course.LECI);

                    
        } catch (Exception e) {
            System.out.println("Error: " +  e.getMessage());
        }

        System.out.println("* The end...");
        System.out.println();

    }
    
}

/*
 *  Expected Output:
LEI director reports that student John (97856) has changed the overall grade: 16.0
Professor Mary of Programming class evaluated student John (97856) with score: 16.0
LEI director reports that student John (97856) has changed the overall grade: 15.5
Professor Mary of Programming class evaluated student John (97856) with score: 16.0
Professor Peter of DB class evaluated student John (97856) with score: 15.0
LEI director reports that student John (97856) has changed the overall grade: 16.0
Professor Mary of Programming class evaluated student John (97856) with score: 16.0
Professor Peter of DB class evaluated student John (97856) with score: 15.0
Professor Rute of PDS class evaluated student John (97856) with score: 17.0
Error: Director's course must be the same as student's course
* The end...
*/