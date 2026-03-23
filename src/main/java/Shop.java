public static void shop(int gold, int chapter, Item[] items, AlliedUnit[] units) {
    int option;
    int rnum = randomNums(1, 10);

    if (chapter == 0) {
        int quit = 0;

        if (rnum == 10) {
            System.out.println("You got lucky, and found an extra 400 gold to spend!");
            gold = gold + 400;
        }

        while (quit == 0) {
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("You currently have " + gold + " gold.");
            System.out.println("The current selection avaliable is:");
            System.out.println("1. Steel Bow; Cost: 400 gold. Usable by archers, deals 2 more damage than the default Iron Bow.");
            System.out.println("2. Steel Sword; Cost: 400 gold. Usable by swordsman/swordswoman and cavaliers, deals 2 more damage than the default Iron Sword.");
            System.out.println("3. Thunder Magic; Cost: 400 gold. Usable by mages, deals 2 more damage than the default Fire Magic.");
            System.out.println("4. Vulnerary; Cost: 500 gold. A healing item usable by all units, restores 10 health.");
            System.out.println("5. Quit shopping.");

            option = readInt(INPUT);

            switch (option) {
                case 1:
                    gold = buyItem(gold, Item.steelBow(), items, units);
                    break;
                case 2:
                    gold = buyItem(gold, Item.steelSword(), items, units);
                    break;
                case 3:
                    gold = buyItem(gold, Item.thunderMagic(), items, units);
                    break;
                case 4:
                    gold = buyItem(gold, Item.vulnerary(), items, units);
                    break;
                case 5:
                    quit = 1;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a number from 1 to 5.");
                    break;
            }
        }
    }
}

private static int buyItem(int gold, Item item, Item[] items, AlliedUnit[] units) {
    if (item == null) {
        System.out.println("That item is unavailable.");
        return gold;
    }

    if (gold < item.getCost()) {
        System.out.println("You do not have enough gold to buy " + item.getName() + ".");
        return gold;
    }

    if (!addToInventory(items, item)) {
        System.out.println("Your inventory is full. You cannot buy " + item.getName() + ".");
        return gold;
    }

    gold -= item.getCost();
    System.out.println("Purchased " + item.getName() + ".");

    if (item.isWeapon()) {
        AlliedUnit equippedUnit = equipFirstMatchingUnit(units, item);
        if (equippedUnit != null) {
            System.out.println(equippedUnit.getName() + " can now use " + item.getName() + ".");
        } else {
            System.out.println("No allied unit can use " + item.getName() + " right now.");
        }
    }

    return gold;
}

private static boolean addToInventory(Item[] items, Item item) {
    if (items == null || item == null) {
        return false;
    }

    for (int i = 0; i < items.length; i++) {
        if (items[i] == null || items[i].isEmpty()) {
            items[i] = item;
            return true;
        }
    }

    return false;
}
