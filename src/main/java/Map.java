public class Map {
    private int numRows = 8; // Assuming some default values, adjust as needed
    private int numCols = 12; // Assuming some default values, adjust as needed
    private char[][] mapData = new char[numRows][numCols];

    private int[] mainUnitPos = new int[2];
    private int[] unit2Pos = new int[2];
    private int[] unit3Pos = new int[2];
    private int[] enemy1Pos = new int[2];
    private int[] enemy2Pos = new int[2];
    private int[] enemy3Pos = new int[2];


    public Map() {

        for (char[] row: mapData)
            Arrays.fill(row, '*');
    }
    public void displayMap() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (mainUnitPos[0] == i && mainUnitPos[1] == j) {
                    System.out.print("1");
                } else if (unit2Pos[0] == i && unit2Pos[1] == j) {
                    System.out.print("2");
                } else if (unit3Pos[0] == i && unit3Pos[1] == j) {
                    System.out.print("3");
                } else if (enemy1Pos[0] == i && enemy1Pos[1] == j) {
                    System.out.print("A");
                } else if (enemy2Pos[0] == i && enemy2Pos[1] == j) {
                    System.out.print("W");
                } else if (enemy3Pos[0] == i && enemy3Pos[1] == j) {
                    System.out.print("S");
                } else if (mapData[i][j] == 'H') { // don't show player on the map
                    System.out.print("-");
                } else {
                    System.out.print(mapData[i][j]);
                }
            }
            System.out.println();
        }
    }
    /*
     * Algorithm: Resets positions of player, NPC, misfortunes, sites to -1 and clears mapData
     * Set Ally position coordinates to 0/0, 0/2, 0/4
     * Set Enemy position coordinates to 7/2, 4/6. 5/11
     * loop i from 0 to num_rows
     *      loop i from 0 to num_cols
     *          Set (x,y) location on mapData to '-'
     * Parameters: none
     * Return: nothing (void)
     */
    public void resetMap() {
        // resets player position, count values, and initializes values in position arrays to -1
        mainUnitPos[0] = 0;
        mainUnitPos[1] = 0;

        unit2Pos[0] = 0;
        unit2Pos[1] = 2;

        unit3Pos[0] = 0;
        unit3Pos[1] = 4;

        enemy1Pos[0] = 7;
        enemy1Pos[1] = 2;

        enemy2Pos[0] = 4;
        enemy2Pos[1] = 6;

        enemy3Pos[0] = 5;
        enemy3Pos[1] = 11;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                mapData[i][j] = '-';
            }
        }
    }

    // return player's row position
    public int getMainUnitRowPosition() {
        return mainUnitPos[0];
    }

    // return player's column position
    public int getMainUnitColPosition() {
        return mainUnitPos[1];
    }

    // return Unit2's row position
    public int getUnit2RowPosition() {
        return unit2Pos[0];
    }

    // return Unit2's column position
    public int getUnit2ColPosition() {
        return unit2Pos[1];
    }

    // return Unit3's row position
    public int getUnit3RowPosition() {
        return unit3Pos[0];
    }

    // return Unit3's column position
    public int getUnit3ColPosition() {
        return unit3Pos[1];
    }

    // return Enemy1's row position
    public int getEnemy1RowPosition() {
        return enemy1Pos[0];
    }

    // return Enemy1's column position
    public int getEnemy1ColPosition() {
        return enemy1Pos[1];
    }

    // return Enemy2's row position
    public int getEnemy2RowPosition() {
        return enemy2Pos[0];
    }

    // return Enemy2's column position
    public int getEnemy2ColPosition() {
        return enemy2Pos[1];
    }

    // return Enemy3's row position
    public int getEnemy3RowPosition() {
        return enemy3Pos[0];
    }

    // return Enemy3's column position
    public int getEnemy3ColPosition() {
        return enemy3Pos[1];
    }

    public void setPlayerRowPosition(int row) {
        mainUnitPos[0] = row;
    }

    public void setPlayerColPosition(int col) {
        mainUnitPos[1] = col;
    }
}
public boolean executeMove(AlliedUnit[] units, MutableInt u1m, MutableInt u2m, MutableInt u3m) {
    int quit = 0;
    int rmnMv1 = units[0].getMovement();
    if (u1m.get() == 0)
        rmnMv1 = 0;
    int rmnMv2 = units[1].getMovement();
    if (u2m.get() == 0)
        rmnMv2 = 0;
    int rmnMv3 = units[2].getMovement();
    if (u3m.get() == 0)
        rmnMv3 = 0;

    while (quit == 0) {
        System.out.println("**********************************");
        displayMap();
        System.out.println("**********************************");
        int choice;
        char direction;
        System.out.println("Select which unit to move.");
        System.out.println("1. " + units[0].getName());
        System.out.println("2. " + units[1].getName());
        System.out.println("3. " + units[2].getName());
        System.out.println("4. End movement");
        choice = scanner.nextInt();

        switch (isValidChoice(choice, 1, 4)) {
            case 1: {
                if (rmnMv1 == 0) {
                    System.out.println(units[0].getName() + " has no movement remaining.");
                    u1m.set(0);
                    break;
                } else {
                    System.out.println("Which direction would you like to move " + units[0].getName() + " ?");
                    System.out.println("W: Up");
                    System.out.println("A: Left");
                    System.out.println("S: Down");
                    System.out.println("D: Right");

                    int distance;
                    if (!(mainUnitPos[0] == 0) && (Character.toLowerCase(direction) == 'w')) {
                        System.out.println("How many spaces would you like to move up? " + units[0].getName() + " has " + rmnMv1 + " spaces of movement remaining.");
                        distance = scanner.nextInt();
                        distance = isValidChoice(distance, 0, rmnMv1);
                        if (
                    }}
