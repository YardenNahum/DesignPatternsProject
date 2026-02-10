package Backend.Factory;

// Health insurance implementation
public class HealthInsurance implements Insurance {
    @Override
    public void purchaseInsurance() {
        System.out.println("Health insurance");
    }
}
