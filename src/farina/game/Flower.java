package farina.game;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import com.jme3.scene.plugins.blender.BlenderModelLoader;

/**
 *
 * @author FalseCAM
 */
public class Flower extends Node {

    private final AssetManager assetManager;

    public Flower(AssetManager assetManager) {
        assetManager.registerLoader(BlenderModelLoader.class, "blend");
        this.assetManager = assetManager;

        create();
    }

    private void create() {
    }
}
