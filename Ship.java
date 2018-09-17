package Ships;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Ship {

    private String name;
    private int length;
    private Set<Integer> takenFields;
    static ArrayList<Integer> randomNumbers;
    int randomNum;
    //int randomNum1;
    //int randomNum2;
    char direction;
    /*static */ArrayList<Integer> shipPosition;

    public Ship(String shipName, int shipLength) {
        this.name = shipName;
        this.length = shipLength;  // ships length will be 2-4 fields

        shipPosition = new ArrayList<Integer>();
    }

    Scanner scanner = new Scanner(System.in);

 /*   public void setShip() {

        drawField();
        //int takenField = (int) Math.random() * 100 / 2 - 3;
        for (int i = 0; i < length ; i++) {
            int randomNum =
        }
        takenFields.add(randomNum);
        takenFields.add(randomNum1);
        takenFields.add(randomNum2);
        //return randomNum;
    }*/

    public int setShip() {
        //boolean czyprawada;
        do {
            getRandomNum();
            directionShip();
            System.out.println("petla");
        }
        while (checkFreeFields() == true);
        //randomNum1 = randomNum + 1;
        //randomNum2 = randomNum + 2;
        return randomNum;
    }

    private int getRandomNum() {
        Random rand = new Random();
        do {randomNum = rand.nextInt(100 - length - 1);} // - length cause every ship takes x-length fields on a floor
        while (!takenFields.contains(randomNum));
        return randomNum;
    }

    private char directionShip() {
        if (randomNum % 2 == 0)
            direction = '|';
        else
            direction = '-';
        return direction;
    }

    private boolean checkFreeFields() {
        boolean enoughSpace = false;
        if (direction == '-') {
            if (randomNum + length < Floor.noFloorColumns) {
                for (int i = randomNum; i < randomNum + length; i++) {
                    shipPosition.add(randomNum);
                    //randomNumbers.add(i);
                    enoughSpace = true;
                }
            }
        }
        if (direction == '|') {
            if (randomNum + length < Floor.noFloorRaws) {
                for (int i = randomNum; i < randomNum + length; i++) {
                    shipPosition.add(randomNum);
                    //randomNumbers.add(i);
                    enoughSpace = true;
                }
            }
        }
        return enoughSpace;
    }


    public int takeShot() {
        System.out.println("Put a field number within 1 to " + Floor.floorSize + " to destroy a ship");
        int checkNoField = scanner.nextInt();
        try {
            if (shipPosition.equals(checkNoField)) { // Ship.randomNumbers.contains(checkNoField)
                Player.incrementShots();
                shipPosition.remove(checkNoField);
                System.out.println("You striked, nice :)");
                if (shipPosition.isEmpty() == true)
                    System.out.println("And you destroyed a ship!");
            }
            else
                System.out.println("You missed :(");
        }
        catch (Exception ex) {
            System.out.println("You have to put a number within 1 to " + Floor.floorSize);
        }
        return checkNoField;
    }

}
