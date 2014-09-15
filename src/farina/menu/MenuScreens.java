package farina.menu;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import de.lessvoid.nifty.Nifty;

/**
 *
 * @author FalseCAM
 */
public class MenuScreens extends AbstractAppState {

    private Nifty nifty;
    private MainMenuController mainMenuController;

    public MenuScreens() {
        initController();
        loadNiftyXML();
        registerController();
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stateAttached(AppStateManager stateManager) {
        super.stateAttached(stateManager);
        stateManager.attach(mainMenuController);
    }

    @Override
    public void stateDetached(AppStateManager stateManager) {
        super.stateDetached(stateManager);
        stateManager.detach(mainMenuController);
    }

    private void initController() {
        mainMenuController = new MainMenuController();
    }

    private void loadNiftyXML() {
        nifty.addXml("Interface/Menu/mainmenu.xml");
    }

    private void registerController() {
        nifty.registerScreenController(mainMenuController);
    }
}
