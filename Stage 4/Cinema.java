import java.util.Scanner;

public class Cinema {
    private static char[][] cinemaHall;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createCinema();
        int command;
        boolean isDone = false;

        while (!isDone) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");
            command = scanner.nextInt();

            menuOption(command);

            if (command == 0) {
                return;
            }
        }

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

    public static void menuOption(int keyboardInput) {
        switch (keyboardInput) {
            case 1:
                printCinema();
                break;

            case 2:
                takeTicket();
                break;

            case 0:
                break;

            default:
                System.out.println("Error, wrong command!");
                break;
        }
    }

    public static void takeTicket() {
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();
        System.out.println();

        int totalSeat = cinemaHall.length * cinemaHall[0].length;
        int frontHalfRows = cinemaHall.length / 2;

        if (cinemaHall[rowNumber - 1][seatNumber - 1] == 'B') {
            System.out.println("That ticket has already been purchased!");
            takeTicket();
        } else {
            int ticketPrice = priceEvaluation(totalSeat, rowNumber, frontHalfRows);

            System.out.println("Ticket price: $" + ticketPrice);
            System.out.println();
            cinemaHall[rowNumber - 1][seatNumber - 1] = 'B';
        }

    }

    public static int priceEvaluation(int totalSeat, int rowNumber, int frontHalfRows) {
        if (totalSeat <= 60 || rowNumber <= frontHalfRows) {
            return 10;
        } else {
            return 8;
        }
    }
}