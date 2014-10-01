package farina.game;

/**
 *
 * @author FalseCAM
 */
public class Level {

    private final String name;
    private final Terrain terrain;

    public Level(String name, Terrain terrain) {
        this.name = name;
        this.terrain = terrain;
    }

    public Terrain getTerrain() {
        return terrain;
    }
}
