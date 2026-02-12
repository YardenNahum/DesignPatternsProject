package Backend.HomePage;


public enum InsuranceType {
    //different types of insurance
    APARTMENT,
    CAR,
    HEALTH,
    LIFE;

    //returns a string to every insurance type
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