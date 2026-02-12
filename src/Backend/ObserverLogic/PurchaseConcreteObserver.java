package Backend.ObserverLogic;

import Backend.Builder.InsuranceDetails;
import Frontend.ViewAllPurchasesPage.ViewAllPurchasesController;

import java.util.ArrayList;
import java.util.List;

public class PurchaseConcreteObserver extends PurchaseObserver {
    private ViewAllPurchasesController viewController;
    private List<InsuranceDetails> purchases = new ArrayList<>();
    public PurchaseConcreteObserver(PurchaseDataManager dataManager) {
        this.dataManager =dataManager;
        this.dataManager.attach(this);
    }
    public void setController(ViewAllPurchasesController controller) {
        this.viewController = controller;
    }
    private void updatePurchases() {
        if (dataManager != null) {
            this.purchases = dataManager.getAllPurchases();
        }
    }

    public List<InsuranceDetails> getPreviousPurchases() {
        return purchases;
    }
    @Override
    public void update()
    {
        System.out.println("Concrete Observer: Notify received from DataManager!");
        updatePurchases();
        if (viewController != null) {
            viewController.refreshTable();
        }
    }
}
