package Ships;

import java.util.Scanner;

public class Floor {
    /*int length = 10;
    int width = 10;*/
    static int floorSize;
    static int noFloorColumns;
    static int noFloorRaws;
    String floorName;
    Scanner floorScan = new Scanner(System.in);

    public Floor() {

    }

    public Floor (/*String floorName, */int noOfColumns, int noOfRows) {
        /*this.floorName = floorName;*/
        this.noFloorColumns = noOfColumns;
        this.noFloorRaws = noOfRows;
        int[] floorSizeMemory = new int[noOfColumns * noOfRows];
        floorSize = noOfColumns * noOfRows;
    }

    public int getFloorSize() {
        return floorSize;
    }

    public Floor configureFloor() {
        System.out.println("Enter a size of a floor, you want to play in format - NumberOfColumns?");
        int scanColumnsNumber = floorScan.nextInt();
        System.out.println("NumberOfRows?");
        int scanRawsNumber = floorScan.nextInt();
        //Floor.noFloorRaws = scanRawsNumber;
        //Floor.noFloorColumns = scanColumnsNumber;
        Floor floor = new Floor(scanColumnsNumber, scanRawsNumber);
        System.out.println("Floor has been set-up. The size is: " + floor.noFloorColumns + " x " + floor.noFloorRaws + " = " + floorSize);
        return floor;
    }


}