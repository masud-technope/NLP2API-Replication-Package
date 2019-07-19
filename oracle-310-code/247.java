package org.kodejava.example.bean;

import java.beans.VetoableChangeSupport;
import java.beans.PropertyVetoException;

public class VetoBean {
    private double interest;

    private VetoableChangeSupport vcs = new VetoableChangeSupport(this);

    public VetoBean() {
        vcs.addVetoableChangeListener(new VetoChangeListener());
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        try {
            vcs.fireVetoableChange("interest", new Double(this.interest), new Double(interest));

            this.interest = interest;
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VetoBean bean = new VetoBean();
        bean.setInterest(10.99);
        bean.setInterest(15.99);
        
        //
        // PropertyVetoException will be thrown beacuse the interest value 
        // should not exceed 20.00.
        //
        bean.setInterest(20.99);
    }
}
