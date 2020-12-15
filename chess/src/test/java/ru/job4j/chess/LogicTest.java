package ru.job4j.chess;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Logic;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.OccupiedCellException;
import ru.job4j.chess.firuges.black.ImpossibleMoveException;
import ru.job4j.chess.firuges.FigureNotFoundException;

public class LogicTest {

    @Test(expected = FigureNotFoundException.class)
    public void whenMoveFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.move(Cell.D2, Cell.E3);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenMoveOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack biBlackFirst = new BishopBlack(Cell.C1);
        BishopBlack biBlackSecond = new BishopBlack(Cell.A3);
        logic.add(biBlackFirst);
        logic.add(biBlackSecond);
        logic.move(Cell.C1, Cell.A3);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.B1);
    }
}