/*
 * 1.1 Przeliczanie jednostek odległości
 * 
 * Bartosz Jakoktochce 
 */ 

import java.util.*;

public class LengthCalculator {

    public static double recalculate(double length, double recalculateValue) {
        return length * recalculateValue;
    }

    static Scanner reader = new Scanner(System.in);

    public static double getMeters() {
        double meters = 0;

        do {
            System.out.print("\nValue in [meters] to be calculated (0 to quit): ");
            
            meters = reader.nextDouble();      
            reader.nextLine();    
            if (meters < 0) System.out.println("ERROR: The value can not be negative.");   
        }
        while (meters < 0);
        
        return meters;
    }

    public static void main(String[] args) {
        final double toFeet = 3.2808399;
        final double toMiles = 0.000621371192;
        final double toYards = 1.0936133;
        final double toInches = 39.3700787;
        final double toElbows = 1.72;
        final double toNauticalMiles = 0.000539956803;

        System.out.println("This simple calculator will calculate length values in SI meters to:");
        System.out.println("- cal");
        System.out.println("- feet");
        System.out.println("- yards");
        System.out.println("- miles");
        System.out.println("- nautical miles");

        double length = 0;

        while (true) {
            length = getMeters();
        
            // if user put 0 we're exitting the program
            if (length == 0) {
                System.out.println("Thank you for using this program.");
                System.exit(0);
            }

            System.out.printf("1[m] is equal to %.4f[feet]%n", recalculate(length, toFeet));
            System.out.printf("1[m] is equal to %.4f[inches]%n", recalculate(length, toInches));
            System.out.printf("1[m] is equal to %.4f[yards]%n", recalculate(length, toYards));
            System.out.printf("1[m] is equal to %.4f[miles]%n", recalculate(length, toMiles));
            System.out.printf("1[m] is equal to %.4f[nautical miles]%n", recalculate(length, toNauticalMiles));
            System.out.printf("1[m] is equal to %.4f[lokci]%n", recalculate(length, toElbows));
        }
    }
}
