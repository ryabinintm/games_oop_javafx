package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class ImpossibleMoveException extends Throwable {

    public ImpossibleMoveException(Cell position, Cell dest) {
        System.out.format("Could not move by diagonal from %s to %s", position, dest);
    }
}
