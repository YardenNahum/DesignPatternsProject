package Backend.Factory;

public class InsuranceFactory {

    // use getInsurance method to get object of Insurance
    public Insurance createInsurance(String insuranceType) {
        if (insuranceType == null) {
            return null;
        }

        if (insuranceType.equalsIgnoreCase("Car")) {
            return new CarInsurance();

        } else if (insuranceType.equalsIgnoreCase("Apartment")) {
            return new ApartmentInsurance();

        } else if (insuranceType.equalsIgnoreCase("Life")) {
            return new LifeInsurance();

        } else if (insuranceType.equalsIgnoreCase("Health")) {
            return new HealthInsurance();
        }

        return null;
    }
}
