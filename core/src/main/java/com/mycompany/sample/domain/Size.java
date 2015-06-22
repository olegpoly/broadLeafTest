package com.mycompany.sample.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "SIZE_TYPE")
@Table(name = "SIZE")
public class Size {
    @Id
    @Column(name = "SIZE_ID")
    protected Long id;

    protected String numericnotation;

    public String getNumericnotation() {
        return numericnotation;
    }

    public void setNumericnotation(String numericnotation) {
        this.numericnotation = numericnotation;
    }

    @Override
    public String toString() {
        return numericnotation;
    }
}
