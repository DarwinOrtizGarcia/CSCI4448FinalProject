public class CharacterTest {
    @Test
    public void testEnemyDefault() {
        Enemy ogre = new Enemy("Ogre");
        assertEquals(10.0, ogre.getHealth());
        assertEquals(1.0, ogre.getRange());
    }

    @Test

}