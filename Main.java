package Ships;

import java.util.Scanner;

public class Main {

    Scanner mainScan2 = new Scanner(System.in);

    public static void main(String[] args) {

        Scanner mainScan = new Scanner(System.in);
        Floor floor = new Floor();
        floor.configureFloor();

       /* System.out.println("Enter a size of a floor, you want to play in format - NumberOfColumns?");
        int columnsNumber = mainScan.nextInt();
        System.out.println(" NumberOfRows?");
        int rawsNumber = mainScan.nextInt();
        Floor floor1 = new Floor(columnsNumber, rawsNumber);
        System.out.println("Floor has been created. Now enter a players names and number of ships." +
                " /nPlayer 1 name:");*/
       Player player1 = new Player();
       player1.configurePlayer();
       Player player2 = new Player();
       player2.configurePlayer();
       /* String playerName = mainScan.next();
        System.out.println("Ships number");
        int shipsNumber = mainScan.nextInt();
        Player player1 = new Player(playerName, shipsNumber);
        System.out.println("Player " + playerName + " with " + shipsNumber + " ships has been created.");*/

       /* System.out.println("Player 2 name:");
        playerName = mainScan.next();
        System.out.println("Ships number");
        shipsNumber = mainScan.nextInt();
        Player player2 = new Player(playerName, shipsNumber);
        System.out.println("Player " + playerName + " with " + shipsNumber + " ships has been created. /nLet's start a game ;)");*/

       /* System.out.println(player1.getPlayerName() + ", give names for your ships");
        for (int i = 0; i < player1.getShipsNumber(); i++) {
            String scanShipName = mainScan.next();
            int scanLength = mainScan.nextInt();
            Ship ship = new Ship(scanShipName, scanLength);
            ship.setShip();
            player1.shipsGroup.add(ship);*/
       player1.setShipNames();
       player2.setShipNames();

        }


}

