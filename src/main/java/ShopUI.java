import java.util.Scanner;

public class ShopUI {
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu(int gold) {
        System.out.println("--------------------------------------------------");
        System.out.println("Gold: " + gold);
        System.out.println("1. Steel Bow (400)");
        System.out.println("2. Steel Sword (400)");
        System.out.println("3. Thunder Magic (400)");
        System.out.println("4. Potion (500)");
        System.out.println("5. Quit");
    }

    public int getInput() {
        return scanner.nextInt();
    }
}
