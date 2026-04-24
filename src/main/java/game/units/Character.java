package game.units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import game.Map;
import game.Strategy.AttackStrategy;

public class Character {
    private String name;
    private Double health;
    private Double strength;
    private Double magic;
    private Double defense;
    private Double resistance;
    private int[] position = new int[2];
    private int movement;
    private AttackStrategy strategy;

    public Character(String name, Double health, Double strength, Double magic, Double defense, Double resistance, int movement, int[] position, AttackStrategy strategy) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.magic = magic;
        this.defense = defense;
        this.resistance = resistance;
        this.movement = movement;
        this.position = position;
        this.strategy = strategy;
    }

    public Character(Character character) {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPosition(int[] newPosition){
        this.position = newPosition;
    }
    public int[] getPosition(){
        return this.position;
    }
    public Double getHealth() {
        return health;
    }
    public void setHealth(Double health) {
        this.health = health;
    }
    public Double getStrength() {
        return strength;
    }
    public void setStrength(Double strength) {
        this.strength = strength;
    }
    public Double getMagic() {
        return magic;
    }
    public void setMagic(Double magic) {
        this.magic = magic;
    }
    public Double getDefense() {
        return defense;
    }
    public void setDefense(Double defense) {
        this.defense = defense;
    }
    public Double getResistance() {
        return resistance;
    }
    public void setResistance(Double resistance) {
        this.resistance = resistance;
    }
    public AttackStrategy getStrategy() {
        return strategy;
    }
    public void setStrategy(AttackStrategy strategy) {
        this.strategy = strategy;
    }
    public int getMovement() {
        return movement;
    }
    public void setMovement(int movement) {
        this.movement = movement;
    }
    public void MoveOnMap(Map gamemap)
    {
        int rows = getPosition()[0];
        int columns = getPosition()[1];
        List<int[]> possibleCoordinates = new ArrayList<int[]>();
        for(int possibleXMovement = -movement; possibleXMovement < movement; possibleXMovement++)
        {
            for(int possibleYMovement = -movement; possibleYMovement < movement; possibleYMovement++)
            {
                int totalMovementCost = Math.abs(possibleXMovement) + Math.abs(possibleYMovement);
                if(totalMovementCost > movement || possibleXMovement == 0 && possibleYMovement == 0)
                {
                    continue;
                }
                int newRow = rows + possibleXMovement;
                int newColumn = columns + possibleYMovement;
                int[] newPosition = new int[]{newRow,newColumn};
                if(isCoordinateFree(newRow,newColumn, gamemap))
                {
                    possibleCoordinates.add(newPosition);
                }
            }
        }
        if(!possibleCoordinates.isEmpty()){
            Random rand = new Random();
            int[] newPosition = possibleCoordinates.get(rand.nextInt(possibleCoordinates.size()));
            this.setPosition(newPosition);
        }
    }
    private boolean isCoordinateFree(int row, int column, Map gamemap)
    {
        if (row < 0 || row >= gamemap.getNumRows())
        {
            return false;
        }
        else if (column < 0 || row >= gamemap.getNumColumns())
        {
            return false;
        }
        else if (gamemap.isPositionOccupiedByEnemy(row, column)) {
            return false;
        }
        else return !gamemap.isPositionOccupiedByAlly(row, column);
    }
}