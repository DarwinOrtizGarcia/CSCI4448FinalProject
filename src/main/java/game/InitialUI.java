package game;

import game.shop.ShopFacade;
import game.units.Allied;
import game.units.AlliedUnitFactory;
import game.units.Enemy;
import game.units.EnemyUnitFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import game.shop.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InitialUI {
    private static final Logger logger = LoggerFactory.getLogger(InitialUI.class);
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    startNewGame();
                    break;
                case 2:
                    exitGame();
                    running = false;
                    break;
                default:
                    logger.info("Invalid choice. Try again.");
            }
        }
    }

    private void printMenu() {
        logger.info("==== EMBER SYMBOL ====");
        logger.info("1. Start New Game");
        logger.info("2. Exit");
        logger.info("Choose an option: ");
    }

    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            logger.info("Enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void startNewGame() {
        logger.info("--- New Game ---");
        logger.info("1. Create Character");
        logger.info("2. Use Premade Character");
        logger.info("Choose: ");

        EnemyUnitFactory enemyUnitFactory = new EnemyUnitFactory();
        boolean validChoice = false;
        int choice = getUserChoice();

        Allied mainCharacter = null;
        while(!validChoice) {
            if (choice == 1) {
                mainCharacter = createCharacter();
                validChoice = true;
            } else if (choice == 2) {
                mainCharacter = usePremadeCharacter();
                validChoice = true;
            } else {
                logger.info("Invalid choice.");
            }
        }

        int[] size = chooseMapSize();
        int numberOfRows = size[0];
        int numberOfColumns = size[1];
        int difficulty = chooseDifficulty();
        int defaultNumEnemies = numberOfRows/2;

        openShop(mainCharacter);

        List<Enemy> enemies = enemyUnitFactory.createRandomEnemies(difficulty+defaultNumEnemies);

        Map map = Map.getNewBuilder()
                .setDimensions(numberOfRows, numberOfColumns)
                .addAlly(mainCharacter)
                .addMultipleEnemies(enemies)
                .build();

        EmberSymbol game =  new EmberSymbol(map);
        game.start();
    }

    private Allied createCharacter() {
        AlliedUnitFactory alliedUnitFactory = new AlliedUnitFactory();
        logger.info("Name your character: ");
        String name = scanner.nextLine();
        logger.info("Choose your class: ");
        logger.info("1. Fighter: Well rounded melee unit.");
        logger.info("2. Tank: Slower movement, but tougher against physical attacks");
        logger.info("3. Archer: Weaker and squishier than the melee classes, but can attack at range.");
        logger.info("4. Mage: Very squishy, but deals damage that is extra effective against armored enemies at range.");
        int choice = getUserChoice();

        switch (choice) {
            case 1:
                return alliedUnitFactory.createFighterAlly(name);
                break;
            case 2:
                return alliedUnitFactory.createToughAlly(name);
                break;
            case 3:
                return alliedUnitFactory.createArcherAlly(name);
                break;
            case 4:
                return alliedUnitFactory.createMageAlly(name);
                break;
            default:
                logger.info("Invalid choice. Try again.");
        }

    }

    private Allied usePremadeCharacter() {
        AlliedUnitFactory alliedUnitFactory = new AlliedUnitFactory();

        logger.info("Choose your character: ");
        logger.info("1. Alvin (Fighter): Well rounded melee unit, he can both deal and take solid damage.");
        logger.info("2. Kisara (Tank): Slower movement, but she is tougher against physical attacks.");
        logger.info("3. Raven (Archer): Weaker and squishier than the melee classes, but he can attack at range.");
        logger.info("4. Pascal (Mage): Very squishy, but she deals damage that is extra effective against armored enemies at range.");
        int choice = getUserChoice();

        switch (choice) {
            case 1:
                return alliedUnitFactory.createFighterAlly("Alvin");
                break;
            case 2:
                return alliedUnitFactory.createToughAlly("Kisara");
                break;
            case 3:
                return alliedUnitFactory.createArcherAlly("Raven");
                break;
            case 4:
                return alliedUnitFactory.createMageAlly("Pascal");
                break;
            default:
                logger.info("Invalid choice. Try again.");
        }
    }

    private int[] chooseMapSize() {
        logger.info("Choose map size:");
        logger.info("1. Small (4x4 grid)");
        logger.info("2. Medium (6x6 grid)");
        logger.info("3. Large (8x8 grid)");
        logger.info("Enter choice: ");

        int choice = getUserChoice();


        return switch (choice) {
            case 1 -> new int[]{4, 4};
            case 2 -> new int[]{6, 6};
            case 3 -> new int[]{8, 8};
            default -> {
                logger.info("Invalid choice. Defaulting to Small.");
                yield new int[]{4, 4};
            }
        };
    }

    private int chooseDifficulty() {
        logger.info("Choose your difficulty:");
        logger.info("1. Chill (default enemies only, 2 on small map, 3 on medium, 4 on large)");
        logger.info("2. Challenge (1 extra enemy)");
        logger.info("3. Lunatic (2 extra enemies)");
        logger.info("Enter choice: ");

        int choice = scanner.nextInt();


        return switch (choice) {
            case 1 -> 1;
            case 2 -> 2;
            case 3 -> 3;
            default -> {
                logger.info("Invalid choice. Defaulting to Chill.");
                yield 1;
            }
        };
    }

    private void openShop(Allied unit) {
        logger.info("--- Shop ---");
        ShopUI shopUI = new ShopUI();
        ShopFacade shop = new ShopFacade(shopUI);
        int startingGold = 1000;
        shop.enterShop(startingGold, unit);
    }

    private void exitGame() {
        logger.info("GG");
    }
}
