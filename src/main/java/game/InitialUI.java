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

        openShop(mainCharacter);

        List<Enemy> enemies = enemyUnitFactory.createRandomEnemies(difficulty);

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
        logger.info("Name your character: ");
        return alliedUnitFactory.createAlly(name);

    }

    private Allied usePremadeCharacter() {

    }

    private int[] chooseMapSize() {
        logger.info("Choose map size:");
        logger.info("1. Small (4x4 grid)");
        logger.info("2. Medium (6x6 grid)");
        logger.info("3. Large (9x9 grid)");
        logger.info("Enter choice: ");

        int choice = getUserChoice();


        return switch (choice) {
            case 1 -> new int[]{4, 4};
            case 2 -> new int[]{6, 6};
            case 3 -> new int[]{9, 9};
            default -> {
                logger.info("Invalid choice. Defaulting to Small.");
                yield new int[]{4, 4};
            }
        };
    }

    private int chooseDifficulty() {
        logger.info("Choose your difficulty:");
        logger.info("1. Chill (default enemies only, 1 on small map, 2 on medium, 3 on large)");
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
        List<Item> defaultItems = new ArrayList<>();
        shop.enterShop(startingGold, defaultItems, unit);
    }

    private void exitGame() {
        logger.info("GG");
    }
}
