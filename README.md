# MovieTheater

A Java application for booking and reserving seats in a movie theater.

## Features

- View seating chart
- Reserve seats
- Cancel reservations
- Suggest available seats

## Seating Chart

```
    1 2 3 4 5 6 7 8 
A O O O O O O O O 
B O O O O O O O O 
C O O O O O O O O 
D O O O O O O O O 
E O O O O O O O O 
```

### Navigating the Seating Chart

1. **Understanding the Chart**: Each row represents a row in the theater (A, B, C, D, E), and each column represents a seat number (1 to 8). The letter indicates the row, and the number indicates the seat within that row.

2. **Identifying Available Seats**: An "O" indicates that the seat is available for reservation. If a seat is reserved, it will be marked differently (e.g., "X").

3. **Choosing a Seat**: To reserve a seat, you will need to specify the row and seat number in the format (e.g., A1 for row A, seat 1).

4. **Viewing the Chart**: You can view the seating chart at any time by selecting the option to view it in the program.

5. **Updating the Chart**: After reserving or canceling a seat, the seating chart will automatically update to reflect the current availability.

## Usage

Run the program and follow the prompts:

1. Choose an option (view seating chart, reserve seat, cancel reservation, exit)
2. For reserving or canceling, enter the seat (e.g., A1)
3. View the updated seating chart after each action

## Example

```
1. View seating chart
2. Reserve seat
3. Cancel reservation
4. Exit
Choose an option: 2
Enter seat to reserve (e.g., A1): A1
```

## Requirements

- Java 12 or higher
