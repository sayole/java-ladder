package model;

import java.util.Random;

public class LadderResult {
    private String value;
    private static final int VALUE_BOUND = 6;

    public LadderResult() {
        setResultValue();
    }

    private void setResultValue() {
        Random random = new Random();
        int result = random.nextInt(VALUE_BOUND);
        if (result == 0) {
            value = "꽝";
            return;
        }
        value = Integer.toString(result * 1000);
    }

    public String getValue() {
        return value;
    }
}
