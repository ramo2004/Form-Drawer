import java.util.Scanner; //importing scanner

import javax.swing.plaf.TreeUI;

public class FormDrawer {

    public static void showMenu() { // the method that shows the menu to the user
        System.out.println("Fall 2022 - CS1083 - Section 001 - Project 2 - FormDrawer - written by Omar Mian");
        System.out.println("Please, select one of the following options");
        System.out.println("0. Exit");
        System.out.println("1. Draw a Diamond");
        System.out.println("2. Draw a Rectangle");
        System.out.println("3. Draw a Triangle");
    }

    /*
     * public static void drawPattern(char char1, char char2, boolean ascending) {
     * Scanner scnr = new Scanner(System.in);
     * char first = ' ';
     * char second = ' ';
     * String asc = "";
     * while(true) {
     * System.out.println("Input the first letter to be used in the pattern");
     * first = scnr.next(".").charAt(0);
     * if (first != 1) {
     * System.out.println("this isnt A");
     * }
     */

    public static void drawTriangle(int width) {

        int outsideBlanks = width / 2 - 1;
        int insideBlanks = 0;

        // the for loop to printlines of upper part of triangle
        for (int i = 0; i < width / 2; i++) {
            // loop to print outer blanks
            for (int j = 0; j < outsideBlanks; j++)
                System.out.print(" ");
            // print /
            System.out.print("/");
            // loop to print inner blanks
            for (int j = insideBlanks; j > 0; j--)
                System.out.print(" ");
            // print \
            System.out.print("\\");

            System.out.println();

            // increment/decrement outer and inner blanks
            outsideBlanks--;
            insideBlanks += 2;

        }
        // loop to print last line
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println();

    }

    public static void drawRectangleLine(char chr, int size, boolean hollow) {
        // String space = " "
        if (hollow == false) {
            for (int i = 0; i <= size - 1; i++) {
                System.out.print(chr);
            }
            System.out.println();
        } else {
            for (int j = 1; j <= size; j++) {
                if (j == 1) { // when j is 1 it indicates first coloumn
                    System.out.print(chr);
                }
                if (j == size) {
                    System.out.print(chr);
                }
                if (j <= size - 2) {
                    System.out.print(" ");
                }
                // System.out.print(chr + " ");
            }
            System.out.println();
        }

    }

    public static void drawRectangle(char chr, int size, boolean hollow) {
        // System.out.println("drawRectangle method works");
        for (int i = 1; i <= size; i++) { // i is a reference for the line number, a placeholder for each line
            if (i == 1 || i == size) { // this is the first and last line, these are special cases
                drawRectangleLine(chr, size, false);
            } else {
                drawRectangleLine(chr, size, hollow);
            }

        }
    }

    public static void triangle() {
        Scanner scnr = new Scanner(System.in);
        int size = 0;
        boolean rePrompt = true;
        System.out.println("What size do you want the triangle to be drawn?");
        System.out.println("Please insert an even number between 0 and 60");
        size = scnr.nextInt();
        while (rePrompt) {
            if (size > 60 || size < 0 || size % 2 != 0) {
                System.out.println("Incorrect option, please, try again");
                System.out.println("What size do you want the triangle to be drawn?");
                System.out.println("Please insert an even number between 0 and 60");
                size = scnr.nextInt();
            } else {
                rePrompt = false;
                drawTriangle(size);
            }
        }

    }

    public static void rectangle() {
        Scanner scnr = new Scanner(System.in);
        char chr = ' ';
        // char chr = scnr.next(".").charAt(0);
        char hollow = ' ';
        boolean isHollow = true;
        int size = 0;
        boolean rePrompt = true;

        System.out.println("Please write the char that you would like to be used as the contour of the rectangle");
        chr = scnr.next(".").charAt(0);
        System.out.println("Do you want the rectangle to be printed hollow?");
        hollow = scnr.next(".").charAt(0);
        while (rePrompt) {
            if (hollow != 'Y' && hollow != 'N') {

                System.out.println("Incorrect selection, please, try again");
                System.out.println("Do you want the rectangle to be printed hollow?");
                hollow = scnr.next(".").charAt(0);
            } else {
                rePrompt = false;

            }
        }
        rePrompt = true;

        while (rePrompt) {

            System.out.println("What size do you want the Rectangle to be drawn?");
            System.out.println("Please insert any number between 0 and 60");
            size = scnr.nextInt();

            if (size > 60 || size < 0) {
                System.out.println("Incorrect option, please, try again");

            } else {
                rePrompt = false;

            }
        }
        if (!rePrompt) {
            isHollow = false;
            if (hollow == 'Y') {
                isHollow = true;
            }
            drawRectangle(chr, size, isHollow);
        }
    }

