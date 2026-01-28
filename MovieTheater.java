// Description:  A movie theater that helps users to book and reserve seats.
// Author: Brandon Maloney & SD14
// Date: 2026-01-27

import java.util.Scanner;

public class MovieTheater {
    static final int ROWS = 5;
    static final int COLS = 8;
    static char[][] seats = new char[ROWS][COLS];

    public static void main(String[] args) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                seats[r][c] = 'O'; // "O" for open seat
            }
        }
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. View seating chart\n2. Reserve seat\n3. Cancel reservation\n4. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                displaySeating();
            } else if (choice.equals("2")) {
                System.out.print("Enter seat to reserve (e.g., A1): ");
                String seat = sc.nextLine();
                reserveSeat(seat);
            } else if (choice.equals("3")) {
                System.out.print("Enter seat to cancel (e.g., A1): ");
                String seat = sc.nextLine();
                cancelSeat(seat);
            } else if (choice.equals("4")) {
                System.out.println("Exiting. Thankyou!");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        sc.close();
    }

    static void displaySeating() {
        System.out.println("Seating Chart:");
        System.out.print("  ");
        for (int i = 1; i <= COLS; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int r = 0; r < ROWS; r++) {
            System.out.print((char)('A' + r) + " ");
            for (int c = 0; c < COLS; c++) {
                System.out.print(seats[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[] parseSeat(String seat) {
        if (seat.length() < 2) return null;
        char rowChar = Character.toUpperCase(seat.charAt(0));
        if (!Character.isLetter(rowChar)) return null;
        int row = rowChar - 'A';
        int col;
        try {
            col = Integer.parseInt(seat.substring(1)) - 1;
        } catch (NumberFormatException e) {
            return null;
        }
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) return null;
        return new int[]{row, col};
    }

    static String suggestSeat() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (seats[r][c] == 'O') {
                    return "" + (char)('A' + r) + (c + 1);
                }
            }
        }
        return null;
    }

    static void reserveSeat(String seat) {
        int[] pos = parseSeat(seat);
        if (pos == null) {
            System.out.println("Invalid seat: " + seat);
            return;
        }
        int row = pos[0], col = pos[1];
        if (seats[row][col] == 'X') {
            System.out.println("Seat " + seat + " is already taken.");
            String suggestion = suggestSeat();
            if (suggestion != null) {
                System.out.println("Suggested available seat: " + suggestion);
            } else {
                System.out.println("No seats available.");
            }
        } else {
            seats[row][col] = 'X';
            System.out.println("Seat " + seat + " reserved successfully.");
        }
    }

    static void cancelSeat(String seat) {
        int[] pos = parseSeat(seat);
        if (pos == null) {
            System.out.println("Invalid seat: " + seat);
            return;
        }
        int row = pos[0], col = pos[1];
        if (seats[row][col] == 'O') {
            System.out.println("Seat " + seat + " is not reserved.");
        } else {
            seats[row][col] = 'O';
            System.out.println("Reservation for seat " + seat + " cancelled.");
        }
    }
}
