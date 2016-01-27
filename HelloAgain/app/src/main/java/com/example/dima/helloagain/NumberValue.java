package com.example.dima.helloagain;

/**
 * Created by Dima on 12/14/2015.
 */
public class NumberValue {
    private int number;
    public NumberValue(){
        number = 0;
    }
    public NumberValue(int num){
        number = num;
    }
    public void setNumber(int num)
    {
        number = num;
    }
    public int getNumber()
    {
        return number;
    }
    public void increment()
    {
        number++;
    }
}
