import java.util.Scanner;

/**
 * Cinema
 */
public class Cinema {
    private static char[][] cinemaHall;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createCinema();
        printCinema();
        takeTicket();
        printCinema();
    }

    public static void createCinema() {
        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();
        cinemaHall = new char[numberOfRows][numberOfSeats];

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfSeats; j++) {
                cinemaHall[i][j] = 'S';
            }
        }
        System.out.println();
    }

    public static void printCinema() {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= cinemaHall[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < cinemaHall.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < cinemaHall[0].length; j++) {
                System.out.print(" " + cinemaHall[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void takeTicket() {
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();
        System.out.println();

        int totalSeat = cinemaHall.length * cinemaHall[0].length;
        int ticketPrice;
        int frontHalfRows = cinemaHall.length / 2;

        if (totalSeat <= 60 || rowNumber <= frontHalfRows) {
            ticketPrice = 10;
        } else {
            ticketPrice = 8;
        }

        System.out.println("Ticket price: $" + ticketPrice);
        System.out.println();
        cinemaHall[rowNumber - 1][seatNumber - 1] = 'B';
    }
}