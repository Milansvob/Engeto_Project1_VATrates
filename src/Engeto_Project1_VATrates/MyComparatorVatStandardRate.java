package Engeto_Project1_VATrates;

import java.util.Comparator;

public class MyComparatorVatStandardRate implements Comparator<State> {
    @Override
    public int compare(State o1, State o2) {
        return (int) (o1.getVatStandardRate() - o2.getVatStandardRate());
    }
}
