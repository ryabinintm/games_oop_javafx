package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {

    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = (position.getX() > dest.getX()) ? -1 : 1;
        int deltaY = (position.getY() > dest.getY()) ? -1 : 1;
        for (int index = 0; index < size; index++) {
            int x = index * deltaX + position.getX() + deltaX;
            int y = index * deltaY + position.getY() + deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int xLength = Math.abs(source.getX() - dest.getX());
        int yLength = Math.abs(source.getY() - dest.getY());
        return (xLength == yLength) ? true : false;
    }
}
