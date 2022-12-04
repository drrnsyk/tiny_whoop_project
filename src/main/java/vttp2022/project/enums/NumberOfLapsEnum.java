package vttp2022.project.enums;

public enum NumberOfLapsEnum {
    THREE(3), FIVE(5);

    private final int laps;

    public int getLaps() {
        return laps;
    }

    NumberOfLapsEnum(int laps) {
        this.laps = laps;
    }

}




