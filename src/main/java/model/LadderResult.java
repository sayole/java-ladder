package model;

public class LadderResult {
    private String result;
    private static final int VALUE_BOUND = 6;

    public LadderResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
