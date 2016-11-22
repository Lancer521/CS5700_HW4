package Solver;

import Puzzle.Puzzle;
import Puzzle.Cell;

/**
 * Created by Ty on 11/16/2016.
 * 1) If current cell has a single possible value, set it as the value
 * 2) Remove that value from the other cells' possible values
 */
public class SinglesAlgorithm extends SudokuAlgorithm {

    @Override
    public void applyMethod(Puzzle puzzle, int currRow, int currCol) {

        Cell currCell = puzzle.cells[currRow][currCol];
        if (currCell.hasValue()) {
            return;
        }
        if(currCell.possibleValues.size() == 1){
            currCell.setValue(currCell.possibleValues.get(0));
            updateNotes(currRow, currCol, puzzle);
        }
    }

    private void updateNotes(int rowIndex, int colIndex, Puzzle puzzle) {
        updatePossibleValuesInRow(rowIndex, puzzle);
        updatePossibleValuesInColumn(colIndex, puzzle);

        //Only pass the indices to the top-left cell in the affected block
        for (int i = 1; i <= puzzle.blockSize; i++) {
            for (int j = 1; j <= puzzle.blockSize; j++) {
                if (rowIndex < i * puzzle.blockSize && colIndex < j * puzzle.blockSize) {
                    updatePossibleValuesInBlock((i - 1) * puzzle.blockSize, (j - 1) * puzzle.blockSize, puzzle);
                }
            }
        }
    }
}
