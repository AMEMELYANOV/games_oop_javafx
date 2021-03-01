package ru.job4j.chess.firuges.black;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class BlackBishopTest {
    @Test
    public void positionTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Cell result = bishopBlack.position();
        assertThat(result, is(Cell.A1));
    }

    @Test
    public void copyTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        BishopBlack result = (BishopBlack) bishopBlack.copy(Cell.B2);
        assertThat(result.position(), is(Cell.B2));
    }

    @Test
    public void wayTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(expected));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void noWayTest() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.G4);
    }

    @Test
    public void diagonalTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean result = bishopBlack.isDiagonal(Cell.C1, Cell.G5);
        assertThat(result, is(true));
    }

    @Test
    public void notDiagonalTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean result = bishopBlack.isDiagonal(Cell.C1, Cell.F2);
        assertThat(result, is(false));
    }
}
