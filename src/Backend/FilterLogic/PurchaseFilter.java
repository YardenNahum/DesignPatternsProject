package Backend.FilterLogic;

import Backend.Builder.InsuranceDetails;

import java.util.ArrayList;
import java.util.List;

public class PurchaseFilter
{
    public static List<InsuranceDetails> filter(List<InsuranceDetails> purchases, CriteriaType type, String searchText) {
        if (type == null||type==CriteriaType.NONE) {
            return purchases;
        }
        Criteria criteria;
        //Criteria Factory
        switch(type){
            case DATE:
                criteria = new CriteriaDate(searchText);
                break;
            case NAME:
                criteria = new CriteriaFirstName(searchText);
                break;
            case FAMILY_NAME:
                criteria = new CriteriaFamilyName(searchText);
                break;
            case REMARKS:
                criteria = new CriteriaRemarks(searchText);
                break;
            default:
                return purchases;
        }
        return criteria.meetCriteria(purchases);
    }
}
