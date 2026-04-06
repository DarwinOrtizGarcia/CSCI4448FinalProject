package game;

import java.util.Arrays;

public class Map {
    private int numRows;
    private int numCols;
    private char[][] mapData;

    private int[] mainUnitPos;
    private int[] unit2Pos;
    private int[] unit3Pos;
    private int[] enemy1Pos;
    private int[] enemy2Pos;
    private int[] enemy3Pos;

    private Map(Builder builder) {
        this.numRows = builder.numRows;
        this.numCols = builder.numCols;

        this.mapData = new char[numRows][numCols];
        for (char[] row : mapData) {
            Arrays.fill(row, '-');
        }

        this.mainUnitPos = builder.mainUnitPos;
        this.unit2Pos = builder.unit2Pos;
        this.unit3Pos = builder.unit3Pos;
        this.enemy1Pos = builder.enemy1Pos;
        this.enemy2Pos = builder.enemy2Pos;
        this.enemy3Pos = builder.enemy3Pos;
    }
    public static Builder getNewBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int numRows = 8;
        private int numCols = 12;
        //All of these are just extremely generic default values to test basic functionality, theyre only here because the game is incomplete
        private int[] mainUnitPos = new int[]{0, 0};
        private int[] unit2Pos = new int[]{0, 2};
        private int[] unit3Pos = new int[]{0, 4};
        private int[] enemy1Pos = new int[]{7, 2};
        private int[] enemy2Pos = new int[]{4, 6};
        private int[] enemy3Pos = new int[]{5, 11};


        public Builder setDimensions(int rows, int cols) {
            this.numRows = rows;
            this.numCols = cols;
            return this;
        }

        public Builder setMainUnitPos(int row, int col) {
            this.mainUnitPos = new int[]{row, col};
            return this;
        }

        public Builder setUnit2Pos(int row, int col) {
            this.unit2Pos = new int[]{row, col};
            return this;
        }

        public Builder setUnit3Pos(int row, int col) {
            this.unit3Pos = new int[]{row, col};
            return this;
        }

        public Builder setEnemy1Pos(int row, int col) {
            this.enemy1Pos = new int[]{row, col};
            return this;
        }

        public Builder setEnemy2Pos(int row, int col) {
            this.enemy2Pos = new int[]{row, col};
            return this;
        }

        public Builder setEnemy3Pos(int row, int col) {
            this.enemy3Pos = new int[]{row, col};
            return this;
        }

        public Map build() {
            return new Map(this);
        }
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
                } else if (mapData[i][j] == 'H') {
                    System.out.print("-");
                } else {
                    System.out.print(mapData[i][j]);
                }
            }
            System.out.println();
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
