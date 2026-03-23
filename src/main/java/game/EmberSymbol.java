package game;

import org.slf4j.Logger;


public class EmberSymbol {
    static Logger logger = org.slf4j.LoggerFactory.getLogger(EmberSymbol.class);

    Map map;
    Integer turnCount = 0;

    public EmberSymbol(Map map) {
        this.map = map;
    }
}