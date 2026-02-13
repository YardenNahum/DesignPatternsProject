package Backend.FilterLogic;

import Backend.Builder.InsuranceDetails;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFamilyName implements Criteria
{
    private String searchText;

    public CriteriaFamilyName(String searchText) {
        this.searchText = searchText.toLowerCase();
    }

    @Override
    public List<InsuranceDetails> meetCriteria(List<InsuranceDetails> purchases) {
        List<InsuranceDetails> purchasesResult =new ArrayList<>();
        if (searchText == null || searchText.isEmpty()) {
            return purchases;

        }
        //Search for all the purchases that contains the search text in their family name field
        for(InsuranceDetails purchase: purchases)
        {
            if(purchase.getFamilyName().toLowerCase().contains(searchText))
            {
                purchasesResult.add(purchase);
            }
        }
        return purchasesResult;
    }
}
