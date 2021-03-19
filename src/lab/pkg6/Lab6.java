//C0490418
//William Plummer
//Comp 132, section 1B
//2019-10-21
/*This code randomly fills a 2D array with either 1s or 0s and interprets
them as Xs or Os & displays the result. Then the program will count every
0 (every available seat) and display the amount to the user. The same will
be done for every 1 (every taken seat). Afterwards the program will check if
a specified section of the array is a 0 (available to be reserved). Then it
will count how many seats are available in row 3 & finally, the program will
check for the first two available seats next to eachother in the array.*/
package lab.pkg6;

public class Lab6 {

    public static void main(String[] args) {
        int[][] seats = new int[12][4]; //creating the empty array

        boolean seatAvail = isSeatAvailable(seats, 2, 'A');
        /*checking if
        the reserved seat is available*/

        reserveSeat(seats, seatAvail); //reserving the seat
        fillRandom(seats); //randomly filling the seats with 1s and 0s
        displaySeats(seats); //displaying the randomly filled seats

        int allSeatsAvail = countAllSeatsAvail(seats);
        /*counting all
        available seats*/
        int seatsAvailRow = seatsAvailInRow(seats);
        /*checkiing how many
        seats are available in row 3*/
        int takenSeats = countTakenSeats(seats);
        /*checking how many seats
        are taken*/
        int rowTwoSeats = findRowWithTwoSeats(seats);
        /*checking for two
        adjacent seats with the same value*/

        System.out.println("\nSeats available: " + allSeatsAvail);
        /*displaying the available seats*/
        System.out.println("Seats taken: " + takenSeats);
        /*displaying the
        taken seats*/
        System.out.println("Seat 2A available: " + seatAvail);
        /*displaying
        if seat 2A is available to be reserved*/
        System.out.println("Seats available in row 3: " + seatsAvailRow);
        /*displaying the seats available in row 3*/
        System.out.println("These two seats match: " + rowTwoSeats);
        /*displaying which two, adjacent seats are the same*/
    }

    /*Randomly fills the array 'seats' up with 1s or 0s
    *Receives the array 'seats'
    *Returns nothing
     */
    public static void fillRandom(int[][] seats) {
        for (int row = 0; row < seats.length; row++) { //for every row
            for (int col = 0; col < seats[row].length; col++) {/*and
                every column*/
                seats[row][col] = (int) (Math.random() * 2);
                /*fill them all
                with either 1s or 0s*/
            }
        }
    }

    /*Checks if the seat 2A is available 
    *Receives the array 'seats', the row the seat is in, and the column the
    seat is in
    *Returns a boolean saying if the seat is available or not
     */
    public static boolean isSeatAvailable(int[][] seats, int row, char col) {
        col = Character.toUpperCase(col);
        /*turn the char into uppercase in
        case it isn't already*/
        int colIndex = Character.getNumericValue(col) - 10;
        /*then turn it
        into a number the computer can understand*/
        if (seats[row - 1][colIndex] == 0) {
            /*if that part of the array
            equals 0 (is free) then...*/
            return true; //return true
        } else {//if not...
            return false; //return false
        }
    }

    /*Changes the reserved seat from a available seat to a taken seat
    *Receives the array 'seats', and the boolean telling it if the seat is
    available to be reserved
    *Returns nothing
     */
    public static void reserveSeat(int[][] seats, boolean seatAvail) {
        if (seatAvail == true) { //if the seat to be reserved is available...
            seats[2][1] = 1;//then reserve it
        }
    }

    /*Checks how many seats are available in row 3
    *Receives the array seats
    *Returns the amount of available seats in row 3
     */
    public static int seatsAvailInRow(int[][] seats) {
        int counter = 0;
        /*create a counter to track how many seats are
        available*/
        for (int row = 0; row < seats[row].length; row++) {
            /*check every
            column*/
            if (seats[2][row] == 0) {
                /*if the seat is available*/
                counter++; //then add one to the counter
            }
        }
        return counter;
        /*return the count however many seats are available
        in row 3*/
    }

    /*Finds the first two, adjacent, available seats
    *Receives the array seats
    *Returns the two, adjacent, available seats
     */
        public static int findRowWithTwoSeats(int[][] seats) {
        for (int row = 0; row < seats.length; row++) { /*check every row...*/
            for (int col = 0; col < seats[row].length - 1; col++) {
                /*and every column*/
                if (seats[row][col] == 0 && seats[row][col + 1] == 0) {
                    /*check if the seat and the seat one over both equal
                    zero*/
                    return row + 1; /*return the row number (pluss 1 so it
                    displays the correct row  to the user*/
                }
            }
        }
        return 0;
    }

    /*Counts every available seat
    *Receives the array seats
    *Returns the amount of available seats
     */
    public static int countAllSeatsAvail(int[][] seats) {
        int counter = 0;
        /*create a counter to track how many seats
        are available*/
        for (int row = 0; row < seats.length; row++) { //check every row...
            for (int col = 0; col < seats[row].length; col++) {
                /*and every
                column*/
                if (seats[row][col] == 0) { //if the seat is a zero
                    counter++; //then add one to the counter
                }
            }
        }
        return counter; //return the amount of available seats
    }

    /*Counts every taken seat
    *Receives the array seats
    *Returns the amount of taken seats
     */
    public static int countTakenSeats(int[][] seats) {
        int counter = 0; //create a counter to track how many seats are taken
        for (int row = 0; row < seats.length; row++) { //check every row...
            for (int col = 0; col < seats[row].length; col++) {
                /*and every
                column*/
                if (seats[row][col] == 1) { //if the seat is taken
                    counter++; //then add one to the counter
                }
            }
        }
        return counter; //return the amount of taken seats
    }

    /*Displays the array 'seats' and displays any 1s as Xs and any 0s as 0s
    *Receives the 2D array 'seats'
    *Returns nothing
     */
    public static void displaySeats(int[][] seats) {
        System.out.print("\tA  \tB  \tC  \tD \n");
        /*print off labels for
        each column*/
        for (int row = 0; row < seats.length; row++) {
            /*check every row
            of the array*/
            System.out.print(row + 1 + "");
            /*move from row 0 to row 1*/
            for (int seatNum = 0; seatNum < seats[row].length; seatNum++) {
                /*
                check every column of the array*/
                if (seats[row][seatNum] == 1) {
                    /*if the seat was given
                    a one...*/
                    System.out.print("\tX  ");
                    /*then print an X*/
                } else {
                    /*if not...*/
                    System.out.print("\t0  ");
                    /*print a zero*/
                }
            }
            System.out.println();
            /*then return to move onto the next row*/
        }
    }
}