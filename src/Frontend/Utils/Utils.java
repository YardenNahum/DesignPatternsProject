package Frontend.Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

public class Utils {

    public static void navigate(MouseEvent event, String path, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(Utils.class.getResource(path));
            Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.setTitle(title);
            stage.centerOnScreen();
            stage.show();

        } catch (java.io.IOException e) {
            System.err.println("Navigation back failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
