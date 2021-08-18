package Engeto_Project1_VATrates;

public class Main {

    public static void main(String[] args) {

        StateList summary = new StateList();
        try{
            summary = StateList.importFromTextFile("vat-eu.csv");
        } catch(StateException e){
            System.err.println("Loading data from file failed" + e.getLocalizedMessage());
        }

        System.out.println(summary.getStateList(25).getStateAbbrev());


    }
}
