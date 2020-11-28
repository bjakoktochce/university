
/*
 * 3.2 Figury ASCII
 * 
 * Bartosz Jakoktochce 
 */

import java.util.Scanner;

public class FiguryAscii {

    public static void drawFilledRectangle(int size) {
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void drawLeftTriangle(int size) {
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= y; x++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void drawRightTriangle(int size) {
        for (int y = 1; y <= size; y++) {
            for (int x = size; x > y; x--) {
                System.out.print(" ");
            }
            for (int i = 1; i <= y; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void drawRectangle(int size) {
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                if ((y == 1) || (y == size) || (x == 1) || (x == size)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void drawRectangleWithDiagonals(int size) {
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                if ((y == 1) || (y == size) || (x == 1) || (x == size) || (y == x) || (x == (size - y + 1))) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void drawPyramid(int size) {
        for (int y = 1; y <= size; y++) {
            for (int x = size; x > y; x--) {
                System.out.print(" ");
            }
            for (int i = 1; i <= (y * 2) - 1; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static int getMenuItem() {
        int choice;

        System.out.println();
        System.out.println("1 - Filled rectangle");
        System.out.println("2 - Rectangle ");
        System.out.println("3 - Left triangle");
        System.out.println("4 - Right triangle");
        System.out.println("5 - Rectangle with diagonals");
        System.out.println("6 - Pyramid");
        System.out.print("Which figure would you like to draw ? (0 to exit): ");

        choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }

    public static int getSizeOfFIgure() {
        int sizeOfFigure;

        do {
            System.out.print("Please enter size of the figure: ");

            sizeOfFigure = scanner.nextInt();
            scanner.nextLine();

            if (sizeOfFigure < 0)
                System.out.println("*** ERROR: The size of the figure can not be negative ***");
            if (sizeOfFigure == 0)
                System.out.println("*** ERROR: The size of the figure can not be 0 ***");

        } while (sizeOfFigure <= 0);

        return sizeOfFigure;
    }

    public static void main(String[] args) {
        System.out.println("This simple program will draw asterix (*) figure of your choice.\n");

        while (true) {
            switch (getMenuItem()) {
                case 1:
                    drawFilledRectangle(getSizeOfFIgure());
                    break;
                case 2:
                    drawRectangle(getSizeOfFIgure());
                    break;
                case 3:
                    drawLeftTriangle(getSizeOfFIgure());
                    break;
                case 4:
                    drawRightTriangle(getSizeOfFIgure());
                    break;
                case 5:
                    drawRectangleWithDiagonals(getSizeOfFIgure());
                    break;
                case 6:
                    drawPyramid(getSizeOfFIgure());
                    break;
                case 0:
                    System.out.println("Thank you for using this program. Have a nice day :)");
                    System.exit(0);
                    break;
                default:
                    System.out.println("*** There's no such an option. Please make a choice betweean 1 and 7! ***");
            }
        }

    }

}
