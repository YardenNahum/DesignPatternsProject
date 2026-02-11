package Backend.FilterLogic;

import Backend.Factory.Insurance;

import java.util.ArrayList;
public interface Criteria
{
    ArrayList<Insurance> meetCriteria(ArrayList<Insurance> purchases);
}
