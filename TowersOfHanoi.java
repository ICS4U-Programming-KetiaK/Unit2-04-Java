import java.util.Scanner;

/**
* TowersOfHanoi program gives the user strategies on
* how to solve the tower of hanoi riddle.
*
* @author Ketia Gaelle Kaze
* @version 1.0
* @since 2022-04-14
*/

class TowersOfHanoi {
    /**
    * Creating empty constructor.
    */
    public TowersOfHanoi() { }

    /**
    * Creating function to displays where the disks
    * should be placed.
    *
    * @param numOfDisks passed
    * @param startPeg passed
    * @param middlePeg passed
    * @param endPeg passed
    */
    public static void hanoi(int numOfDisks,
            int startPeg, int middlePeg, int endPeg) {

        // base case for when there is only one disk.
        if (numOfDisks == 1) {
            System.out.println("Disk 1 moved from peg " + startPeg + " to "
                + "peg " + endPeg);

        } else {
            // calculate where the disks should be placed.
            hanoi(numOfDisks - 1, startPeg, endPeg, middlePeg);
            System.out.println("Disk " + numOfDisks + " moved from peg "
                    + startPeg + " to peg " + endPeg);
            hanoi(numOfDisks - 1, middlePeg, startPeg, endPeg);
        }
    }

    /**
    * Creating main function.
    *
    * @param args nothing passed in
    */
    public static void main(String[] args) {

        // Declaring variables
        int firstPeg = 1;
        int middlePeg = 2;
        int lastPeg = 3;
        Scanner sc = new Scanner(System.in);
        String numOfDisksStr;
        int numOfDisksInt;

        System.out.println("Towers of Hanoi\n");

        // Ask the user for input
        System.out.print("How many disks do you want to use?: ");
        numOfDisksStr = sc.nextLine();
        sc.close();

        // convert user input from string to an integer
        try {
            numOfDisksInt = Integer.parseInt(numOfDisksStr);

            // call function
            if (numOfDisksInt > 0) {
                hanoi(numOfDisksInt, firstPeg,
                    middlePeg, lastPeg);

            } else {
                // catch error if input is negative integer
                System.out.println(numOfDisksStr + " is positive integer.\n");
            }
            // catch error if the input is not an integer
        } catch (IllegalArgumentException exception) {
            System.out.println(numOfDisksStr + " is not a valid integer.\n");
        }
    }
}
