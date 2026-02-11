package Backend.FilterLogic;

import Backend.Builder.InsuranceDetails;

import java.util.ArrayList;
//Interface for filtering by a criteria
public interface Criteria
{
    ArrayList<InsuranceDetails> meetCriteria(ArrayList<InsuranceDetails> purchases);
}
