/*
 * Bartosz B.Jakoktochce
 */

public class Uczelnia {

    private String nazwaUczelni;

    private final int iloscStudentow = 500;
    private Student[] bazaStudentow = new Student[iloscStudentow];

    Uczelnia() {
        for (int i = 0; i < this.bazaStudentow.length; i++) {
            this.bazaStudentow[i] = null;
        }
        this.nazwaUczelni = "";
    }

    public int dodajStudenta(Student student) {
        for (int i = 0; i < this.bazaStudentow.length; i++)
            if (this.bazaStudentow[i] == null) {
                this.bazaStudentow[i] = student;
                return 1;
            }
        return -1;
    }

    public Student odczytajStudenta(int nrStudenta) {
        if (nrStudenta >= this.bazaStudentow.length)
            return null;

        if (this.bazaStudentow[nrStudenta] == null)
            return null;

        return this.bazaStudentow[nrStudenta];
    }

    public Student[] zaliczyliSesje() {
        int i = 0, n = 0;

        Student[] studenci = new Student[iloscStudentow];

        while (odczytajStudenta(i) != null) {
            if (odczytajStudenta(i).zaliczonaSesja()) {
                studenci[n] = odczytajStudenta(i);
                n++;
            }
            i++;
        }
        return studenci;
    }

    public Student[] nieZaliczyliSesji() {
        int i = 0, n = 0;

        Student[] studenci = new Student[iloscStudentow];

        while (odczytajStudenta(i) != null) {
            if (!odczytajStudenta(i).zaliczonaSesja()) {
                studenci[n] = odczytajStudenta(i);
                n++;
            }
            i++;
        }
        return studenci;
    }

    public Student[] stypendia() {
        int i = 0, n = 0;

        Student[] studenci = new Student[iloscStudentow];

        while (odczytajStudenta(i) != null) {
            if (odczytajStudenta(i).stypendium()) {
                studenci[n] = odczytajStudenta(i);
                n++;
            }
            i++;
        }
        return studenci;
    }

    public Student[] grupa(String idGrupy) {
        int i = 0, n = 0;

        Student[] studenci = new Student[iloscStudentow];

        while (odczytajStudenta(i) != null) {
            if (odczytajStudenta(i).getGrupa().equals(idGrupy)) {
                studenci[n] = odczytajStudenta(i);
                n++;
            }
            i++;
        }
        return studenci;
    }

    public int usunStudenta(int nrStudenta) {
        if (this.bazaStudentow[nrStudenta] == null)
            return -1;

        this.bazaStudentow[nrStudenta] = null;
        return 0;
    }

    public Student[] listaStudentow() {
        return this.bazaStudentow;
    }
}
