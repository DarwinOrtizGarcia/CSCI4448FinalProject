package game;

import game.units.Allied;
import game.units.Enemy;
import org.slf4j.Logger;

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
        logger.info("Your move (W/A/S/D), remaining movement spaces: " + playerCharacter.getMovement());
        logger.info("W: Up ");
        logger.info("A: Left ");
        logger.info("S: Down ");
        logger.info("D: Right ");


        String input = scanner.nextLine().toLowerCase();

        /*
        switch (input) {
            case "w": playerCharacter.move(); break;
            case "s": ; break;
            case "a": ; break;
            case "d": ; break;
            default:
                logger.info("Invalid move.");
        }

         */
    }

    private void enemyTurn() {
        List<Enemy> enemies = map.getEnemies();
        //TODO: ideally have them move toward the player and attack, but random is fine too if thats too hard.
        for (Enemy enemy : enemies) {
            enemy.takeTurn(map);
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