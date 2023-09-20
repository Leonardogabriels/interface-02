package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
    
    private LocalDate date;
    private double amout;
    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Installment(LocalDate date, double amout) {
        this.date = date;
        this.amout = amout;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmout() {
        return amout;
    }

    public void setAmout(double amout) {
        this.amout = amout;
    }

    @Override
    public String toString() {
        return date.format(fmt) + " - " + amout;
    }
    
    
    
    
}
