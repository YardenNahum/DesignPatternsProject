package Backend.HomePage;

public enum InsuranceType {
    APARTMENT,
    CAR,
    HEALTH,
    LIFE;

    @Override
    public String toString() {
        switch (this){
            case InsuranceType.CAR:
                return "Car Insurance";
            case LIFE:
                return "Life Insurance";
            case HEALTH:
                return "Health Insurance";
            case APARTMENT:
                return "Apartment Insurance";
            default:
                return "Not Found";
        }
    }
}