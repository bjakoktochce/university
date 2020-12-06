/*
 * Funkcja kwadratowa
 * 
 * Bartosz Jakoktochce 
 */

package semester_I;

public class FunkcjaKwadratowa {

    public static String funkcjaKwadratowa(double a, double b, double c) {

        return (Math.pow(b, 2) - 4 * a * c) < 0 ? "Brak miejsc zerowych!"
                : ((Math.pow(b, 2) - 4 * a * c) == 0) ? "Rownanie ma 1 miejsce zerowe: x0 = " + (-b / (2 * a))
                        : "Rownanie ma 2 miejsca zerowe: x1 = "
                                + ((-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a)) + ", x2 = "
                                + ((-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a));
    }

    public static void main(String[] args) {

        System.out.println(funkcjaKwadratowa(-1, 2, -1));
    }
}
