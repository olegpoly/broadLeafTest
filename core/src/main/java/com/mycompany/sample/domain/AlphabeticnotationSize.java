package com.mycompany.sample.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AlphabeticnotationSize extends Size {
    protected String alphabeticSize;

    public String getAlphabeticSize() {
        return alphabeticSize;
    }

    public void setAlphabeticSize(String alphabeticSize) {
        this.alphabeticSize = alphabeticSize;
    }

    @Override
    public String toString() {
        return super.toString() + " " + alphabeticSize;
    }
}
