package game;

import game.units.Allied;
import game.units.Enemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map {
    private int numRows;
    private int numCols;
    private char[][] mapData;
    private List<Enemy> enemyUnits = new ArrayList<>();
    private List<Allied> allyUnits = new ArrayList<>();


    private Map(Builder builder) {
        this.numRows = builder.numRows;
        this.numCols = builder.numCols;

        this.mapData = new char[numRows][numCols];
        for (char[] row : mapData) {
            Arrays.fill(row, '-');
        }

        this.allyUnits = builder.allyUnits;
        this.enemyUnits = builder.enemyUnits;
    }
    public int getNumRows() {
        return this.numRows;
    }
    public int getNumColumns() {
        return this.numCols;
    }
    public boolean isPositionOccupiedByAlly(int row, int column) {
        for (Allied allied : allyUnits) {
            int[] pos = allied.getPosition();
            if(pos[0] == row && pos[1] == column) {
                return true;
            }
        }
        return false;
    }
    public boolean isPositionOccupiedByEnemy(int row, int column) {
        for(Enemy enemy : enemyUnits) {
            int[] pos = enemy.getPosition();
            if(pos[0] == row && pos[1] == column) {
                return true;
            }
        }
        return false;
    }
    public static Builder getNewBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int numRows = 8;
        private int numCols = 12;

        private List<Enemy> enemyUnits = new ArrayList<>();
        private List<Allied> allyUnits = new ArrayList<>();

        public Builder setDimensions(int rows, int cols) {
            this.numRows = rows;
            this.numCols = cols;
            return this;
        }

        public Builder addAlly(Allied ally) {
            allyUnits.add(ally);
            return this;
        }

        public Builder addEnemy(Enemy enemy) {
            enemyUnits.add(enemy);
            return this;
        }

        public Map build() {
            return new Map(this);
        }
    }

    public void displayMap() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {

                char toPrint = '-'; // default

                for (Allied ally : allyUnits) {
                    if (ally.getPosition()[0] == i && ally.getPosition()[1] == j) {
                        toPrint = Character.toUpperCase(ally.getName().charAt(0));
                        break;
                    }
                }

                if (toPrint == '-') {
                    for (Enemy enemy : enemyUnits) {
                        if (enemy.getPosition()[0] == i && enemy.getPosition()[1] == j) {
                            toPrint = Character.toUpperCase(enemy.getName().charAt(0));
                            break;
                        }
                    }
                }

                System.out.print(toPrint);
            }
            System.out.println();
        }
    }

}
