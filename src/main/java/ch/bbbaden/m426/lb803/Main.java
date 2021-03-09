package ch.bbbaden.m426.lb803;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Manuel Bachofner
 */
public class Main extends Application {

    public final static String VIEW_FILE = "/fxml/ChiffrierMethoden.fxml";

    @Override
    public void start(Stage stage) {

        Parent root;
        try {
            final FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(VIEW_FILE));
            root = fxmlloader.load();
            final ChiffreController viewController = fxmlloader.getController();

            final Scene scene = new Scene(root);
            stage.setTitle("Chiffriermethoden");
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }

}
