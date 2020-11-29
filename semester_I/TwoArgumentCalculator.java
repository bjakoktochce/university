/*
 * 1.3 Kalkulator dwuargumentowy
 * 
 * Bartosz Jakoktochce 
 */

package semester_I;

import java.util.*;

public class TwoArgumentCalculator {

    static Scanner reader = new Scanner(System.in);

    public static double getValue() {
        double meters = 0;

        do {
            System.out.print("\nValue in [meters] to be calculated (0 to quit): ");

            meters = reader.nextDouble();
            reader.nextLine();
            if (meters < 0)
                System.out.println("ERROR: The value can not be negative.");
        } while (meters < 0);

        return meters;
    }

    public static void main(String[] args) {

        System.out.println("This simple calculator will calculate two values entered by the user.");

        double firstValue, secondValue, calculatedValue = 0;
        char mathOperation, exitOrNot;

        do {
            System.out.print("Plaase enter first value: ");
            firstValue = reader.nextDouble();

            System.out.print("Please enter second value: ");
            secondValue = reader.nextDouble();

            System.out.println(" + for addition, - for substraction, * for multiplying,  / for dividing");
            System.out.print("Your choice: ");

            mathOperation = reader.next().charAt(0);

            switch (mathOperation) {
                case '+': {
                    calculatedValue = firstValue + secondValue;
                    System.out.println("Calculated value: " + calculatedValue);
                    break;
                }
                case '-': {
                    calculatedValue = firstValue - secondValue;
                    System.out.println("Calculated value: " + calculatedValue);
                    break;
                }
                case '*': {
                    calculatedValue = firstValue * secondValue;
                    System.out.println("Calculated value: " + calculatedValue);
                    break;
                }
                case '/': {
                    if (secondValue != 0) {
                        calculatedValue = firstValue / secondValue;
                        System.out.println("Calculated value: " + calculatedValue);
                    } else {
                        System.out.println("ERROR: Could not divide by zero");
                    }
                    break;
                }
            }

            System.out.print("Do you want to make calculations once again? y/n : ");
            exitOrNot = reader.next().charAt(0);
        } while (exitOrNot == 'y');

        System.out.println("Thank you for using this simple calculator.");
    }
}
