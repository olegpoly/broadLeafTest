package com.mycompany.sample.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "US_SIZE")
public class UsSize extends AlphabeticnotationSize {
}
