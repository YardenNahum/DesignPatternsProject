package Backend.Builder;
import Backend.HomePage.InsuranceType;


public class InsuranceDetails {

    //Insurance details fields
    private final String name;
    private final String familyName;
    private final String date;
    private final String remarks;
    private final InsuranceType insuranceType;

    // Private constructor that accepts a Builder instance
    private InsuranceDetails(Builder builder) {
        this.name = builder.name;
        this.familyName = builder.familyName;
        this.date = builder.date;
        this.remarks = builder.remarks;
        this.insuranceType = builder.insuranceType;
    }

    // Getters for the fields
    public String getName() { return name; }
    public String getFamilyName() { return familyName; }
    public String getDate() { return date; }
    public String getRemarks() { return remarks; }
    public InsuranceType getInsuranceType() { return insuranceType; }

    // Returns a string for the insurance details
    @Override
    public String toString() {
        return "Product{name=" + name + ", familyName='" + familyName + "', date='" + date + "', remarks='" + remarks + "',  insuranceType='" + insuranceType + '}' ;
    }

    // Builder for the InsuranceDetails
    public static class Builder {
        private String name;
        private String familyName;
        private String date;
        private String remarks;
        private InsuranceType insuranceType;

        //Set the name of the customer
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        //Set the famiy name of the customer
        public Builder familyName(String familyName) {
            this.familyName = familyName;
            return this;
        }

        // Set the purchase date
        public Builder date(String date) {
            this.date = date;
            return this;
        }

        // Set the remarks for the purchase
        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        // Set the insurance type
        public Builder insuranceType(InsuranceType insuranceType) {
            this.insuranceType = insuranceType;
            return this;
        }

        // The final build method creates and returns the insuranceDetails object
        public InsuranceDetails build() {
            if (name == null || familyName == null || date == null || remarks == null || insuranceType == null) {
                throw new IllegalStateException("All fields must be set before build()");
            }
            return new InsuranceDetails(this);
        }
        // building record for logger
        public String toString() {
            return String.format("name: %s, FamilyName: %s, Date: %s, InsuranceType: %s, remarks: %s",
                    name, familyName, date, insuranceType, remarks);
        }
    }
}
