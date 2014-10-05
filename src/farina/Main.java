package farina;

import com.jme3.app.SimpleApplication;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.RenderManager;
import com.jme3.system.AppSettings;
import de.lessvoid.nifty.Nifty;
import farina.game.Level;
import farina.game.LevelLoader;
import farina.menu.MenuScreens;

/**
 *
 *
 * @author FalseCAM
 */
public class Main extends SimpleApplication {

    Nifty nifty;
    MenuScreens menuScreens;

    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setTitle("MementoMori");
        Main app = new Main();
        app.setSettings(settings);
        app.setShowSettings(false);
        app.start();
    }

    public Nifty getNifty() {
        return nifty;
    }

    @Override
    public void simpleInitApp() {
        initNiftyGui();
        menuScreens = new MenuScreens();
        getStateManager().attach(menuScreens);
        
        LevelLoader levelLoader = new LevelLoader(assetManager);
        Level level = levelLoader.loadLevel("map");
        this.rootNode.attachChild(level.getTerrain().getNode());
    }

    /**
     * Initializes the nifty gui and loads xml files
     */
    void initNiftyGui() {
        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(getAssetManager(),
                getInputManager(), getAudioRenderer(), getGuiViewPort());
        nifty = niftyDisplay.getNifty();
        nifty.getSoundSystem().setMusicVolume(
                1);
        nifty.getSoundSystem().setSoundVolume(
                1);
        nifty.addXml("Interface/screen_loading.xml");
        nifty.gotoScreen("screen_loading");
        getGuiViewPort().addProcessor(niftyDisplay);
    }

    @Override
    public void simpleUpdate(float tpf) {
    }

    @Override
    public void simpleRender(RenderManager rm) {
    }
}
