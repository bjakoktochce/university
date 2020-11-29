/*
 * 2.1 Roczne przychody
 * 
 * Bartosz Jakoktochce 
 */

package semester_I;

import java.util.*;

public class RocznePrzychody {

    static Scanner reader = new Scanner(System.in);

    public static double getMonthIncome(int month) {
        double income = 0;

        do {
            System.out.print("Income value for month " + month + ": ");

            income = reader.nextDouble();
            reader.nextLine();
            if (income < 0)
                System.out.println("ERROR: The income value can not be negative.");
        } while (income < 0);

        return income;
    }

    public static void main(String[] args) {

        System.out.println("This simple program calculates average, maximum and minimum month income.\n");

        double monthIncome = 0, averageMonthIncome = 0, totalIncome = 0;
        double minIncome = 0, maxIncome = 0;
        int totalMonthCount = 0, monthsCount = 0;

        do {
            System.out.print(("Please enter number of months (0 to exit): "));

            totalMonthCount = reader.nextInt();
            reader.nextLine();

            if (totalMonthCount == 0) {
                System.out.println("Thank you for using this simple months income calculator.");
                System.exit(0);
            }
            if (totalMonthCount < 0)
                System.out.println("ERROR: Number of months could not be negative.");
        } while (totalMonthCount < 0);

        for (monthsCount = 1; monthsCount <= totalMonthCount; monthsCount++) {
            monthIncome = getMonthIncome(monthsCount);

            // if this is the first loop run assign the first entered value as minimum one
            // to overwrite initialized value
            if (monthsCount == 1)
                minIncome = monthIncome;

            maxIncome = (monthIncome > maxIncome) ? monthIncome : maxIncome;
            minIncome = (monthIncome < maxIncome) ? monthIncome : minIncome;

            totalIncome += monthIncome;
        }

        averageMonthIncome = totalIncome / totalMonthCount;

        System.out.println("* Total income: " + totalIncome);
        System.out.println(
                "* Average month income for " + totalMonthCount + " months is: " + averageMonthIncome + " per month.");
        System.out.println("* Maximum month income is: " + maxIncome);
        System.out.println("* Minimum month income is: " + minIncome);

        System.out.println("\nThank you for using this simple months income calculator.");
    }
}
