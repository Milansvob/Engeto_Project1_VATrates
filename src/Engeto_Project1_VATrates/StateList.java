package Engeto_Project1_VATrates;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StateList {

    public static final String DELIMITER = "\t";

    Map<Integer, State> stateList = new HashMap();

    public static StateList importFromTextFile(String fileName) throws StateException {
        StateList list = new StateList();
        try (Scanner sc = new Scanner(new FileInputStream(fileName))){
            while (sc.hasNextLine()){
                String inputLine = sc.nextLine();
                // Parse of text into String[]items according DELIMITER
                String[] items = inputLine.split(DELIMITER);
                State state = new State(items[0],items[1],items[2],items[3],items[4]);
                list.putState(state.getVatStandardRate(), state);
                // System.out.println(inputLine);
            }
        } catch (FileNotFoundException ex){
            throw new StateException("Soubor " + fileName + " nenalezen:" + ex.getLocalizedMessage());
        }
        return list;
    }

    public State getStateList(Integer i) {
        return stateList.get(i);
    }

    public void putState(Integer getVatStandardRate,State state) {
        stateList.put(getVatStandardRate,state);
    }
}
