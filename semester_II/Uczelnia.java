public class Uczelnia {

    private String nazwaUczelni;
    private Student[] bazaStudentow = new Student[500];

    Uczelnia() {
        for(int i = 0;i < this.bazaStudentow.length;i++)
        {
            this.bazaStudentow[i] = null;
        }
        this.nazwaUczelni = "";
    }

    public void dodajStudenta(Student student) {
        for (int i = 0; i < this.bazaStudentow.length; i++)
            if (this.bazaStudentow[i] == null) {
                this.bazaStudentow[i] = student;
                break;
            }
    }

    public Student odczytajStudenta(int nrStudenta) {
        if (this.bazaStudentow[nrStudenta] == null)
            return null;
        return this.bazaStudentow[nrStudenta];
    }

    Student[] zaliczyliSesje() {
        int i = 0;

        while (odczytajStudenta(i) != null) {
            if (odczytajStudenta(i).zaliczonaSesja()) {
                System.out.println(i + " : " + odczytajStudenta(i).getImie() + " "
                        + odczytajStudenta(i).getNazwisko() + ", grupa: "
                        + odczytajStudenta(i).getGrupa());
            }
            i++;
        }
        return null;
    }


    /*
     * Student[] nieZaliczyliSesji() {
     * 
     * }
     * 
     * Student[] stypendia() {
     * 
     * }
     * 
     * Student[] grupa(String idGrupy) {
     * 
     * }
     */
}
