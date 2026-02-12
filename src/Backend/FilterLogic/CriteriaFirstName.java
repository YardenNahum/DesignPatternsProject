package Backend.FilterLogic;

import Backend.Builder.InsuranceDetails;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFirstName implements Criteria
{
    private String searchText;

    public CriteriaFirstName(String searchText) {
        this.searchText = searchText.toLowerCase();
    }

    @Override
    public List<InsuranceDetails> meetCriteria(List<InsuranceDetails> purchases) {
        List<InsuranceDetails> purchasesResult =new ArrayList<>();
        if (searchText == null || searchText.isEmpty()) {
            return purchases;

        }
        //Search for all the purchases that contains the search text in their first name field

        for(InsuranceDetails purchase: purchases)
        {
            if(purchase.getName().toLowerCase().contains(searchText))
            {
                purchasesResult.add(purchase);
            }
        }
        return purchasesResult;
    }
}
