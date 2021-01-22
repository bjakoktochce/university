package semester_I;

import java.util.*;

public class Strings {

    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {

        // SZYFRUJ
        String tekstDoZaszyfrowania = "Ala ma kota";
        int key = 1;
        System.out.println(szyfruj(tekstDoZaszyfrowania, key));

        // ODSZYFRUJ
        System.out.println(odszyfruj(szyfruj(tekstDoZaszyfrowania, key), key));

        // ODWROCONY
        String napis = "To jest napis.";
        System.out.println("Odwrocony napis napisu \"" + napis + "\" to: " + odwrocony(napis));
        System.out.println("Odwrocony napis napisu \"" + napis + "\" to: " + odwrocony2(napis));

        // PRZESTAWIONE SLOWA
        String t = "Ala ma kota i psa";
        System.out.println("Odwrocone slowa w napisie \"" + t + "\": " + przestawioneSlowa(t));

        // PALINDROM
        String slowo = "kayak";
        System.out.println("Czy slowo \"" + slowo + "\" to palindrom: " + palindrom(slowo));

        // LICZBA WYSTAPIEN LITERY
        String str = "To jest Ania a to jest Bartek";
        char letterToCheck = 'a';
        System.out.println("Liczba wystapien litery \'" + letterToCheck + "\' w tekscie \"" + str + "\" : "
                + liczbaWystapien(str, letterToCheck));

        // HISTOGRAM
        System.out.println("Histogram dla stringu: \"" + str + "\"");
        int[] histogram = histogram(str);
        int i = 0;
        for (char letter = 'a'; letter <= 'z'; letter++) {
            System.out.println(letter + ":" + histogram[i]);
            i++;
        }
        System.out.println(Arrays.toString(histogram(str)));

        // UPORZADKUJ
        String napisDoUporzadkowania = "W 2010   roku   ,   ktory byl pare lat temu  ,   kupilem  samochod ,ale  po jakims czasie okazalo     sie,ze to    grat.";
        System.out.println(napisDoUporzadkowania);
        System.out.println(uporzadkuj(napisDoUporzadkowania));

        // ANAGRAM
        String s1 = "alergia";
        String s2 = "galeria";
        System.out.println("Czy slowa: " + s1 + " oraz " + s2 + " sa anagramami: " + anagram(s1, s2));
    }

    static String odwrocony(String s) {
        String r = new StringBuilder(s).reverse().toString();
        return r;
    }

    static String odwrocony2(String s) {
        String odwroconyTekst = "";

        for (int i = 0; i < s.length(); i++) {
            char c = (char) (s.charAt(s.length() - i - 1));
            odwroconyTekst += c;
        }

        return odwroconyTekst;
    }

    static String przestawioneSlowa(String s) {
        String r[];
        r = s.split(" ");

        String[] d = new String[r.length];

        for (int i = 0; i < r.length; i++)
            d[i] = r[r.length - i - 1];

        return String.join(" ", d);
    }

    static String szyfruj(String s, int key) {
        String zaszyfrowany = "";

        for (int i = 0; i < s.length(); i++) {
            char c = (char) (s.charAt(i));

            if (c != ' ') {
                if (c > 'z')
                    zaszyfrowany += (char) (s.charAt(i) - (26 - key));
                else
                    zaszyfrowany += (char) (s.charAt(i) + key);
            } else
                zaszyfrowany += c;
        }

        return zaszyfrowany;
    }

    static String odszyfruj(String s, int key) {
        String odszyfrowany = "";

        for (int i = 0; i < s.length(); i++) {
            char c = (char) (s.charAt(i));

            if (c != ' ') {
                if (c > 'z')
                    odszyfrowany += (char) (s.charAt(i) - (26 - key));
                else
                    odszyfrowany += (char) (s.charAt(i) - key);
            } else
                odszyfrowany += c;

        }

        return odszyfrowany;
    }

    static int liczbaWystapien(String s, char charToCheck) {
        int count = 0;

        for (char c : s.toLowerCase().toCharArray()) {
            if (c == charToCheck)
                count++;
        }
        return count;

    }

    static int[] histogram(String s) {
        int numberOfLetters = 26;
        int[] x = new int[numberOfLetters];

        int i = 0;

        for (char letterToCheck = 'a'; letterToCheck <= 'z'; letterToCheck++) {
            x[i] = liczbaWystapien(s, letterToCheck);
            i++;
        }

        return x;
    }

    static boolean palindrom(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(s.length() - 1) - i)
                return true;
        }
        return false;
    }

    static boolean anagram(String s1, String s2) {
        char[] s1Array = s1.toLowerCase().toCharArray();
        char[] s2Array = s2.toLowerCase().toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        return Arrays.equals(s1Array, s2Array);
    }

    static String uporzadkuj(String napis) {

        napis = napis.replaceAll("^ +| +$|( )+", " ");
        napis = napis.replaceAll("( ,)", ",");
        napis = napis.replaceAll(", +|, +|(,)", ", ");

        return napis;
    }
}
