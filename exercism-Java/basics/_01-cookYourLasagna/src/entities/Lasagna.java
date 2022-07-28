package entities;


public class Lasagna {
    private int minutes;

    public Lasagna() {
    }

    public void expectedMinutesInOven() {
        this.minutes = 40;
    }

    public int remainingMinutesInOven(int remain) {
        return minutes - remain;
    }

    public int preparationTimeInMinutes(int layers) {
        return layers * 2;
    }

    public int totalTimeInMinutes(int layersAdded, int minutesNow) {

        return preparationTimeInMinutes(layersAdded) + minutesNow;
    }
}
