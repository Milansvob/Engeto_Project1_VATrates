package Engeto_Project1_VATrates;

public class State {
    private String stateAbbrev;
    private String state;
    private Integer vatStandardRate;
    private Double vatReducedRate;
    private Boolean vatSpecialRate;

    public State(String stateAbbrevStr, String stateStr, String vatStandardRateStr, String vatReducedRateStr, String vatSpecialRateStr) throws StateException {
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

        if ((vatSpecialRateStr.toLowerCase().equals("true")) || (vatSpecialRateStr.toLowerCase().equals("false"))) {
            this.vatSpecialRate = Boolean.parseBoolean(vatSpecialRateStr);
        }
        else throw new StateException(" / Wrong format of VAT special rate");
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
        return vatSpecialRate;
    }

    public void setVatSpecialRate(Boolean vatSpecialRate) {
        this.vatSpecialRate = vatSpecialRate;
    }

}
