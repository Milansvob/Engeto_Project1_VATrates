package Engeto_Project1_VATrates;

import java.sql.Array;
import java.util.*;

public class Main {

    public static final String VAT_EU_CSV = "vat-eu.csv";
    public static final int VAT_STANDARD_LIMIT = 20;

    public static void main(String[] args) {

        //Instance of Class StateList.
        StateList summary = new StateList();

        //Download states form VAT_EU_CSV.
        try{
            summary = StateList.importFromTextFile(VAT_EU_CSV);
        } catch(StateException e){
            System.err.println("Loading data from file failed" + e.getLocalizedMessage());
        }

        //Report of states with VAT Standard Rate, print into console.
        for (State sum: summary.getStateList() ) {
            System.out.println(sum);
        }

        //Empty row - separator
        System.out.println();

        //Sort of state list according VAT standard rate in ascending order.
        Collections.sort(summary.getStateList(),new MyComparator());

        //Sort of state list according VAT standard rate in descending order.
        Collections.reverse(summary.getStateList());

        //Report of states with VAT Standard Rate bigger then 20%, print into console.
        for (int i = 0 ; i < summary.getStateList().size(); i++ ) {
            if (summary.getDemanedState(i).getVatStandardRate() > VAT_STANDARD_LIMIT) {
                System.out.println(summary.getDemanedState(i));
            }
        }
    }
}
