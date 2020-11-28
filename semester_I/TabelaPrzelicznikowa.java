/*
 * 1.2 Tabela przelicznikowa odległości
 * 
 * Bartosz Jakoktochce 
 */ 

import java.util.*;

public class TabelaPrzelicznikowa {

    public static double recalculate(double length, double recalculateValue) {
        return length * recalculateValue;
    }

    static Scanner reader = new Scanner(System.in);

    public static double getValue(String prompt) {
        double initialValue = 0;

        do {
            System.out.print(prompt);
            
            initialValue = reader.nextDouble();      
            reader.nextLine();    
            if (initialValue < 0) System.out.println("ERROR: The value can not be negative.");   
        }
        while (initialValue < 0);

        return initialValue;
    }

    public static void main(String[] args) {
        final double toFeet = 3.2808399;
        final double toMiles = 0.000621371192;
        final double toYards = 1.0936133;
        final double toInches = 39.3700787;

        System.out.println("This program calculates length table for: meters. feet, inches, yards and miles.");

        double length = 0;
        double initialValue, finalValue = 0;
        double stepValue = 0;

        initialValue = getValue("Please enter initial value for length table: ");
        finalValue = getValue("Please enter final value: ");
        stepValue = getValue("Please enter step value: ");

        // the step value could not be equal zero as this won't be a table of values
        if (stepValue == 0)  {
            System.out.println("ERROR: Step value must be greater than: 0!");
        }
        else {

            int rows = 0;
            
            for (length = initialValue; length <=finalValue; length+=stepValue) {
                System.out.printf(length + "[m] is equal to: %.4f[inches],  %.4f[feet], %.4f[yards],  %.4f[miles]\n ", recalculate(length, toInches), recalculate(length, toFeet), recalculate(length, toYards), recalculate(length, toMiles) );
               
                rows++;

                // if there're many rows just pause listing after 24 rows
                if(rows == 24) {
                    System.out.println("Press enter to continue.");
                    reader.nextLine();
                    rows = 0;
                }
            }
        }

        System.exit(0);
    }

}
