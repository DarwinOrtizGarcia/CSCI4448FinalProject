Design Pattern 1: Factory Pattern used to instantiate Allied units and Enemy units, implemented in AlliedUnitFactory.java and EnemyUnitFactory.java

Design Pattern 2: Builder pattern used in Map.java to create the map and set the positions of enemy and allied units. 

Design Pattern 3: Facade pattern used in ShopFacade.java/ShopUI.java/PurchaseItem/PurchaseWeapon.java. The shop facade gives a simple interface with the UI and Item purchases/allocations handled behind the scenes by the other classes. This allows it to handle gold management, and differentiate between items and weapons for purchasing/equipping while still displaying them together in the shop UI.

Design Pattern 4: Strategy pattern used by the Enemy class to differentiate between physical and magical damage dealers. Each uses different stats for both their output damage and the opponents mitigation of that damage. For example, a mage will use their magic stat instead of strength and calculate that against the opponents resistance stat instead of defense.
