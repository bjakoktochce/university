import java.util.*;

public class Main {
    public static void main(String[] args) {

        Uczelnia uczelnia = new Uczelnia();

        System.out.println("Witaj w programie UCZELNIA!");
        System.out.println();

        Scanner reader = new Scanner(System.in);
        int menuChoice;

        while (true) {
            System.out.println("1. Dodaj studenta");
            System.out.println("2. Wprowadz ocene wskazanemu studentowi");
            System.out.println("3. Wyswietl liste ocen studenta");
            System.out.println("4. Usuniecie wskazanego studenta");
            System.out.println("5. Raporty");
            System.out.println();

            System.out.println("0. Wyjscie");
            System.out.println();
            System.out.print("Twoj wybor #: ");

            while (!reader.hasNextInt()) {
                System.out.println("Wprowadz wartosc liczbowa!");
                reader.next();
            }

            menuChoice = reader.nextInt();

            if (menuChoice < 0 || menuChoice > 5) {
                System.out.println("Podaj wartosc z przedzialu: 0-5");
            }

            Student student = new Student();
            int nrStudenta = 0;

            switch (menuChoice) {
            case 0:
                System.out.println("Dziekuje! Do widzenia!");
                reader.close();
                System.exit(0);
                break;

            case 1:
                reader.nextLine(); // just throw away \n

                System.out.print("Imie studenta :# ");
                String imie = reader.nextLine();
                student.setImie(imie);

                System.out.print("Nazwisko studenta :# ");
                String nazwisko = reader.nextLine();
                student.setNazwisko(nazwisko);

                System.out.print("Grupa :# ");
                String grupa = reader.nextLine();
                student.setGrupa(grupa);

                uczelnia.dodajStudenta(student);
                break;

            case 2:
                System.out.print("Podaj numer studenta :# ");
                reader.nextInt();

                if (uczelnia.odczytajStudenta(nrStudenta) == null) {
                    System.out.println("Error: Brak studentna o podanym numerze!");
                    System.out.println();
                    break;
                }

                System.out.println("Wpisujesz oceny studentowu: " + uczelnia.odczytajStudenta(nrStudenta).getImie() + uczelnia.odczytajStudenta(nrStudenta).getNazwisko());

                for (int i = 0;i < 5; i++) {
                    System.out.print("Podaj ocene do dodania :# ");

                    double ocena = reader.nextInt();

                    uczelnia.odczytajStudenta(nrStudenta).dodajOcene(ocena);
                }

                break;

            case 3:
                System.out.print("Podaj numer studenta :# ");
                nrStudenta = reader.nextInt();

                if (uczelnia.odczytajStudenta(nrStudenta) == null) {
                    System.out.println("Error: Brak studentna o podanym numerze!");
                    System.out.println();
                    break;
                }

                System.out.println("STUDENT: " + uczelnia.odczytajStudenta(nrStudenta).getNazwisko() + " " + uczelnia.odczytajStudenta(nrStudenta).getImie() + " grupa:  "
                        + uczelnia.odczytajStudenta(nrStudenta).getGrupa());

                System.out.print("LISTA OCEN: ");
                for (int i = 0;i <5; i++)
                    System.out.print(uczelnia.odczytajStudenta(nrStudenta).odczytajOcene(i) + " ");

                System.out.println("SREDNIA OCEN: " + uczelnia.odczytajStudenta(nrStudenta).sredniaOcen());

                System.out.print("SESJA: ");
                if (uczelnia.odczytajStudenta(nrStudenta).zaliczonaSesja())
                    System.out.println(" Zaliczona");
                else
                    System.out.println(" Niezaliczona");

                System.out.print("STYPENDIUM: ");
                if (uczelnia.odczytajStudenta(nrStudenta).stypendium())
                    System.out.println(" Przysluguje");
                else
                    System.out.println(" Nie przysluguje");


                System.out.println();
                break;

            case 4:
                System.out.print("Podaj numer studenta :# ");
                nrStudenta = reader.nextInt();

                if (uczelnia.odczytajStudenta(nrStudenta) == null) {
                    System.out.println("Error: Brak studentna o podanym numerze!");
                    System.out.println();
                    break;
                }
                break;

            case 5:
                System.out.println("Raporty");
                System.out.println("1. Lista wszystkich studentow");
                System.out.println("2. Lista studentow ze wskazanej grupy");
                System.out.println("3. Lista studentow, ktorzy zaliczyli sesje");
                System.out.println("4. Lista studentow, ktorzy nie zaliczyli sesji");
                System.out.println("5. Lista studentow, ktorym przysluguje stypendium");
                System.out.println();

                System.out.println("0. Wroc do menu glownego");
                System.out.println();
                System.out.print("Twoj wybor #: ");

                while (!reader.hasNextInt()) {
                    System.out.println("Wprowadz wartosc liczbowa!");
                    reader.next();
                }

                menuChoice = reader.nextInt();

                if (menuChoice < 0 || menuChoice > 5) {
                    System.out.println("Podaj wartosc z przedzialu: 0-5");
                }

                int i = 0;

                switch (menuChoice) {
                case 0:
                    break;

                case 1:
                    System.out.println("*** LISTA WSZYSTKICH STUDENTOW ***");
                    while (uczelnia.odczytajStudenta(i) != null) {
                        System.out.println(i + " : " + uczelnia.odczytajStudenta(i).getImie() + " "
                                + uczelnia.odczytajStudenta(i).getNazwisko() + ", grupa: "
                                + uczelnia.odczytajStudenta(i).getGrupa());
                        i++;
                    }
                    System.out.println();
                    break;

                case 2:
                    reader.nextLine();
                    System.out.print("Grupa :# ");
                    grupa = reader.nextLine();

                    System.out.println("*** LISTA STUDENTOW Z GRUPY: " + grupa + " ***");

                    while (uczelnia.odczytajStudenta(i) != null) {
                        if (uczelnia.odczytajStudenta(i).getGrupa().contentEquals(grupa)) {
                            System.out.println(i + " : " + uczelnia.odczytajStudenta(i).getImie() + " "
                                    + uczelnia.odczytajStudenta(i).getNazwisko() + ", grupa: "
                                    + uczelnia.odczytajStudenta(i).getGrupa());
                        }
                        i++;
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println("*** LISTA STUDENTOW, KTORZY ZALICZYLI SESJE ***");
                    while (uczelnia.odczytajStudenta(i) != null) {
                        if (uczelnia.odczytajStudenta(i).zaliczonaSesja()) {
                            System.out.println(i + " : " + uczelnia.odczytajStudenta(i).getImie() + " "
                                    + uczelnia.odczytajStudenta(i).getNazwisko() + ", grupa: "
                                    + uczelnia.odczytajStudenta(i).getGrupa());
                        }
                        i++;
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("*** LISTA STUDENTOW, KTORZY NIE ZALICZYLI SESJI ***");
                    while (uczelnia.odczytajStudenta(i) != null) {
                        if (!uczelnia.odczytajStudenta(i).zaliczonaSesja()) {
                            System.out.println(i + " : " + uczelnia.odczytajStudenta(i).getImie() + " "
                                    + uczelnia.odczytajStudenta(i).getNazwisko() + ", grupa: "
                                    + uczelnia.odczytajStudenta(i).getGrupa());
                        }
                        i++;
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("*** LISTA STUDENTOW, KTORYM PRZYSLUGUJE STYPENDIUM ***");
                    while (uczelnia.odczytajStudenta(i) != null) {
                        if (uczelnia.odczytajStudenta(i).stypendium()) {
                            System.out.println(i + " : " + uczelnia.odczytajStudenta(i).getImie() + " "
                                    + uczelnia.odczytajStudenta(i).getNazwisko() + ", grupa: "
                                    + uczelnia.odczytajStudenta(i).getGrupa() + " srednia ocen: " + uczelnia.odczytajStudenta(i).sredniaOcen());
                        }
                        i++;
                    }
                    System.out.println();
                    break;
                }
                break;

            }

        }

    }
}
