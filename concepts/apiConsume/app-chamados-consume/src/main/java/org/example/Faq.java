package org.example;

import java.time.LocalDateTime;

public class Faq {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }



    @Override
    public String toString() {
        return "Faq{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
