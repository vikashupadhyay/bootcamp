package volume;

import exceptions.InvalidComparisonException;

public class Volume {
    private final UnitsOfVolume unit;
    private final double value;

    public Volume(UnitsOfVolume unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public boolean compare(Object liquidTwo) throws InvalidComparisonException {
        if(!(liquidTwo instanceof Volume)) throw new InvalidComparisonException();
        Volume otherVolume = (Volume) liquidTwo;
        return unit.volume()*value == otherVolume.unit.volume()* otherVolume.value;
    }

    public Volume add(Volume otherVolume) {
        double addedVolumeInLitre = value*unit.volume()+otherVolume.value*otherVolume.unit.volume();
        double addedVolumeInLitreRoundOff = (Math.round(addedVolumeInLitre*100.0))/100.0;
        return new Volume(UnitsOfVolume.LITRE,addedVolumeInLitreRoundOff);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volume volume = (Volume) o;
        return Double.compare(volume.value, value) == 0 && unit == volume.unit;

    }
}
