package com.mycompany.sample.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "EU_SIZE")
public class EuSize extends Size {

}
