/*
 * 3.1 Figury plaskie
 * 
 * Bartosz Jakoktochce 
 */

import java.util.Scanner;

public class FiguryPlaskie {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Program sluzacy do obliczania pola i obwodu figur geomentrycznych plaskich.");

        int wyborFigury;

        do {
            menu();
            System.out.print("Wybierz opcję: ");
            wyborFigury = sc.nextInt();
            sc.nextLine();

            switch (wyborFigury) {
                case 1:
                    obliczeniaDlaKwadratu();
                    break;
                case 2:
                    obliczeniaDlaProstokata();
                    break;
                case 3:
                    obliczeniaDlaKola();
                    break;
                case 0:
                    System.out.println("Do widzenia");
                    break;
                default:
                    System.out.println("Nie ma takiej figury");
            }
        } while (wyborFigury != 0);
    }

    public static void menu() {
        System.out.println();
        System.out.println("1 - kwadrat");
        System.out.println("2 - prostokąt");
        System.out.println("3 - koło");
        System.out.println("0 - koniec");
    }

    public static void obliczeniaDlaKwadratu() {
        int wybor = obliczeniaDlaFigury();

        System.out.println();
        System.out.println("Podaj dane kwadratu");

        double bok = pobierzWartosc("Podaj dlugosc boku: ");

        switch (wybor) {
            case 1:
                System.out.println("Pole kwadratu wynosi: " + poleKwadratu(bok));
                break;
            case 2:
                System.out.println("Obwod kwadratu wynosi: " + obwodKwadratu(bok));
                break;
        }
    }

    public static void obliczeniaDlaProstokata() {
        int wybor = obliczeniaDlaFigury();

        System.out.println("Podaj dane prostokąta");
        double a = pobierzWartosc("Podaj dlugosc boku a:");
        double b = pobierzWartosc("Podaj dlugosc boku b: ");

        switch (wybor) {
            case 1:
                System.out.println("Pole prostokata wynosi: " + poleProstokata(a, b));
                break;
            case 2:
                System.out.println("Obwod prostokata wynosi: " + obwodProstokata(a, b));
                break;
        }
    }

    public static void obliczeniaDlaKola() {
        int wybor = obliczeniaDlaFigury();

        System.out.println("Podaj dane koła");
        double r = pobierzWartosc("Podaj dlugosc promienia r:");

        switch (wybor) {
            case 1:
                System.out.println("Pole kola wynosi: " + poleKola(r));
                break;
            case 2:
                System.out.println("Obwod kola wynosi: " + obwodKola(r));
                break;
        }
    }

    public static int obliczeniaDlaFigury() {
        int wybor;

        do {
            System.out.println();
            System.out.println("1 - pole powierzchni");
            System.out.println("2 - obwód");
            System.out.print("Wybierz co liczymy: ");

            wybor = sc.nextInt();
            sc.nextLine();

            if ((wybor < 1) || (wybor > 2))
                System.out.println("*** ERROR: Nie ma takiej opcji.\n");

        } while ((wybor != 1) && (wybor != 2));
        return wybor;
    }

    public static double pobierzWartosc(String prompt) {
        double wartosc = 0;

        do {
            System.out.print(prompt);

            wartosc = sc.nextDouble();
            sc.nextLine();

            if (wartosc < 0)
                System.out.println("*** ERROR: Wartosc nie moze byc ujemna.\n");
            if (wartosc == 0)
                System.out.println("*** ERROR: Wartosc nie moze byc rowna zero.\n");

        } while (wartosc <= 0);

        return wartosc;
    }

    public static double poleKwadratu(double bok) {
        return bok * bok;
    }

    public static double obwodKwadratu(double bok) {
        return 4 * bok;
    }

    public static double poleProstokata(double a, double b) {
        return a * b;
    }

    public static double obwodProstokata(double a, double b) {
        return 2 * a + 2 * b;
    }

    public static double poleKola(double r) {
        return Math.PI * Math.pow(r, 2);
    }

    public static double obwodKola(double r) {
        return 2 * Math.PI * r;
    }
}
