package com.aleks.calculatorlogicdbreceiver;

/**
 * Created by aleks on 11/04/16.
 */
public class Operand {
    private long id;
    private String operand;
    private int lifetimeCounter;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public int getLifetimeCounter() {
        return lifetimeCounter;
    }

    public void setLifetimeCounter(int lifetimeCounter) {
        this.lifetimeCounter = lifetimeCounter;
    }
}
