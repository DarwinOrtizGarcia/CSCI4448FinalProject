import game.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    @Test
    public void testConstructor() {
        Map map = Map.getNewBuilder().build();
        assertNotNull(map);
        map.displayMap();

    }


}
