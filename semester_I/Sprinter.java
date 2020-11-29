/*
 * 2.3 Program dla sprintera
 * 
 * Bartosz Jakoktochce 
 */

package semester_I;

import java.util.*;

public class Sprinter {

    static Scanner reader = new Scanner(System.in);

    public static double getTime(int measurementCount) {
        double time = 0;

        do {
            System.out.print("Time for measurement #" + measurementCount + " (enter 0 to calculate): ");

            time = reader.nextDouble();
            reader.nextLine();

            if (time < 0)
                System.out.println("*** ERROR: The time can not be negative.\n");

        } while (time < 0);

        return time;
    }

    public static void main(String[] args) {

        System.out.println("This simple program calculates the best, the worst abd average time of the sprinter.\n");

        double currentTime, totalTime = 0, averageTime = 0, bestTime = 0, worstTime = 0;
        int measurementCount = 0;

        do {
            currentTime = getTime(measurementCount);

            if (currentTime != 0) {
                if (measurementCount == 0)
                    bestTime = currentTime;

                worstTime = (currentTime > worstTime) ? currentTime : worstTime;
                bestTime = (currentTime < bestTime) ? currentTime : bestTime;

                totalTime += currentTime;

                measurementCount++;
            }
        } while (currentTime != 0);

        averageTime = totalTime / measurementCount;

        System.out.println("* The average time of " + measurementCount + " measurements is: " + averageTime);
        System.out.println("* The best time is: " + bestTime);
        System.out.println("* The worst time is: " + worstTime);

        System.out.println("\nThank you for using the program.");
    }
}
