package Tests;


import Puzzle.PuzzleIO;
import Puzzle.Puzzle;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ty on 11/17/2016.
 *
 */
public class TestSuite {

    @Test
    public void testPuzzleIOGetInput4by4(){
        Puzzle puzzle = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-4x4-0001.txt");
        Assert.assertTrue(puzzle != null && puzzle.cells[2][1].getValue() == '1');
    }

    @Test
    public void testPuzzleIOInOutIn(){
        Puzzle puzzle = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-4x4-0001.txt");
        PuzzleIO.outputPuzzle("src/test.txt", puzzle);
        Puzzle newPuzzle = PuzzleIO.getPuzzle("src/test.txt");
        Assert.assertTrue(puzzle != null && puzzle.equals(newPuzzle));
    }

}
