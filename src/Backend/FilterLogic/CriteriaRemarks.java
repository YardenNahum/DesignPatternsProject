package Backend.FilterLogic;

import Backend.Builder.InsuranceDetails;

import java.util.ArrayList;

public class CriteriaRemarks implements Criteria
{
    private String searchText;

    public CriteriaRemarks(String searchText) {
        this.searchText = searchText.toLowerCase();
    }

    @Override
    public ArrayList<InsuranceDetails> meetCriteria(ArrayList<InsuranceDetails> purchases) {
        ArrayList<InsuranceDetails> purchasesResult =new ArrayList<>();
        if (searchText == null || searchText.isEmpty()) {
            return purchases;

        }
        //Search for all the purchases that contains the search text in their remarks field

        for(InsuranceDetails purchase: purchases)
        {
            if(purchase.getRemarks().toLowerCase().contains(searchText))
            {
                purchasesResult.add(purchase);
            }
        }
        return purchasesResult;
    }
}
