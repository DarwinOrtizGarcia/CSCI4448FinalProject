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
        Allied playerCharacter = map.getMainCharacter();
        int MovementCost = playerCharacter.getMovement();
        boolean hasAttackedorDrank = false;
        while(MovementCost > 0 || !hasAttackedorDrank) {
            logger.info("Make your choice:");
            List<Enemy> targets = getEnemiesInRange(playerCharacter);
            boolean canMove = MovementCost > 0;
            boolean canAttack = !hasAttackedorDrank && !targets.isEmpty();
            boolean canDrinkPotion = !hasAttackedorDrank && playerCharacter.hasPotion();

            if (canMove && (canAttack || canDrinkPotion)) {
                logger.info("1) Move");
                if (canAttack) {
                    logger.info("2) Fight");
                }
                if (canDrinkPotion) {
                    logger.info("3) Drink Potion");
                }
                logger.info("0) Quit");

                String choice = scanner.nextLine().trim();
                switch (choice) {
                    case "1":
                        if(doMove(playerCharacter, MovementCost)) {
                            MovementCost--;
                        }
                        break;
                    case "2":
                        if(canAttack) {
                            doFight(playerCharacter, targets);
                            hasAttackedorDrank = true;
                        }
                        else {
                            logger.info("Invalid choice");
                        }
                        break;
                    case "3":
                        if(canDrinkPotion) {
                            playerCharacter.usePotion();
                            hasAttackedorDrank = true;
                        }
                        else {
                            logger.info("Invalid choice");
                        }
                        break;
                    case "0":
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
            else if (canAttack || canDrinkPotion) {
                    logger.info("Make your choice:");
                    if (canAttack)
                    {
                        logger.info("1) Fight");
                    }
                    if (canDrinkPotion) {
                        logger.info("2) Drink Potion");
                    }
                    logger.info("0) Quit");
                    String possibleChoice = scanner.nextLine().trim();
                    switch (possibleChoice) {
                        case "1":
                            doFight(playerCharacter, targets);
                            hasAttackedorDrank = true;
                            break;
                        case "2":
                            if (canDrinkPotion) {
                                playerCharacter.usePotion();
                                hasAttackedorDrank = true;
                            }
                            break;
                        case "0":
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
        logger.info("Q: Quit ");
        String input = scanner.nextLine().trim().toLowerCase();
        if  (input.equals("q")) {
            remainingMovement = 0;
            return true;
        }
        return tryMove(player, input);
    }

    private void doFight(Allied player, List<Enemy> targets) {
        if(targets.size() == 1) {
            player.attack(targets.get(0));
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