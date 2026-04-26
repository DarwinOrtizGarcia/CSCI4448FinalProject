package game;

import game.units.Allied;
import game.units.Enemy;
import game.units.Character;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EmberSymbol {
    static Logger logger = org.slf4j.LoggerFactory.getLogger(EmberSymbol.class);
    private Scanner scanner = new Scanner(System.in);

    Map map;
    Integer turnCount = 0;

    public EmberSymbol(Map map) {
        this.map = map;
    }

    public void start() {
        boolean running = true;

        while (running) {
            map.displayMap();
            playerTurn();
            enemyTurn();

            if (checkWin()) {
                logger.info("You win!");
                running = false;
            } else if (checkLose()) {
                logger.info("You lose!");
                running = false;
            }
        }
    }

    private void playerTurn() {
        //TODO: Do this however you think will work best. We want them to be able to move in multiple direction too.
        //For example, The character has 4 movement and wants to go up 3, left 1.
        Allied playerCharacter = map.getMainCharacter();
        int MovementCost = playerCharacter.getMovement();
        boolean hasAttacked = false;
        while(MovementCost > 0 || !hasAttacked) {
            logger.info("Make your choice:");
            List<Enemy> targets = getEnemiesInRange(playerCharacter);
            boolean canMove = MovementCost > 0;
            boolean canAttack = !hasAttacked && !targets.isEmpty();

            if (canMove && canAttack) {
                logger.info("A) Move");
                logger.info("B) Fight");
                logger.info("C) Quit");

                String choice = scanner.nextLine().trim().toLowerCase();
                switch (choice) {
                    case "a":
                        if(doMove(playerCharacter, MovementCost)) {
                            MovementCost--;
                        }
                        break;
                    case "b":
                        doFight(playerCharacter, targets);
                        hasAttacked = true;
                        break;
                    case "c":
                        logger.info("Turn ended.");
                        return;
                    default:
                        logger.info("Invalid input.");
                }
            }
            else if (canMove) {
                if (doMove(playerCharacter, MovementCost))
                    MovementCost--;
                }
            else if (canAttack) {
                    logger.info("A) Fight");
                    logger.info("B) Quit");
                    String possibleChoice = scanner.nextLine().trim().toLowerCase();
                    switch (possibleChoice) {
                        case "a":
                            doFight(playerCharacter, targets);
                            hasAttacked = true;
                            break;
                        case "b":
                            logger.info("Turn ended.");
                            return;
                    }
                }

            else {
                    return;
            }
        }
    }

    private boolean tryMove(Allied player, String input) {
        int[] characterPosition = player.getPosition();
        int newRow = characterPosition[0];
        int newCol = characterPosition[1];
        switch(input) {
            case "w":
                newRow--;
                break;
            case "s":
                newRow++;
                break;
            case "a":
                newCol--;
                break;
            case "d":
                newCol++;
                break;
            default:
                logger.info("Invalid input.");
                return false;
        }
        if (newRow < 0 || newRow >= map.getNumRows() || newCol < 0 || newCol >= map.getNumColumns()) {
            logger.info("Can't move there, out of bounds.");
            return false;
        }
        if (map.isPositionOccupiedByEnemy(newRow, newCol) || map.isPositionOccupiedByAlly(newRow, newCol)) {
            logger.info("Can't move there, tile is occupied.");
            return false;
        }
        player.setPosition(new int[]{newRow, newCol});
        map.displayMap();
        return true;
    }
    private boolean doMove(Allied player, int remainingMovement) {
        logger.info("Your move (W/A/S/D), remaining movement spaces: " + remainingMovement);
        logger.info("W: Up ");
        logger.info("A: Left ");
        logger.info("S: Down ");
        logger.info("D: Right ");
        String input = scanner.nextLine().trim().toLowerCase();
        return tryMove(player, input);
    }

    private void doFight(Allied player, List<Enemy> targets) {
        if(targets.size() == 1) {
            player.attack(targets.get(0));
            logger.info(player.getName() + " attacked " + targets.get(0).getName());
        }
        else {
            logger.info("Choose target:");
            for(int i = 0; i < targets.size(); i++) {
                Enemy enemy = targets.get(i);
                logger.info((i+1) + ") " + enemy.getName());
            }
            try {
                int targetIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
                if (targetIndex >= 0 && targetIndex < targets.size()) {
                    player.attack(targets.get(targetIndex));
                    logger.info(player.getName() + " attacked " + targets.get(targetIndex).getName());
                }
                else {
                    logger.info("Invalid input.");
                }
            }
            catch (NumberFormatException e) {
                logger.info("Invalid input.");
            }
        }
    }
    private List<Enemy> getEnemiesInRange(Allied player) {
        List<Enemy> inRange = new ArrayList<>();
        int weaponRange = player.getEquippedWeapon().getRange();
        for(Enemy enemy: map.getEnemies()) {
            if (enemy.getHealth() > 0 && player.isInRange(player.getPosition(), enemy.getPosition(), weaponRange)) {
                inRange.add(enemy);
            }
        }
        return inRange;
    }

    private void enemyTurn() {
        List<Enemy> enemies = map.getEnemies();
        for (Enemy enemy : enemies) {
            if (enemy.getHealth() > 0) {
                enemy.takeTurn(map);
            }
        }
    }

    private boolean checkWin() {
        List<Enemy> enemies = map.getEnemies();
        for (Enemy enemy: enemies){
            if (enemy.getHealth() > 0){
                return false;
            }
        }
        return true;
    }

    private boolean checkLose() {
        Allied playerCharacter = map.getMainCharacter();
        return playerCharacter.getHealth() <= 0;
    }


}