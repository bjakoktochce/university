package semester_I;

class Samochod {
    private int vMax;
    private double paliwoWZbiorniku, zuzycieNa100km;

    Samochod() {
        vMax = 140;
        paliwoWZbiorniku = 50;
        zuzycieNa100km = 5;
    }

    Samochod(int vMax, double paliwoWZbiorniku, double zuzycieNa100km) {
        this.vMax = vMax;
        this.paliwoWZbiorniku = paliwoWZbiorniku;
        this.zuzycieNa100km = zuzycieNa100km;
    }

    public double zasieg() {
        return (paliwoWZbiorniku / zuzycieNa100km) * 100;
    }

    public double czasDojazdu(double dystans) {
        return dystans / (0.75 * vMax) * 60;
    }

    public void zatankuj(double ilePaliwaZatankowac) {
        paliwoWZbiorniku += ilePaliwaZatankowac;
    }

    public void trasa(double liczbaKilometrow) {
        paliwoWZbiorniku = paliwoWZbiorniku - (zuzycieNa100km * liczbaKilometrow / 100);
    }

    public double getPaliwoWzbiorniku() {
        return paliwoWZbiorniku;
    }

    public void setPaliwoWzbiorniku(double paliwoWZbiorniku) {
        this.paliwoWZbiorniku = paliwoWZbiorniku;
    }

    public double getZuzycieNa100km() {
        return zuzycieNa100km;
    }

    public void setZuzycieNa100km(double zuzycieNa100km) {
        this.zuzycieNa100km = zuzycieNa100km;
    }

    public int getvMax() {
        return vMax;
    }

    public void setvMax(int vMax) {
        this.vMax = vMax;
    }

}

public class Klasy {

    public static void main(String[] args) {

        Samochod samochodOsobowy = new Samochod();
        Samochod samochodCiezarowy = new Samochod(80, 1000.0, 50.0);

        System.out.println(
                "W samochodzie osobowym mamy w zbiorniku: " + samochodOsobowy.getPaliwoWzbiorniku() + " litrow");
        System.out.println("Zasieg na tym paliwie: " + samochodOsobowy.zasieg() + " km");
        System.out.println("Czas przejazdu 100km: " + samochodOsobowy.czasDojazdu(100) + " min");
        samochodOsobowy.zatankuj(40);
        System.out.println("Po zatankowaniu w samochodzie osobowym mamy w zbiorniku: "
                + samochodOsobowy.getPaliwoWzbiorniku() + " km");
        System.out.println("Zasieg na paliwie po zatankowaniu: " + samochodOsobowy.zasieg() + " km");
        samochodOsobowy.trasa(1800);
        System.out.println(
                "Po przejechaniu 1800 km mamy w zbiorniku: " + samochodOsobowy.getPaliwoWzbiorniku() + " litrow");
        System.out.println("Przejedziemy na tym paliwie: " + samochodOsobowy.zasieg() + " km");

        System.out.println();

        System.out.println(
                "W samochodzie ciezarowy mamy w zbiorniku: " + samochodCiezarowy.getPaliwoWzbiorniku() + " litrow");
        System.out.println("Zasieg na tym paliwie: " + samochodCiezarowy.zasieg() + " km");
        System.out.println("Czas przejazdu 100km: " + samochodCiezarowy.czasDojazdu(100) + " min");
        samochodOsobowy.zatankuj(400);
        System.out.println("Po zatankowaniu w samochodzie ciezarowym mamy w zbiorniku: "
                + samochodCiezarowy.getPaliwoWzbiorniku() + " km");
        System.out.println("Zasieg na paliwie po zatankowaniu: " + samochodCiezarowy.zasieg() + " km");
        samochodCiezarowy.trasa(1800);
        System.out.println(
                "Po przejechaniu 1800 km mamy w zbiorniku: " + samochodCiezarowy.getPaliwoWzbiorniku() + " litrow");
        System.out.println("Przejedziemy na tym paliwie: " + samochodCiezarowy.zasieg() + " km");

    }

}