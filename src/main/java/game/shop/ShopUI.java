package game.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ShopUI {
    private static final Logger logger = LoggerFactory.getLogger(ShopUI.class);
    private Scanner scanner = new Scanner(System.in);

    public ShopUI() {
        this.scanner = new Scanner(System.in);
    }

    public ShopUI(Scanner scanner) {
        this.scanner = scanner;
    }
    public void displayMenu(int gold) {
        logger.info("--------------------------------------------------");
        logger.info("Gold: " + gold);
        logger.info("1. Steel Bow (400)");
        logger.info("2. Steel Sword (400)");
        logger.info("3. Thunder Magic (400)");
        logger.info("4. Potion (500)");
        logger.info("5. Quit");
    }

    public int getInput() {
        return scanner.nextInt();
    }
}
