package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Person {
    private String name;
    private LocalDate born;

    public Person(String name, LocalDate born) {
        this.name = name;
        this.born = born;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(this.born, LocalDate.now());
    }

    public boolean isOfLegalAge() {
        return getAge() >= 18;
    }
}
