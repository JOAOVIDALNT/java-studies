package entities;

public class Grade {

    public String name;
    public double primeiro;
    public double segundo;
    public double terceiro;


    public double finalGrade() {
        return primeiro + segundo + terceiro;
    }

    public double missPoints() {

                if (finalGrade() < 60.0) {
                    return 60.0 - finalGrade();
                } else {
                    return 0.0;

                }

    }



}
