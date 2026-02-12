package Backend.ObserverLogic;

import Backend.Builder.InsuranceDetails;

import java.util.ArrayList;
import java.util.List;

public class PurchaseDataManager {
    private static PurchaseDataManager instance;

    private final List<PurchaseObserver> observers = new ArrayList<>();
    private final List<InsuranceDetails> purchases = new ArrayList<>();

    private PurchaseDataManager() {}

    // return the singleton instance
    public static synchronized PurchaseDataManager GetInstance() {
        if (instance == null) {
            instance = new PurchaseDataManager();
        }
        return instance;
    }
    //get all purchases
    public List<InsuranceDetails> getAllPurchases() {
        return new ArrayList<>(purchases);
    }
    //add purchase to list
    public void addPurchase(InsuranceDetails record) {
        this.purchases.add(record);
        notifyAllObservers();
    }
    //add observer to the observes list
    public void attach(PurchaseObserver observer) {
        observers.add(observer);
    }
    //notify observer on new purchases
    public void notifyAllObservers() {
        for (PurchaseObserver observer : observers) {
            observer.update();
        }
    }
}
