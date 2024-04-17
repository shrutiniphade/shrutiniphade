import java.util.Scanner;
import java.io.*;

public class Shellsort
{
    static void shellSort(int[] arr) {
        int n = arr.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            gap /= 2;
        }
    }

    public static void displayTopFiveScores(int[] arr) {
        int[] sortedArr = arr.clone();
        java.util.Arrays.sort(sortedArr);
        System.out.println("Top Five Scores:");
        for (int i = 0; i < Math.min(5, arr.length); i++) {
            System.out.println(sortedArr[arr.length - 1 - i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students whose percentages are to be displayed: ");
        int n = scanner.nextInt();
        int[] percentages = new int[n];
        System.out.println("Enter percentages for " + n + " students (Press ENTER after every student's percentage):");
        for (int i = 0; i < n; i++) {
            percentages[i] = (int) scanner.nextDouble();
        }

        System.out.println("The percentages of " + n + " students are: ");
        for (int percentage : percentages) {
            System.out.print(percentage + " ");
        }
        System.out.println();

        shellSort(percentages);
        System.out.println("After Shell Sort:");
        for (int percentage : percentages) {
            System.out.print(percentage + " ");
        }
        System.out.println();

        displayTopFiveScores(percentages);
    }
}

