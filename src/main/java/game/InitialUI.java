package game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        logger.info("\n--- New Game ---");
        logger.info("1. Create Character");
        logger.info("2. Use Premade Character");
        logger.info("Choose: ");

        int choice = getUserChoice();

        if (choice == 1) {
            createCharacter();
        } else if (choice == 2) {
            usePremadeCharacter();
        } else {
            logger.info("Invalid choice.");
        }
    }

    private void createCharacter() {
        logger.info("");
    }

    private void usePremadeCharacter() {
        logger.info("");
    }

    private void exitGame() {
        logger.info("GG");
    }
}
