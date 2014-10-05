package farina.game;

import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.ZipLocator;

/**
 *
 * @author FalseCAM
 */
public class LevelLoader {

    private final AssetManager assetManager;

    public LevelLoader(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    /**
     * Loads a level from zip file placed in Map/ folder.
     *
     * @param name The name of the zip file without zip extension.
     */
    public Level loadLevel(String name) {
        String file = "Maps/" + name + ".zip";
        assetManager.registerLocator(file, ZipLocator.class);
        Terrain terrain = loadTerrain();
        Level level = new Level(name, terrain);
        assetManager.unregisterLocator(file, ZipLocator.class);
        return level;
    }

    private Terrain loadTerrain() {
        Terrain terrain = new Terrain(assetManager);
        return terrain;
    }
}
