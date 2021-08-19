package Engeto_Project1_VATrates;

import java.util.*;

public class Main {

    public static final String VAT_EU_CSV = "vat-eu.csv";
    public static final int VAT_STANDARD_LIMIT = 20;
    public static final String VAT_EU_OUTPUT1_CSV = "vat-over-20.txt";
    public static final String VAT_EU_OUTPUT2_CSV = "vat-over-input_from_console.txt";

    public static void main(String[] args) throws StateException {

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
        Collections.sort(summary.getStateList(),new MyComparatorVatStandardRate());

        //Sort of state list according VAT standard rate in descending order.
        Collections.reverse(summary.getStateList());

        //Report of states with VAT Standard Rate bigger then 20%, print into console.
        for (int i = 0 ; i < summary.getStateList().size(); i++ ) {
            if (summary.getDemanedState(i).getVatStandardRate() > VAT_STANDARD_LIMIT) {
                System.out.println(summary.getDemanedState(i));
            }
        }

        //Row with equal sign , print into console.
        System.out.println("====================");

        //Sort of state list according state abbreviation in ascending order.
        Collections.sort(summary.getStateList(),new MyComparatorStateAbbrev());

        //Report of states with VAT rate 20% or higher or use special VAT rate:, print into console.
        System.out.print("VAT rate 20% or lower or use special VAT rate: " );
        for (State sum: summary.getStateList() ) {
            if (sum.getVatStandardRate() <= VAT_STANDARD_LIMIT) {
                System.out.print(sum.getStateAbbrev() + ", ");
            }
        }

        // Removal of State with VAT standard limit equal or less then 20%.
        //Two possible way, the second one is like comment (both is function).
        for (int i = summary.getStateList().size()-1; i>=0 ; i-- ) {
            if (summary.getDemanedState(i).getVatStandardRate() <= VAT_STANDARD_LIMIT) {
                summary.removeDemanedState(i);
            }
        }

//        Iterator<State> it = summary.getStateList().iterator();
//        while (it.hasNext()) {
//            State name = it.next();
//            if (name.getVatStandardRate() <=VAT_STANDARD_LIMIT){
//                it.remove();
//            }
//        }

        //Sort of state list according VAT standard rate in ascending order.
        Collections.sort(summary.getStateList(),new MyComparatorVatStandardRate());

        //Sort of state list according VAT standard rate in descending order.
        Collections.reverse(summary.getStateList());

        // First import into PLANTS_OUTPUT_TXT
        try{
            summary.exportToFile(VAT_EU_OUTPUT1_CSV);
        }catch (StateException e){
            e.printStackTrace();
        }

        System.out.println("\n" + "====================");

        //Download states form VAT_EU_CSV.
        try{
            summary = StateList.importFromTextFile(VAT_EU_CSV);
        } catch(StateException e){
            System.err.println("Loading data from file failed" + e.getLocalizedMessage());
        }

        //Sort of state list according VAT standard rate in ascending order.
        Collections.sort(summary.getStateList(),new MyComparatorVatStandardRate());

        //Sort of state list according VAT standard rate in descending order.
        Collections.reverse(summary.getStateList());

        //Input from console and assign VAT standard limit "20%" to key ENTER.
        summary.setEnterVatFromConsole();

        for (State sum: summary.getStateList() ) {
            if (sum.getVatStandardRate()> Integer.parseInt(summary.getEnterVatFromConsole())) System.out.println(sum);
        }

        // Removal of State with VAT standard limit equal or less then 20%.
        for (int i = summary.getStateList().size()-1; i>=0 ; i-- ) {
            if (summary.getDemanedState(i).getVatStandardRate() <= Integer.parseInt(summary.getEnterVatFromConsole())) {
                summary.removeDemanedState(i);
            }
        }

        // Second import into PLANTS_OUTPUT_TXT
        try{
            summary.exportToFile(VAT_EU_OUTPUT2_CSV);
        }catch (StateException e){
            e.printStackTrace();
        }



    }
}
