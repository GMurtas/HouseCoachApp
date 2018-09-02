package com.example.giuliam.housecoach;

public class SensorsValue {
    public String value_1, value_2, value_3, value_4;

    public SensorsValue(String value_1, String value_2, String value_3, String value_4)
    {
        this.setValue1(value_1);
        this.setValue2(value_2);
        this.setValue3(value_3);
        this.setValue4(value_4);

    }

    public String getValue1() {
        return value_1;
    }

    public void setValue1(String value_1) {
        this.value_1 = value_1;
    }

    public String getValue2() {
        return value_2;
    }

    public void setValue2(String value_2) {
        this.value_2 = value_2;
    }

    public String getValue3() {
        return value_3;
    }

    public void setValue3(String value_3) {
        this.value_3 = value_3;
    }

    public String getValue4() {
        return value_4;
    }

    public void setValue4(String value_4) {
        this.value_4 = value_4;
    }

}
