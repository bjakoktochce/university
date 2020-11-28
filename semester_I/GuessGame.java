/*
 * 1.4 Gierka w "za duzo, za malo"
 * 
 * Bartosz Jakoktochce 
 */ 

import java.util.*;

public class GuessGame {

    static Scanner reader = new Scanner(System.in);

    public static int getMaxValue() {
        int value = 0;

        do {
            System.out.print("\nPlease anter max value: (0 to quit): ");
            
            value = reader.nextInt();      
            reader.nextLine();    
            if (value < 0) System.out.println("ERROR: The value can not be negative.");   
        }
        while (value < 0);
        
        return value;
    }

    public static void main(String[] args) {
        int computedValue, maxValue, userValue, round = 0;
        char exitOrNot;

        System.out.println("This is very simple game. Computer randomize number and the user has to guess this number.");

        do {
            maxValue = getMaxValue();
            if (maxValue == 0) System.exit(0);

            Random rand = new Random();
            computedValue = rand.nextInt(maxValue);

            do {
                round++;

                System.out.print("Round: " + round + ". Please enter your proposition: ");
                userValue = reader.nextInt();

                if(userValue > maxValue) {
                    System.out.println("*** Entered value is beyond the scope. ***");
                }
                else if(userValue < computedValue) {
                    System.out.println("*** Entered value: " + userValue + " is smaller than computed. ***");   
                }
                else if(userValue > computedValue) {
                    System.out.println("*** Entered value: " + userValue + " is greater than computed. ***");
                }
               
            } while(userValue != computedValue);    

            System.out.println("Congratulations! You have guessed the number in " + round + " tries. The proper value is: " + computedValue);
            
            System.out.print("Do you want to play once again? y/n : ");
            exitOrNot = reader.next().charAt(0);
        }
        while(exitOrNot != 'n');
    }  
}
