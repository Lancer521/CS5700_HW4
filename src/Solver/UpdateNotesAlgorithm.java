package Solver;

import Puzzle.Puzzle;

/**
 * Created by Ty on 11/16/2016.
 * For each "empty" cell, searches through its row, column, and block, and updates its list of possible values
 * There is almost certainly room for optimization here
 */
public class UpdateNotesAlgorithm extends SudokuAlgorithm {

    @Override
    public void applyMethod(Puzzle puzzle) {
        int blockSize = ((Double) Math.sqrt(puzzle.gridSize)).intValue();

        for (int i = 0; i < puzzle.gridSize; i++) {
            if (!puzzle.cells[i][0].hasValue()) {
                updatePossibleValuesInRow(i, puzzle);
            }
            if(!puzzle.cells[0][i].hasValue()){
                updatePossibleValuesInColumn(i, puzzle);
            }
        }
        for(int i = 0; i < puzzle.gridSize; i += blockSize){
            for(int j = 0; j < puzzle.gridSize; j += blockSize){
                updatePossibleValuesInBlock(i, j, puzzle, blockSize);
            }
        }
    }
}
