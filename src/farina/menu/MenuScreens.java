package farina.menu;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import de.lessvoid.nifty.Nifty;
import farina.Main;

/**
 *
 * @author FalseCAM
 */
public class MenuScreens extends AbstractAppState {

    private Nifty nifty;
    private MainMenuController mainMenuController;
    private ConfigMenuController configMenuController;
    AppStateManager stateManager;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.stateManager = stateManager;
        nifty = ((Main) app).getNifty();
        init("menu_main");
    }

    void init() {
        initController();
        loadNiftyXML();
        registerController();
        attachController();
    }

    public void init(final String screen) {
        new Thread(new Runnable() {
            public void run() {
                init();
                nifty.gotoScreen(screen);
            }
        }).start();
    }

    @Override
    public void cleanup() {
        super.cleanup();
        stateManager.detach(mainMenuController);
        stateManager.detach(configMenuController);
    }

    private void initController() {
        mainMenuController = new MainMenuController();
        configMenuController = new ConfigMenuController();
    }

    private void loadNiftyXML() {
        nifty.addXml("Interface/Menu/menu_main.xml");
        nifty.addXml("Interface/Menu/menu_config.xml");
    }

    private void registerController() {
        nifty.registerScreenController(mainMenuController);
        nifty.registerScreenController(configMenuController);
    }

    private void attachController() {
        stateManager.attach(mainMenuController);
        stateManager.attach(configMenuController);
    }

    public void gotoScreen(String screen) {
        nifty.gotoScreen(screen);
    }

    public void screenMainMenu() {
        gotoScreen("menu_main");
    }

    public void screenConfigMenu() {
        gotoScreen("menu_config");
    }
}
