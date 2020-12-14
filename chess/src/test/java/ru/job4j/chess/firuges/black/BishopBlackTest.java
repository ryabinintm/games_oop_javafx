package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void whenBishopBlackPosition() {
        BishopBlack biBlack = new BishopBlack(Cell.C1);
        Cell result = biBlack.position();
        assertThat(result, is(Cell.C1));
    }

    @Test
    public void whenBishopBlackCopy() {
        Figure biBlack = new BishopBlack(Cell.C1);
        Figure yetBiBlack = biBlack.copy(Cell.E3);
        Cell result = yetBiBlack.position();
        assertThat(result, is(Cell.E3));
    }

    @Test
    public void whenBishopBlackWayH1E4() throws ImpossibleMoveException {
        BishopBlack biBlack = new BishopBlack(Cell.H1);
        Cell[] cells = biBlack.way(Cell.E4);
        Cell[] result = {
                Cell.G2,
                Cell.F3,
                Cell.E4
        };
        assertThat(cells, is(result));
    }

    @Test
    public void whenBishopBlackWayF8B4() throws ImpossibleMoveException {
        BishopBlack biBlack = new BishopBlack(Cell.F8);
        Cell[] cells = biBlack.way(Cell.B4);
        Cell[] result = {
                Cell.E7,
                Cell.D6,
                Cell.C5,
                Cell.B4
        };
        assertThat(cells, is(result));
    }
}