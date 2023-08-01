package main.java;

import java.util.Objects;
import main.java.piece.CoordinateShift;
public class Coordinates {


    public Coordinates(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }
    public final File file;
    public final Integer rank;

    public Coordinates shift(CoordinateShift shift){
        return new Coordinates(File.values()[this.file.ordinal()+shift.fileShift], this.rank+shift.rankShift);
    }

    public boolean canShift(CoordinateShift shift){
        int f=file.ordinal()+shift.fileShift;
        int r=rank+shift.rankShift;

        if((f<0)||(f>7))return false;
        if((r<1)||(r>8))return false;

        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return file == that.file && Objects.equals(rank, that.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }
}
