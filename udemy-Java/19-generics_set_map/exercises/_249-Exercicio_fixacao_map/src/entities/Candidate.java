package entities;

import java.util.Objects;

public class Candidate {

    private String name;

    public Candidate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidate)) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(getName(), candidate.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
