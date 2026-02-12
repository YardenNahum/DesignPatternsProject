package Backend.FilterLogic;

import Backend.Builder.InsuranceDetails;

import java.util.ArrayList;
import java.util.List;

//Interface for filtering by a criteria
public interface Criteria
{
    List<InsuranceDetails> meetCriteria(List<InsuranceDetails> purchases);
}
