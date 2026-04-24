package game.units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import game.Map;
import game.Strategy.AttackStrategy;

public class Character {
    private String name;
    private int health;
    private int strength;
    private int magic;
    private int defense;
    private int resistance;
    private int[] position = new int[2];
    private int movement;


    public Character(String name, int health, int strength, int magic, int defense, int resistance, int movement, int[] position) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.magic = magic;
        this.defense = defense;
        this.resistance = resistance;
        this.movement = movement;
        this.position = position;
    }

    public Character(Character character) {
    }

    public Character(String name, int initialHealth, int initialStrength, int initialMagic, int initialDefense, int initialResistance, int initialMovement, int[] position, AttackStrategy strategy) {
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
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getMagic() {
        return magic;
    }
    public void setMagic(int magic) {
        this.magic = magic;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getResistance() {
        return resistance;
    }
    public void setResistance(int resistance) {
        this.resistance = resistance;
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
        int movement = this.movement;
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
    boolean isInRange(int[] CharacterLocation, int[] targetLocation, int Range)
    {
        int CharacterRow =  CharacterLocation[0];
        int CharacterColumn =  CharacterLocation[1];
        int targetRow = targetLocation[0];
        int targetColumn = targetLocation[1];
        int distance = Math.abs(CharacterRow - targetRow) + Math.abs(CharacterColumn - targetColumn);
        return distance <= Range;
    }
    public void attack(Character target) {
        int damage = this.getStrength();
    }
}