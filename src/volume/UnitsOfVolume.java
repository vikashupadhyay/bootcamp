package volume;

public enum UnitsOfVolume {
    LITRE(1.0), //Base unit is litre...
    GALLON(3.78);

    private Double volume;


    UnitsOfVolume(Double volume) {
        this.volume = volume;
    }
    public Double volume() {
        return volume;
    }
}
