package Engeto_Project1_VATrates;

import java.sql.RowId;

public class State {
    private String stateAbbrev;
    private String state;
    private Integer vatStandardRate;
    private Double vatReducedRate;
    private Boolean isVatSpecialRate;

    public State(String stateAbbrevStr, String stateStr, String vatStandardRateStr, String vatReducedRateStr, String isVatSpecialRateStr) throws StateException {
        this.stateAbbrev = stateAbbrevStr;
        this.state = stateStr;
        try {
            this.vatStandardRate = Integer.valueOf(vatStandardRateStr);
        }catch(NumberFormatException ex){
            throw new StateException(" / Wrong format of VAT standard rate / " + ex.getLocalizedMessage());
        }
        try {
            this.vatReducedRate = Double.valueOf(vatReducedRateStr);
        }catch(NumberFormatException ex){
            throw new StateException(" / Wrong format of VAT reduced rate / " + ex.getLocalizedMessage());
        }
        String isVatSpecialRateStrLower = isVatSpecialRateStr.toLowerCase();
        if ((isVatSpecialRateStrLower.equals("true")) || (isVatSpecialRateStrLower.equals("false"))) {
            this.isVatSpecialRate = Boolean.parseBoolean(isVatSpecialRateStr);
        }
        else throw new StateException(" / Wrong format of is VAT special rate - type boolean");
        }

    public String getStateAbbrev() {
        return stateAbbrev;
    }

    public void setStateAbbrev(String stateAbbrev) {
        this.stateAbbrev = stateAbbrev;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getVatStandardRate() {
        return vatStandardRate;
    }

    public void setVatStandardRate(Integer vatStandardRate) {
        this.vatStandardRate = vatStandardRate;
    }

    public Double getVatReducedRate() {
        return vatReducedRate;
    }

    public void setVatReducedRate(Double vatReducedRate) {
        this.vatReducedRate = vatReducedRate;
    }

    public Boolean isVatSpecialRate() {
        return isVatSpecialRate;
    }

    public void setIsVatSpecialRate(Boolean isVatSpecialRate) {
        this.isVatSpecialRate = isVatSpecialRate;
    }

    @Override
    public String toString() {
        return state + "(" + stateAbbrev + "):" + vatStandardRate + "%";
    }
}
