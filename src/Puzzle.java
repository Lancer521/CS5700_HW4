import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ty on 11/15/2016 at 4:39 PM.
 *
 */
public class Puzzle {

    public static final int UNTESTED = 0;
    public static final int SOLVABLE = 1;
    public static final int UNSOLVABLE = 2;
    public static final int BAD_PUZZLE = 3;
    public static final int MULTIPLE_SOLUTIONS = 4;

    public int gridSize;
    public List<Character> symbols;
    public int[][][] puzzle;
    public int result;
    public String outputFile;
    //TODO: consider storing solutions here

    public Puzzle(int size, List<Character> symbols){
        gridSize = size;
        this.symbols = symbols;
        puzzle = new int[size][size][size];
    }

}
