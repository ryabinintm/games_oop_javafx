package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

   @Test
    public void whenBishopBlackPosition() {
        BishopBlack elephant = new BishopBlack(Cell.C1);
        Cell result = elephant.position();
        assertThat(result, is(Cell.C1));
    }

    @Test
    public void whenBishopBlackCopy() {
        Figure firstElephant = new BishopBlack(Cell.C1);
        Figure lastElefant = firstElephant.copy(Cell.E3);
        Cell result = lastElefant.position();
        assertThat(result, is(Cell.E3));
    }

    @Test
    public void whenBishopBlackWay() throws ImpossibleMoveException {
        BishopBlack elephant = new BishopBlack(Cell.H1);
        Cell[] cells = elephant.way(Cell.E4);
        Cell[] result = {
                Cell.G2,
                Cell.F3,
                Cell.E4
        };
        assertThat(cells, is(result));
    }

    @Test
    public void whenBishopBlackIsDiagonal() {
        Cell start = Cell.C1, finish = Cell.H8;
        BishopBlack elephant = new BishopBlack(start);
        boolean result = elephant.isDiagonal(start, finish);
        assertThat(result, is(false));
    }

    @Test
    public  void whenLogicMove()
            throws ImpossibleMoveException, OccupiedCellException {
        Figure[] figures = {
                new BishopBlack(Cell.A1),
                new BishopBlack(Cell.B2),
                new BishopBlack(Cell.C3),
        };
        Logic logic = new Logic();
        for (Figure fig : figures) {
            logic.add(fig);
        }
        /*Нет понимания, что дальше делать */
        /*logic.move(Cell.E1, Cell.D2);
        assertThat(rsl, is(false));*/
    }
}