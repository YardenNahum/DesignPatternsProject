package Frontend.InsurancePurchasePage;


import Backend.HomePage.InsuranceType;
import Frontend.Utils.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InsurancePageController {
    private InsuranceType insuranceType;
    @FXML private Label FormTitle;
    @FXML private TextField NameInput;
    @FXML private TextField FamilyNameInput;
    @FXML private DatePicker DateInput;
    @FXML private TextArea RemarksInput;
    @FXML private Label AlertText;

    public void setInsuranceType(InsuranceType insuranceType)
    {
        this.insuranceType = insuranceType;
        if (FormTitle != null && insuranceType != null) {
            FormTitle.setText("Purchase - " + insuranceType.toString());
        }
    }

    @FXML
    public void HandleSaveForm(MouseEvent mouseEvent) {
        //check for missing Input
        if (NameInput.getText().isEmpty() || FamilyNameInput.getText().isEmpty() || DateInput.getValue()==null||isValidDateFormat(DateInput.getValue()))
        {
            showAlert("Error: Please fill in all required fields!", "alert-error");
        }
        else
        {
            showAlert("Success! Your " + insuranceType + " policy has been saved.", "alert-success");
            HandleRefreshForm(mouseEvent);
        }
    }

    private void showAlert(String message, String styleClass) {
        AlertText.setText(message);
        AlertText.getStyleClass().removeAll("alert-success", "alert-error");
        AlertText.getStyleClass().add(styleClass);
        AlertText.setVisible(true);
    }
    @FXML
    public void HandleRefreshForm(MouseEvent mouseEvent)
    {
        NameInput.setText("");
        FamilyNameInput.setText("");
        DateInput.setValue(null);
        RemarksInput.setText("");
    }

    @FXML
    public void HandleGoBackToPreviousPage(MouseEvent mouseEvent)
    {
        Utils.navigate(mouseEvent, "/Frontend/HomePage/HomePage.fxml", "Insurance Company Management");
    }

    /**
     * Checks if the date is in a correct format
     * **/
    public static boolean isValidDateFormat(LocalDate date) {
        //if its null return false
        if (date == null||date.toString().isEmpty()) {
            return false;
        }
        try {
            //if its not in the format return false
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(date.toString(), formatter);
            return true;
        }
        catch
        (DateTimeParseException e) {
            return false;
        }
    }
}
