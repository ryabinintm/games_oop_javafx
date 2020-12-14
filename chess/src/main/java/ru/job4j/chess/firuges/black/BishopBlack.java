package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;


public class BishopBlack implements Figure {

    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell dest) {
        /* Position value   ---->   Destination value */
        int x = position.getX(),    xx = dest.getX();
        int y = position.getY(),    yy = dest.getY();
        /* Absolute values are equals */
        int dx = Math.abs(x - xx),  dy = Math.abs(y - yy);
        /* Exactly equals? */
        if (dx != dy) {
            String format = "Could not move by diagonal from %s to %s";
            throw new ImpossibleMoveException(
                    String.format(format, position, dest)
            );
        }
        /* Direction */
        int dix = (x > xx) ? -1 : 1;
        int diy = (y > yy) ? -1 : 1;
        /* Filling Array of the Cells */
        Cell[] steps = new Cell[dx];
        for (int index = 0; index < dx; index++) {
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