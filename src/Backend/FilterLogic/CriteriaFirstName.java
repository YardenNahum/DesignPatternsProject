package Backend.FilterLogic;

import Backend.Factory.Insurance;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFirstName implements Criteria
{
    private String searchText;

    public CriteriaFirstName(String searchText) {
        this.searchText = searchText.toLowerCase();
    }

    @Override
    public ArrayList<Insurance> meetCriteria(ArrayList<Insurance> purchases) {
        ArrayList<Insurance> purchasesResult =new ArrayList<>();
        if (searchText == null || searchText.isEmpty()) {
            return purchases;

        }
        for(Insurance purchase: purchases)
        {

        }
        return purchasesResult;
    }
}
