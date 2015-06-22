package com.mycompany.sample.domain;

import org.broadleafcommerce.core.catalog.domain.ProductImpl;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class MyProduct extends ProductImpl {
    @OneToOne
    protected EuSize euSize;
    @OneToOne
    protected UsSize usSize;
    @OneToOne
    protected UkSize ukSize;

    public EuSize getEuSize() {
        return euSize;
    }

    public void setEuSize(EuSize euSize) {
        this.euSize = euSize;
    }

    public UsSize getUsSize() {
        return usSize;
    }

    public void setUsSize(UsSize usSize) {
        this.usSize = usSize;
    }

    public UkSize getUkSize() {
        return ukSize;
    }

    public void setUkSize(UkSize ukSize) {
        this.ukSize = ukSize;
    }
}
