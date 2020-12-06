package semester_I.other;

import java.util.*;

public class Cwiczenia4 {

    public static void main(String[] args) {
        Random r = new Random();
        int suma = 0;
        int[][] tab = new int[5][6];

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                tab[i][j] = r.nextInt(10);
        for (int i = 0; i < 5; i++)
            System.out.println(Arrays.toString(tab[i]));

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                suma += tab[i][j];
            }
            tab[i][5] = suma;
            suma = 0;
        }

        System.out.println();
        for (int i = 0; i < 5; i++)
            System.out.println(Arrays.toString(tab[i]));
    }
}