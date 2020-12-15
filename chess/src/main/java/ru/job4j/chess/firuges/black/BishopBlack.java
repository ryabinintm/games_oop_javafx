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
        return this.position;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int xLength = Math.abs(source.getX() - dest.getX());
        int yLength = Math.abs(source.getY() - dest.getY());
        return xLength == yLength;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        /* Position value   ---->   Destination value */
        int x = position.getX(),    xx = dest.getX();
        int y = position.getY(),    yy = dest.getY();
        /* Exactly equals? */
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(position, dest);
        }
        /* Direction */
        int dix = (x > xx) ? -1 : 1;
        int diy = (y > yy) ? -1 : 1;
        /* Filling Array of the Cells */
        var size = Math.abs(x - xx);
        Cell[] steps = new Cell[size];
        for (int index = 0; index < size; index++) {
            x += dix;
            y += diy;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}