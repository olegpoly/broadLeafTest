package com.mycompany.sample.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "UK_SIZE")
public class UkSize extends AlphabeticnotationSize {

}
