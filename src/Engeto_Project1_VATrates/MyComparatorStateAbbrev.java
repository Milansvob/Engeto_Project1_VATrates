package Engeto_Project1_VATrates;

import java.util.Comparator;

public class MyComparatorStateAbbrev implements Comparator<State> {
    @Override
    public int compare(State o1, State o2) {
        return (int) (o1.getStateAbbrev().compareTo(o2.getStateAbbrev()));
        }
}
