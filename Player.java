package Ships;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    static int shotNumber;

    private String playerName;
    private int shipsNumber;
    ArrayList<Ship> shipsGroup;
    Scanner playerScan = new Scanner(System.in);

    public Player() {

    }

    public Player(String playerName, int shipsNumber) {
        shotNumber = 0;
        this.playerName = playerName;
        this.shipsNumber = shipsNumber;
        shipsGroup = new ArrayList<Ship>();
        Scanner playerScan = new Scanner(System.in);
    }

    public static int incrementShots() {
        shotNumber++;
        return shotNumber;
    }



    public int getShotNumber() {
        return shotNumber;
    }

    public void setShotNumber(int shotNumber) {
        this.shotNumber = shotNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getShipsNumber() {
        return shipsNumber;
    }

    public void configurePlayer() {
        System.out.println("Enter a name of a player");
        String scanPlayerName = playerScan.next();
        playerName = scanPlayerName;
        System.out.println("Ships number ?");
        int scanShipsNumber = 0;
        do {                                                        // do a loop after char or double entered
            try {
                System.out.println("Enter a number bigger than 0");
                scanShipsNumber = playerScan.nextInt();
                shipsNumber = scanShipsNumber;
            } catch (InputMismatchException ex) {
                System.out.println("You have to enter a number!");
            }
        }
        while (scanShipsNumber < 1);
        System.out.println("Player " + playerName + " with " + shipsNumber + " ships has been configured.");
    }

    public void setShipNames() {
        System.out.println(playerName+ ", give names for your ships");
        int shipLength = 2;
        for (int i = 0; i < shipsNumber; i++) {
            if (shipLength > 4)
                shipLength = 2;
            String scanShipName = playerScan.next();
            /*for (int j = 2; j < shipsNumber + 2; j++) {

            }*/
            //int scanLength = playerScan.nextInt();
            Ship ship = new Ship(scanShipName, shipLength);
            System.out.println("ship created");
            ship.setShip();
            System.out.println("ship set up");
            shipsGroup.add(ship);
            shipLength++;
        }
    }

}
