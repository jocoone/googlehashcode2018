package be.axxes.hashcode.domain;

public class Location {

    int row;
    int column;


    public Location(String row, String column) {
        this.row = Integer.parseInt(row);
        this.column = Integer.parseInt(column);
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
}
