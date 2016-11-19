package Solver;

import java.util.List;
import Puzzle.Puzzle;

/**
 * Created by Ty on 11/16/2016.
 *
 */
public class Solver {

    List<SudokuAlgorithm> algorithms;

    public Puzzle solve(Puzzle puzzle){

        // Make deep copy of Puzzle so as to preserve the original state
//        Puzzle puzzleToSolve = new Puzzle(puzzle);

        UpdateNotesAlgorithm update = new UpdateNotesAlgorithm();
        update.applyMethod(puzzle);
        /*
        TODO: Iteratively call the different algorithms in the List
         */

        return null;
    }

    private void addAllPossibleValues(Puzzle puzzle){

    }
}
