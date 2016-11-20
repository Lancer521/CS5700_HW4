package Solver;

import Puzzle.Puzzle;

import java.util.Arrays;

/**
 * Created by Ty on 11/16/2016.
 *
 */
public class HiddenSinglesAlgorithm extends SudokuAlgorithm {

    @Override
    public void applyMethod(Puzzle puzzle, int currRow, int currCol) {
        int[] count = new int[puzzle.gridSize];
        Arrays.fill(count, 0);

/*        for(int i = 0; i < puzzle.gridSize; i++){
            for(int j = 0; j < puzzle.gridSize; j++){

            }
        }*/

        //Search all rows/cols/blocks
        //Set value for hidden singles
        //Remove from affected cells' possVals
    }
}
