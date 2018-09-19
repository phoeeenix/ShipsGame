package Ships;

import java.util.*;

public class Ship {

    private String name;
    private int length;
    private Set<Integer> takenFields = new HashSet<Integer>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] ts) {
            return null;
        }

        @Override
        public boolean add(Integer integer) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Integer> collection) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return false;
        }

        @Override
        public void clear() {

        }
    };
    static ArrayList<Integer> randomNumbers;
    int randomNum;
    //int randomNum1;
    //int randomNum2;
    char direction;
    /*static */ArrayList<Integer> shipPosition;
    boolean enoughSpace = false;

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
        /*do {*/
        getRandomNum();
        System.out.println("returned randomNum");
        directionShip();
        System.out.println("returned direction");
        checkFreeFields();
        System.out.println("ENOUGHSPACE = " + enoughSpace);
    /*}
        while (enoughSpace == true);*/
    //randomNum1 = randomNum + 1;
        //randomNum2 = randomNum + 2;
        System.out.println("Ship has been set up");
        return randomNum;
    }

    private int getRandomNum() {
        Random rand = new Random();
        boolean repeatNum = false;
        do {
        randomNum = rand.nextInt(100 - length - 1);
        } // - length cause every ship takes x random fields -length fields before end of a floor
        while (repeatNum != takenFields.contains(randomNum));
        System.out.println("Random no is " + randomNum);
        return randomNum;
    }

    private char directionShip() {
        if (randomNum % 2 == 0) {
            direction = '|';
            System.out.println("direction |");
        }
        else {
            direction = '-';
            System.out.println("direction -");
        }
        return direction;
    }

    private boolean checkFreeFields() {
        //boolean enoughSpace = true;
        if (direction == '-') {
            System.out.println("direction -");
            //if (randomNum + length < Floor.noFloorColumns) {
            checkPositionFields();
               /* for (int i = randomNum; i < randomNum + length; i++) {
                    if (takenFields.contains(i)) {
                        enoughSpace = false;
                        break;
                    }
                    shipPosition.add(i);
                    //randomNumbers.add(i);
                    enoughSpace = true;
                }*/
               enoughSpaceIfTrue();
               /* if (enoughSpace == true) {
                    takenFields.addAll(shipPosition);
                    System.out.println("Ship position fields has been added to takenFields");*/
        }
        //}
        if (direction == '|') {
            System.out.println("direction |");
            //if (randomNum + length < Floor.noFloorRaws) {
            checkPositionFields();
            enoughSpaceIfTrue();
          /*  if (enoughSpace == true)
                takenFields.addAll(shipPosition);*/
            //}
        }
        return enoughSpace;
    }

    private boolean checkPositionFields() {
        for (int i = randomNum; i < randomNum + length; i++) {
            if (takenFields.contains(i)) {
                enoughSpace = false;
                System.out.println("ES is FALSE");
                break;
            }
            shipPosition.add(i);
            enoughSpace = true;
            //randomNumbers.add(i);
        }
        return enoughSpace;
    }

    private void enoughSpaceIfTrue() {
        if (enoughSpace == true) {
            takenFields.addAll(shipPosition);
            System.out.println("Ship position fields has been added to takenFields");
        }
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
