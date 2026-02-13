package Backend.ObserverLogic;


public abstract class PurchaseObserver {
    protected PurchaseDataManager dataManager;
    //update when the data changes
    public abstract void update();
}
