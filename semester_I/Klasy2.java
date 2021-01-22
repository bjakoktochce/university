package semester_I;

import java.lang.Math;

abstract class Figura {

    abstract public double pole();

    abstract public double obwod();
}

class Kolo extends Figura {
    private double promien;

    Kolo() {
        promien = 2;
    }

    Kolo(double promien) {
        this.promien = promien;
    }

    public double pole() {
        return Math.PI * (promien * promien);
    }

    public double obwod() {
        return 2 * Math.PI * promien;
    }
}

class Kwadrat extends Figura {
    private double bok;

    Kwadrat() {
        this.bok = 2;
    }

    Kwadrat(double bok) {
        this.bok = bok;
    }

    public double pole() {
        return bok * bok;
    }

    public double obwod() {
        return bok * 4;
    }
}

class Prostokat extends Figura {
    private double bokA, bokB;

    Prostokat() {
        this.bokA = 1;
        this.bokB = 2;
    }

    Prostokat(double bokA, double bokB) {
        this.bokA = bokA;
        this.bokB = bokB;
    }

    public double pole() {
        return bokA * bokB;
    }

    public double obwod() {
        return 2 * bokA + 2 * bokB;
    }
}

public class Klasy2 {

    public static void main(String[] args) {

        Kolo kolo1 = new Kolo();
        Kolo kolo2 = new Kolo(10);

        System.out.println("Obwod Kolo 1: " + kolo1.obwod());
        System.out.println("Pole Kolo 1: " + kolo1.pole());
        System.out.println("Obwod Kolo 2: " + kolo2.obwod());
        System.out.println("Pole Kolo 2: " + kolo2.pole());

        Kwadrat kwadrat1 = new Kwadrat();
        Kwadrat kwadrat2 = new Kwadrat(10);

        System.out.println();
        System.out.println("Obwod Kwadrat 1: " + kwadrat1.obwod());
        System.out.println("Pole Kwadrat 1: " + kwadrat1.pole());
        System.out.println("Obwod Kwadrat 2: " + kwadrat2.obwod());
        System.out.println("Pole Kwadrat 2: " + kwadrat2.pole());

        Prostokat prostokat1 = new Prostokat();
        Prostokat prostokat2 = new Prostokat(10, 5);

        System.out.println();
        System.out.println("Obwod Prostokat 1: " + prostokat1.obwod());
        System.out.println("Pole Prostokat 1:" + prostokat1.pole());
        System.out.println("Obwod Prostokat 2: " + prostokat2.obwod());
        System.out.println("Pole Prostokat 2: " + prostokat2.pole());
    }
}