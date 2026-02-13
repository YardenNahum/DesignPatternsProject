package Backend.ObserverLogic;

import Backend.Builder.InsuranceDetails;
import Frontend.ViewAllPurchasesPage.ViewAllPurchasesController;

import java.util.ArrayList;
import java.util.List;

//observer to purchase data updates
public class PurchaseConcreteObserver extends PurchaseObserver {

    private ViewAllPurchasesController viewController;
    private List<InsuranceDetails> purchases = new ArrayList<>();

    //connect the observer to the data manager
    public PurchaseConcreteObserver(PurchaseDataManager dataManager) {
        this.dataManager =dataManager;
        this.dataManager.attach(this);
    }
    // // Sets the controller
    public void setController(ViewAllPurchasesController controller) {
        this.viewController = controller;
    }

    // Updates the purchases list from the data manager
    private void updatePurchases() {
        if (dataManager != null) {
            this.purchases = dataManager.getAllPurchases();
        }
    }

    // Return the previous purchase
    public List<InsuranceDetails> getPreviousPurchases() {
        return purchases;
    }

    // update when the data manager changes
    @Override
    public void update()
    {
        System.out.println("Concrete Observer: Notify received from DataManager!");
        updatePurchases();
        // Refresh UI after updating the data
        if (viewController != null) {
            viewController.refreshTable();
        }
    }
}
