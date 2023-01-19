import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {
    private static char[][] cinemaHall;
    private static ArrayList<Integer> ticketIncome = new ArrayList<Integer>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createCinema();
        int command;

        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            command = scanner.nextInt();
            System.out.println();

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

            case 3:
                statistics();
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

        if (rowNumber > cinemaHall.length || seatNumber > cinemaHall[0].length) {
            System.out.println("Wrong input!");
            takeTicket();
        } else if (cinemaHall[rowNumber - 1][seatNumber - 1] == 'B') {
            System.out.println("That ticket has already been purchased!");
            takeTicket();
        } else {
            int ticketPrice = priceEvaluation(totalSeat, rowNumber, frontHalfRows);

            System.out.println("Ticket price: $" + ticketPrice);
            System.out.println();
            cinemaHall[rowNumber - 1][seatNumber - 1] = 'B';
            ticketIncome.add(ticketPrice);
        }
    }

    public static int priceEvaluation(int totalSeat, int rowNumber, int frontHalfRows) {
        if (totalSeat <= 60 || rowNumber <= frontHalfRows) {
            return 10;
        } else {
            return 8;
        }
    }

    public static void statistics() {
        int totalSeat = cinemaHall.length * cinemaHall[0].length;

        int boughtSeat = 0;
        for (int i = 0; i < cinemaHall.length; i++) {
            for (int j = 0; j < cinemaHall[0].length; j++) {
                if (cinemaHall[i][j] == 'B') {
                    boughtSeat++;
                }
            }
        }

        double division = (double) boughtSeat / totalSeat * 100;
        String formattedPercentage = String.format("%.2f", division);

        int currentIncome = 0;
        for (int i = 0; i < ticketIncome.size(); i++) {
            currentIncome += ticketIncome.get(i);
        }

        int numberOfRow = cinemaHall.length;
        int numberOfCol = cinemaHall[0].length;
        int totalIncome;
        if (totalSeat <= 60) {
            totalIncome = totalSeat * 10;
        } else {
            int frontHalfRows = numberOfRow / 2;
            int backHalfRows = numberOfRow - frontHalfRows;

            totalIncome = frontHalfRows * numberOfCol * 10 + backHalfRows * numberOfCol * 8;
            System.out.println(frontHalfRows);
            System.out.println(backHalfRows);
            System.out.println(numberOfCol);
            System.out.println(numberOfRow);
        }

        System.out.println("Number of purchased tickets: " + boughtSeat);
        System.out.println("Percentage: " + formattedPercentage + "%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }
}