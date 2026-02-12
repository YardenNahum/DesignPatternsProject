package Frontend.ViewAllPurchasesPage;

import Backend.Builder.InsuranceDetails;
import Backend.FilterLogic.CriteriaType;
import Backend.FilterLogic.PurchaseFilter;
import Backend.ObserverLogic.PurchaseConcreteObserver;
import Backend.SingleTone.FileManager;
import Frontend.HomePage.HomePageController;
import Frontend.Utils.Utils;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class ViewAllPurchasesController {
    @FXML private TableView<InsuranceDetails> PurchasesTable;
    @FXML private TableColumn<InsuranceDetails, String> colFirstName;
    @FXML private TableColumn<InsuranceDetails, String> colLastName;
    @FXML private TableColumn<InsuranceDetails, String> colDate;
    @FXML private TableColumn<InsuranceDetails, String> celRemarks;
    @FXML private Button SearchBtn;
    @FXML private ComboBox<CriteriaType> searchCriteriaCombo;
    @FXML private TextField searchField;
    @FXML private Label ConfigText;

    private PurchaseConcreteObserver observer;

    @FXML
    public void initialize()
    {
        setConfig();
        //Subscribe to observer
        this.observer = HomePageController.getPurchaseObserver();
        if (this.observer != null)
        {
            this.observer.setController(this);
        }
        setupTableColumns();
        //Set up filter combo box
        searchCriteriaCombo.setItems(FXCollections.observableArrayList(CriteriaType.values()));
        //Set to default value
        if (!searchCriteriaCombo.getItems().isEmpty()) {
            searchCriteriaCombo.getSelectionModel().select(CriteriaType.NONE);
        }
        refreshTable();
    }
    // set setup table columns
    private void setupTableColumns() {
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("FamilyName"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        celRemarks.setCellValueFactory(new PropertyValueFactory<>("Remarks"));
    }
    //set Config text
    private void setConfig()
    {
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

    //Navigate to home Page
    @FXML
    public void HandleGoBackToPreviousPage(MouseEvent mouseEvent)
    {
        Utils.navigate(mouseEvent, "/Frontend/HomePage/HomePage.fxml", "Insurance Company Management");
    }


    @FXML
    public void HandleSearchPurchase(MouseEvent mouseEvent)
    {
        //update the table by the criteria
        refreshTable();
    }

    public void refreshTable()
    {
        List<InsuranceDetails> purchases = observer.getPreviousPurchases();
        if(!purchases.isEmpty()){
            //get search criteria
            CriteriaType criteria = searchCriteriaCombo.getValue();
            //get search text from input
            String searchText = searchField.getText();
            //filter by the criteria
            List<InsuranceDetails> filtered = PurchaseFilter.filter(purchases, criteria, searchText);
            //set up the columns
            PurchasesTable.setItems(FXCollections.observableArrayList(filtered));
        }

    }
}
