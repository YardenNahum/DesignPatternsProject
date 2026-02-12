package Backend.ObserverLogic;

public abstract class PurchaseObserver {
    protected PurchaseDataManager dataManager;
    public abstract void update();
}
