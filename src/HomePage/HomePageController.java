package HomePage;

import Backend.HomePage.InsuranceType;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomePageController extends Application {
    @Override
    public void start(Stage stage) {
        try {
            // טעינת קובץ ה-FXML
            // וודאי שהנתיב נכון לפי מבנה התיקיות שלך (למשל: "/HomePage/HomePage.fxml")
            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));

            // יצירת ה-Scene עם ה-root שנטען מה-FXML
            Scene scene = new Scene(root);
            // הגדרת הכותרת והצגת החלון
            stage.setTitle("Insurance Company Management");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("Error loading FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCarInsurance(MouseEvent event) {
        System.out.println(InsuranceType.CAR);
    }
    @FXML
    private void handleApartmentInsurance(MouseEvent event) {
        System.out.println(InsuranceType.APARTMENT);
    }
    @FXML
    private void handleLifeInsurance(MouseEvent event) {
        System.out.println(InsuranceType.LIFE);
    }
    @FXML
    private void handleHealthInsurance(MouseEvent event) {
        System.out.println(InsuranceType.HEALTH);
    }
    @FXML
    public void handleViewALLPurchases(MouseEvent mouseEvent) {
    }




    public static void main(String[] args) {
        launch(args);
    }


}
