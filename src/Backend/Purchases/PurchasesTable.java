package Backend.Purchases;

// Generates the purchases table objects in order to represent a row in the table
public class PurchasesTable {

    private final String name;
    private final String familyName;
    private final String date;
    private final String remarks;

    public PurchasesTable(String name, String familyName, String date, String remarks) {
        this.name = name;
        this.familyName = familyName;
        this.date = date;
        this.remarks = remarks;
    }

    public String getName() { return name; }
    public String getFamilyName() { return familyName; }
    public String getDate() { return date; }
    public String getRemarks() { return remarks; }
}
