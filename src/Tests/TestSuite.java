package Tests;


import Puzzle.PuzzleIO;
import Puzzle.Puzzle;
import Solver.SinglesAlgorithm;
import Solver.UpdateNotesAlgorithm;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ty on 11/17/2016.
 */
public class TestSuite {

    @Test
    public void testPuzzleIOGetInput4by4() {
        Puzzle puzzle = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-4x4-0001.txt");
        Assert.assertTrue(puzzle != null && puzzle.cells[2][1].getValue() == '1');
    }

    @Test
    public void testPuzzleIOInOutIn() {
        Puzzle puzzle = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-4x4-0001.txt");
        PuzzleIO.outputPuzzle("src/test.txt", puzzle);
        Puzzle newPuzzle = PuzzleIO.getPuzzle("src/test.txt");
        Assert.assertTrue(puzzle != null && puzzle.equals(newPuzzle));
    }

    @Test
    public void testUpdateNotesNewPuzzle() {
        Puzzle puzzle = PuzzleIO.getPuzzle("src/SamplePuzzles/myPuzzle-9x9.txt");
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

    @Test
    public void testSinglesAlgorithm4x4() {
        Puzzle puzzle = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-4x4-0001.txt");
        printToConsole(puzzle);
        UpdateNotesAlgorithm notes = new UpdateNotesAlgorithm();
        SinglesAlgorithm singles = new SinglesAlgorithm();
        notes.applyMethod(puzzle);
        singles.applyMethod(puzzle);
        printToConsole(puzzle);
        Assert.assertTrue(puzzle != null);
        Assert.assertTrue(puzzle.cells[0][1].getValue() == '4');
        Assert.assertTrue(puzzle.cells[1][2].getValue() == '2');
        Assert.assertTrue(puzzle.cells[2][3].getValue() == '2');
        Assert.assertTrue(puzzle.cells[3][0].getValue() == '4');
    }

    @Test
    public void testSinglesAlgorithm9x9() {
        Puzzle puzzle = PuzzleIO.getPuzzle("src/SamplePuzzles/Puzzle-9x9-0001.txt");
        printToConsole(puzzle);
        UpdateNotesAlgorithm notes = new UpdateNotesAlgorithm();
        SinglesAlgorithm singles = new SinglesAlgorithm();
        notes.applyMethod(puzzle);
        singles.applyMethod(puzzle);
        printToConsole(puzzle);
        Assert.assertTrue(puzzle != null);

    }

    private void printToConsole(Puzzle puzzle) {
        System.out.println(puzzle.gridSize);
        for (Character c : puzzle.symbols) {
            System.out.print(c + " ");
        }
        for (int i = 0; i < puzzle.gridSize; i++) {
            System.out.println();
            for (int j = 0; j < puzzle.gridSize; j++) {
                System.out.print(puzzle.cells[i][j].getValue() + " ");
            }
        }
        System.out.print("\n\n");
    }
}