public class Student {

    private String imie, nazwisko, grupa;
    private double[] oceny;

    Student() {
        this.imie = "";
        this.nazwisko = "";
        this.grupa = "";
        this.oceny = new double[5];
    }

    int dodajOcene(double ocena) {
        for (int i = 0; i < this.oceny.length; i++)
            if (this.oceny[i] == 0) {
                this.oceny[i] = ocena;
                break;
            }
        return 0;
    }

    double odczytajOcene(int nrOceny) {
        if (nrOceny >= this.oceny.length) {
            return -1;
        }

        if (oceny[nrOceny] == 0) {
            return -1;
        }

        return oceny[nrOceny];
    }

    double sredniaOcen() {
        double sumaOcen = 0;

        for (int i = 0; i < this.oceny.length; i++) {
            sumaOcen += oceny[i];
        }
        return sumaOcen / oceny.length;
    }

    boolean zaliczonaSesja() {
        for (int i = 0; i < this.oceny.length; i++) {
            if (oceny[i] <= 2)
                return false;
        }
        return true;
    }

    boolean stypendium() {
        if (zaliczonaSesja() == true && sredniaOcen() >= 4.5) {
            return true;
        }
        return false;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return this.imie;
    }

    public String getNazwisko() {
        return this.nazwisko;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getGrupa() {
        return this.grupa;
    }
}