    public static void drawDiamond(char fillChar, char edgeChar, int size) {
        showCharNTimes(edgeChar, size);
    }

    public static void showCharNTimes(char c, int size) {
        int leftFills = size / 2 - 1;
        int insideFills = 0;
        int rightFills = size / 2 - 1;

        // the for loop to printlines of upper part of diamond
        for (int i = 0; i < size / 2; i++) {
            // loop to print outer fillls
            for (int j = 0; j < leftFills; j++) {
                System.out.print(c);
            }
            // print /
            System.out.print("/");
            // loop to print inner fills
            for (int j = insideFills; j > 0; j--) {
                System.out.print(c);
            }
            System.out.print("\\");

            for (int k = rightFills + 2; k < size; k++) {
                System.out.print(c);
            }

            System.out.println();

            // increment/decrement left, right and inner fills
            leftFills--;
            rightFills++;
            insideFills += 2;
        }
        // do the bottom part of the diamond here
        leftFills = 0;
        insideFills = size - 2;
        rightFills = size;

        for (int l = size / 2; l >= 1; l--) {
            for (int m = 0; m < leftFills; m++) {
                System.out.print(c);
            }
            System.out.print("\\");
            for (int n = insideFills; n > 0; n--) {
                System.out.print(c);
            }
            System.out.print("/");
            for (int o = rightFills; o < size; o++) {
                System.out.print(c);
            }
            System.out.println();

            leftFills++;
            rightFills--;
            insideFills -= 2;

        }
    }

    public static void diamond() { // this method prints the diamond
        Scanner scnr = new Scanner(System.in);

        char edgeCharDiamond = '0';
        char fillCharDiamond = '0';
        int sizeOfDiamond = 0;
        boolean rePrompt = true;

        System.out.println("Please write the char that you would like to be used to fill the diamond");
        edgeCharDiamond = scnr.next(".").charAt(0);
        System.out.println("Please write the char that you would like to be used as edge of the diamond");
        fillCharDiamond = scnr.next(".").charAt(0);
        System.out.println("What size do you want the diamond to be drawn?");
        System.out.println("Please insert an even number between 0 and 60");
        sizeOfDiamond = scnr.nextInt();

        while (rePrompt) {
            if (sizeOfDiamond > 60 || sizeOfDiamond < 0 || sizeOfDiamond % 2 != 0) {
                System.out.println("Incorrect option, please, try again");
                System.out.println("What size do you want the diamond to be drawn?");
                System.out.println("Please insert an even number between 0 and 60");
                sizeOfDiamond = scnr.nextInt();
            } else {
                rePrompt = false;
                // System.out.println("PRINT DIAMOND NOW");
                drawDiamond(fillCharDiamond, edgeCharDiamond, sizeOfDiamond);
                // i need to implement the drawDiamond() method which draws the diamond in this
                // else block
            }
        }
    }

    public static void getMenuSelection() { // This method will use the showMenu() to display the Menu
        Scanner scnr = new Scanner(System.in);

        showMenu();
        int userShapeChoice = scnr.nextInt();
        while (userShapeChoice != 0) {
            if (userShapeChoice < 0 || userShapeChoice > 3) {
                System.out.println("Incorrect option, please, try again");

            } else {
                // print diamond
                if (userShapeChoice == 1) { // if user inputs 1 then draw a diamond
                    diamond();
                } else if (userShapeChoice == 2) {
                    rectangle();
                    // this is where u call other methods for rectangle and triangle
                    // System.out.println("print other shapes");
                } else if (userShapeChoice == 3) {

                    triangle();
                }
            }
            showMenu();
            userShapeChoice = scnr.nextInt();
        }
        // while is false
        if (userShapeChoice == 0) {
            System.out.println("Thank you for using the formDrawer program, Good bye!");
        }
    }

    public static void main(String[] args) { // main method
        getMenuSelection();
    }

}
