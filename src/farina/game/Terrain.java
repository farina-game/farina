package farina.game;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.scene.Node;
import com.jme3.terrain.geomipmap.TerrainQuad;
import com.jme3.terrain.heightmap.AbstractHeightMap;
import com.jme3.terrain.heightmap.ImageBasedHeightMap;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture.WrapMode;

/**
 *
 * @author FalseCAM
 */
public class Terrain {

    private TerrainQuad terrain;
    private Material terrainMat;
    private final AssetManager assetManager;

    public Terrain(AssetManager assetManager) {
        this.assetManager = assetManager;
        terrainMat = new Material(assetManager,
                "Common/MatDefs/Terrain/Terrain.j3md");
        terrainMat.setTexture("Alpha", assetManager.loadTexture(
                "alphamap.png"));
        // red Texture
        Texture tex1 = assetManager.loadTexture(
                "redTex.png");
        tex1.setWrap(WrapMode.Repeat);
        terrainMat.setTexture("Tex1", tex1);
        terrainMat.setFloat("Tex1Scale", 64f);
        // green Texture
        Texture tex2 = assetManager.loadTexture(
                "greenTex.png");
        tex1.setWrap(WrapMode.Repeat);
        terrainMat.setTexture("Tex2", tex2);
        terrainMat.setFloat("Tex2Scale", 64f);
        // blue Texture
        Texture tex3 = assetManager.loadTexture(
                "blueTex.png");
        tex3.setWrap(WrapMode.Repeat);
        terrainMat.setTexture("Tex3", tex3);
        terrainMat.setFloat("Tex3Scale", 64f);

        // create heightmap
        AbstractHeightMap heightmap = null;
        Texture heightMapImage = assetManager.loadTexture(
                "heightmap.png");
        heightmap = new ImageBasedHeightMap(heightMapImage.getImage());
        heightmap.load();

        int patchSize = 65;
        terrain = new TerrainQuad("terrain", patchSize, 513, heightmap.getHeightMap());
        terrain.setMaterial(terrainMat);
        terrain.setLocalTranslation(0, -100, 0);
        terrain.setLocalScale(2f, 0.1f, 2f);

    }

    public Node getNode() {
        return terrain;
    }
}
