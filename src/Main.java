import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int SIZE = 10;
    public static void main(String[] args) {
        double[] arrayNumber = new double[SIZE];
        Scanner scaner = new Scanner(System.in);
        System.out.println("Ile liczb posortowac:");
        int sizeArray = scaner.nextInt();
        scaner.nextLine();
        System.out.println("Czy tablice wygenerowac czy podajesz wartosci?");
        System.out.println("Wpisz 1 - wypisywanie z klawiatury");
        System.out.println("Wpisz 2 - wygeneruj");
        String choice = scaner.next();
        switch (choice) {
            case "1" -> {
                System.out.println("Wprowadz " + sizeArray + " kolejno liczb");
                for (int i = 0; i < sizeArray; i++) {
                    arrayNumber[i] = scaner.nextInt();
                }
                System.out.println("Tablica wypisana z klawiatury: ");
                for (int i = 0; i < sizeArray; i++) {
                    System.out.print(arrayNumber[i] + ", ");
                }
            }
            case "2" -> {

                System.out.println("Jaki zakres liczb ");
                System.out.println("Liczby od :");
                int start = scaner.nextInt();
                System.out.println("Liczby do :");
                int finish = scaner.nextInt();
                System.out.println("Tablica wygenerowanych liczb");
                for (int i = 0; i < sizeArray; i++) {
                    arrayNumber[i] = (Math.random() * (finish - start)) + start;
                    System.out.print(arrayNumber[i] + ", ");
                }
            }
        }
        System.out.println();
        System.out.println("Posortowana tablica");
        System.out.println(Arrays.toString(quickSort(arrayNumber, 0, sizeArray - 1)));
    }

    public static double[] quickSort(double[] arrayNumber, int left, int right){
        int i = left;
        int j = right;
        double middle = arrayNumber[(left + right) / 2];
        double temp;
        do {
            while (arrayNumber[i] < middle) i++;
            while (arrayNumber[j] > middle) j--;

            if (i <= j){
                temp = arrayNumber[i];
                arrayNumber[i] = arrayNumber[j];
                arrayNumber[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (left < j) quickSort(arrayNumber, left, j);
        if (right > i) quickSort(arrayNumber, i, right);
        return arrayNumber;
    }
}