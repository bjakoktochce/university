/*
 * 2.1 Roczne przychody raz jeszcze
 * 
 * Bartosz Jakoktochce 
 * 
 */

package semester_I;

import java.util.*;

public class RocznePrzychodyRazJeszcze {

    static Scanner reader = new Scanner(System.in);

    public static double getMonthIncome(int month) {
        double income = 0;

        do {
            // as the array index starts with 0 and the first month is 1 increment it by 1
            // for proper printing
            month += 1;
            System.out.print("Income value for month " + month + ": ");

            income = reader.nextDouble();
            reader.nextLine();
            if (income < 0)
                System.out.println("ERROR: The income value can not be negative.");
        } while (income < 0);

        return income;
    }

    public static void main(String[] args) {

        System.out.println("This simple program calculates average, maximum and minimum month income.");

        double[] totalIncomeArray = new double[12];
        char menuKey;

        while (true) {
            wyswietl_menu();

            System.out.print("Choose youd option: ");
            menuKey = reader.next().charAt(0);
            reader.nextLine();

            switch (menuKey) {
                case '1':
                    wczytaj_dochody(totalIncomeArray);
                    break;
                case '2':
                    wyswietl_dochody(totalIncomeArray);
                    break;
                case '3':
                    System.out.println("Average income per month : " + srednia_suma_dochodow(totalIncomeArray));
                    break;
                case '4':
                    maksymalny_minimalny_dochod(totalIncomeArray);
                    break;
                case '5':
                    sortuj(totalIncomeArray);
                    break;
                case '6':
                    pod_nad_srednim_dochodem(totalIncomeArray);
                    break;
                case '0':
                    System.out.println("Thank you for using the program. Bye.");
                    System.exit(0);
                    break;
            } /* switch */
        }
    }

    private static void wyswietl_menu() {
        System.out.println();
        System.out.println("1 - Emter income");
        System.out.println("2 - Show income");
        System.out.println("3 - Average income");
        System.out.println("4 - Show maximum and minimum income");
        System.out.println("5 - View sorted income");
        System.out.println("6 - Show income above and below average");
        System.out.println("0 - Exit");
    }

    private static void pod_nad_srednim_dochodem(double[] totalIncomeArray) {
        double averageIncome = srednia_suma_dochodow(totalIncomeArray);

        System.out.println("Income below average " + averageIncome + ": ");

        // print all values below average
        for (double monthIncome : totalIncomeArray) {
            if (monthIncome < averageIncome)
                System.out.println(monthIncome);
        }

        // print all values above average
        System.out.println("Income above average " + averageIncome + ": ");
        for (double monthIncome : totalIncomeArray) {
            if (monthIncome > averageIncome)
                System.out.println(monthIncome);
        }
    }

    private static void sortuj(double[] totalIncomeArray) {
        // Arrays.sort(totalIncomeArray);

        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            double temporaryIncomeValue;

            for (int i = 0; i < totalIncomeArray.length - 1; i++) {
                if (totalIncomeArray[i] > totalIncomeArray[i + 1]) {
                    temporaryIncomeValue = totalIncomeArray[i];
                    totalIncomeArray[i] = totalIncomeArray[i + 1];
                    totalIncomeArray[i + 1] = temporaryIncomeValue;
                    sorted = false;
                }
            }
        }

        System.out.print(Arrays.toString(totalIncomeArray));
    }

    private static void maksymalny_minimalny_dochod(double[] totalIncomeArray) {
        double maxIncome = 0, minIncome = 0;

        for (int monthsCount = 0; monthsCount < 12; monthsCount++) {
            maxIncome = (totalIncomeArray[monthsCount] > maxIncome) ? totalIncomeArray[monthsCount] : maxIncome;
            minIncome = (totalIncomeArray[monthsCount] < maxIncome) ? totalIncomeArray[monthsCount] : minIncome;
        }

        System.out.println("Maximum income: " + maxIncome);
        System.out.println("Minimum income: " + minIncome);
    }

    private static double srednia_suma_dochodow(double[] totalIncomeArray) {
        double totalIncome = 0, averageIncome = 0;

        for (double monthIncome : totalIncomeArray)
            totalIncome += monthIncome;

        averageIncome = totalIncome / totalIncomeArray.length;

        return averageIncome;
    }

    private static void wyswietl_dochody(double[] totalIncomeArray) {
        int month = 1;

        for (double monthIncome : totalIncomeArray) {
            System.out.println("Income in month " + month + ": " + monthIncome);
            month++;
        }
    }

    private static void wczytaj_dochody(double[] totalIncomeArray) {
        for (int monthsCount = 0; monthsCount < 12; monthsCount++) {
            totalIncomeArray[monthsCount] = getMonthIncome(monthsCount);
        }
    }
}
