package Frontend.Utils;

import Backend.ObserverLogic.PurchaseConcreteObserver;

public class AppManager {
    private static PurchaseConcreteObserver PurchaseObserver;
    //get purchase observer
    public static PurchaseConcreteObserver getPurchaseObserver() {
        return PurchaseObserver;
    }
    //set purchase observer
    public static void setPurchaseObserver(PurchaseConcreteObserver observer) {
        PurchaseObserver = observer;
    }

}
