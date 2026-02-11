package Frontend.HomePage;

import Backend.HomePage.InsuranceType;
import Backend.SingleTone.FileManager;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController extends Application {
    @FXML
    private Label ConfigText;
    private String sellPagePath = "/Frontend/InsurancePurchasePage/InsurancePage.fxml";
    @Override
    public void start(Stage stage) {
        try {
            //Load HomePage FXML
            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene scene = new Scene(root);
            //Set Stage Title
            stage.setTitle("Insurance Company Management");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("Error loading FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        try {
            String config = FileManager.getInstance().readConfigFile();
            if (ConfigText != null) {
                ConfigText.setText(config);
            }
            System.out.println("Config loaded successfully: " + config);

        } catch (Exception e) {
            System.err.println("Failed to load config: " + e.getMessage());
        }
    }
    @FXML
    private void handleCarInsurance(MouseEvent event) {
        String title = " Purchase - " + InsuranceType.CAR.toString();
        navigateToSellPage(InsuranceType.CAR,event,sellPagePath,title);
    }
    @FXML
    private void handleApartmentInsurance(MouseEvent event) {
        String title = " Purchase - " + InsuranceType.APARTMENT.toString();
        navigateToSellPage(InsuranceType.APARTMENT,event,sellPagePath,title);
    }
    @FXML
    private void handleLifeInsurance(MouseEvent event) {
        String title = " Purchase - " + InsuranceType.LIFE.toString();
        navigateToSellPage(InsuranceType.LIFE,event,sellPagePath,title);
    }
    @FXML
    private void handleHealthInsurance(MouseEvent event) {
        String title = " Purchase - " + InsuranceType.HEALTH.toString();
        navigateToSellPage(InsuranceType.HEALTH,event,sellPagePath,title);
    }
    @FXML
    public void handleViewALLPurchases(MouseEvent mouseEvent) {
    }

    private void navigateToSellPage(InsuranceType insuranceType, MouseEvent event, String pagePath, String title)
    {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(pagePath));
            Parent root = loader.load();
            Frontend.InsurancePurchasePage.InsurancePageController controller = loader.getController();
            controller.setInsuranceType(insuranceType);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();

        } catch (IOException e) {
            System.err.println("Error in moving to page" + e.getMessage());
            e.printStackTrace();
        }
    }


}
