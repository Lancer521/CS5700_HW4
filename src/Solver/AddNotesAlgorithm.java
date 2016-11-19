package Solver;

import Puzzle.Puzzle;

/**
 * Created by Ty on 11/16/2016.
 * Add notes to every "empty" cell in the puzzle
 * Technically, adding notes means removing known row/column/block values from an empty cell's possible values list
 */
public class AddNotesAlgorithm extends SudokuAlgorithm {

    @Override
    public void applyMethod(Puzzle puzzle) {
        int blockSize = ((Double) Math.sqrt(puzzle.gridSize)).intValue();

        for (int i = 0; i < puzzle.gridSize; i++) {
//            if (!puzzle.cells[i][0].hasValue()) {
                updatePossibleValuesInRow(i, puzzle);
//            }
//            if(!puzzle.cells[0][i].hasValue()){
                updatePossibleValuesInColumn(i, puzzle);
//            }
        }
        for(int i = 0; i < puzzle.gridSize; i += blockSize){
            for(int j = 0; j < puzzle.gridSize; j += blockSize){
                updatePossibleValuesInBlock(i, j, puzzle, blockSize);
            }
        }
    }
}
