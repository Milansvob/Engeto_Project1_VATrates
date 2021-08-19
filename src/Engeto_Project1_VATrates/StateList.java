package Engeto_Project1_VATrates;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class StateList {

    public static final String DELIMITER = "\t";

    private ArrayList<State> stateList = new ArrayList<>();
    private String input = "25";

    public static StateList importFromTextFile(String fileName) throws StateException {
        StateList list = new StateList();
        try (Scanner sc = new Scanner(new FileInputStream(fileName))){
            while (sc.hasNextLine()){
                String inputLine = sc.nextLine();
                // Parse of text into String[]items according DELIMITER
                String[] items = inputLine.split(DELIMITER);
                if(items.length>5)throw new StateException(" / Wrong number of items on row / " + inputLine + " / Items number:" + items.length + " - must be 5!");
                State state = new State(items[0],items[1],items[2],items[3],items[4]);
                list.addState(state);
                //System.out.println(inputLine);
            }
        } catch (FileNotFoundException ex){
            throw new StateException("Soubor " + fileName + " nenalezen:" + ex.getLocalizedMessage());
        }
        return list;
    }

    public void exportToFile(String filename) throws StateException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filename))){
            for (State state : stateList){
                writer.println(state.getStateAbbrev() + DELIMITER
                        + state.getState() + DELIMITER
                        + state.getVatStandardRate());
            }
        }catch (FileNotFoundException e){
            throw new StateException("");
        }
    }

    public State getDemanedState(int i) {return stateList.get(i);}

    public void addState(State state) {stateList.add(state); }

    public List<State> getStateList() {return stateList; }

    public void removeDemanedState(int i) { stateList.remove(i);}


    //Input from console and assign VAT standard limit "20%" to key ENTER.
    public String setEnterVatFromConsole() throws StateException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter VAT standard rate:");
        input = sc.nextLine();
        if (input.equals("")) input = "20";
        try {
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new StateException ("Wrong format of input from Console, please enter number! " + e.getMessage());
        }
        return input;
    }

    public String getEnterVatFromConsole(){
        return input;
    }

}
