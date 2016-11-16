import java.util.List;

/**
 * Created by Ty on 11/16/2016.
 * A Cell is the basic unit in a Sudoku puzzle.  It knows its value and/or possible values.
 */
public class Cell {

    public char value;
    public List<Character> possibleValues;
}
