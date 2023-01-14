import java.util.Scanner;
import java.util.prefs.BackingStoreException;

/**
 * Cinema
 */

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfCols = scanner.nextInt();

        int totalSeat = numberOfRows * numberOfCols;
        int totalIncome;

        if (totalSeat <= 60) {
            totalIncome = totalSeat * 10;
        } else {
            int frontHalfRows = numberOfRows / 2;
            int backHalfRows = numberOfRows - frontHalfRows;

            totalIncome = frontHalfRows * numberOfCols * 10 + backHalfRows * numberOfCols * 8;
        }

        System.out.println("Total income:");
        System.out.println("$" + totalIncome);
    }
}