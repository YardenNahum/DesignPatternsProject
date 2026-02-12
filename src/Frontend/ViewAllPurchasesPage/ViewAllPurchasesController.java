package Frontend.ViewAllPurchasesPage;

import Frontend.Utils.Utils;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import jdk.jshell.execution.Util;

public class ViewAllPurchasesController {


    @FXML
    public void initialize()
    {


    }

    //Navigate to home Page
    @FXML
    public void HandleGoBackToPreviousPage(MouseEvent mouseEvent)
    {
        Utils.navigate(mouseEvent, "/Frontend/HomePage/HomePage.fxml", "Insurance Company Management");
    }
}
