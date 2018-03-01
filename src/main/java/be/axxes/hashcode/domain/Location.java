package be.axxes.hashcode.domain;

public class Location {

    int row;
    int column;


    public Location(String row, String column) {
        this.row = Integer.parseInt(row);
        this.column = Integer.parseInt(column);
    }

    public Location(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Location{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }


    public int calculateDistance(Location other) {
        return Math.abs(other.getColumn() - this.getColumn()) + Math.abs(other.getRow() - this.getRow());
    }
}
