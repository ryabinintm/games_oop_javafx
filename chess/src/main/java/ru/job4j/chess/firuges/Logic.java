package ru.job4j.chess.firuges;

import ru.job4j.chess.firuges.black.ImpossibleMoveException;
import ru.job4j.chess.firuges.white.OccupiedCellException;

import java.util.Arrays;

public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(dest);
        free(steps);
        figures[index] = figures[index].copy(dest);
    }

    private boolean free(Cell[] steps) throws OccupiedCellException {
        for (Figure fig : figures) {
            if (fig != null) {
                for(Cell cell : steps) {
                    if (fig.position().equals(cell)) {
                        throw new OccupiedCellException();
                    }
                }
            }
        }
        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }
}