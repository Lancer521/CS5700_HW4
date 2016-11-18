package Tests;


import Puzzle.PuzzleIO;
import Puzzle.Puzzle;
import Solver.Solver;
import Solver.UpdateNotesAlgorithm;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testUpdateNotesNewPuzzle(){
        Puzzle puzzle = PuzzleIO.getPuzzle("src/SamplePuzzles/myPuzzle.txt");
        UpdateNotesAlgorithm algorithm = new UpdateNotesAlgorithm();
        algorithm.applyMethod(puzzle);
        List<Character> list = new ArrayList<>();
        list.add('2');
        list.add('7');
        list.add('8');
        list.add('9');
        Assert.assertTrue(puzzle != null && puzzle.cells[5][0].possibleValues.equals(list));
        list.clear();
        list.add('2');
        list.add('6');
        list.add('7');
        Assert.assertFalse(puzzle.cells[5][0].possibleValues.equals(list));
        Assert.assertTrue(puzzle.cells[5][7].possibleValues.equals(list));
        list.clear();
        list.add('2');
        list.add('5');
        list.add('7');
        list.add('8');
        Assert.assertFalse(puzzle.cells[5][7].possibleValues.equals(list));
        Assert.assertTrue(puzzle.cells[8][0].possibleValues.equals(list));
    }

}
