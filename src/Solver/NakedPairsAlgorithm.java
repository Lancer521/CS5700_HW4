package Solver;

import Puzzle.Puzzle;

import java.util.List;

/**
 * Created by Ty on 11/16/2016.
 * If two cells in a row, column, or block have exactly 2 possible values, and they are the same 2 values for both cells,
 * then remove those values from anywhere else in that row or column, and the block.
 */
public class NakedPairsAlgorithm extends SudokuAlgorithm {

    @Override
    public void applyMethod(Puzzle puzzle, int currRow, int currCol) {

        if (puzzle.cells[currRow][currCol].possibleValues.size() != 2) return;
        List<Character> list = puzzle.cells[currRow][currCol].possibleValues;

        //Check row and column
        for (int index = 0; index < puzzle.gridSize; index++) {
            if (index != currCol && puzzle.cells[currRow][index].possibleValues.equals(list)) {
                removePairValuesFromRow(puzzle, currRow, list);
                break;
            }
            if (index != currRow && puzzle.cells[index][currCol].possibleValues.equals(list)) {
                removePairValuesFromColumn(puzzle, currCol, list);
                break;
            }
        }

        //Check block
        int blockRow = getBlockIndex(puzzle, currRow);
        int blockCol = getBlockIndex(puzzle, currCol);
        for (int row = blockRow; row < blockRow + puzzle.blockSize && row < puzzle.gridSize; row++) {
            for (int col = blockCol; col < blockCol + puzzle.blockSize && col < puzzle.gridSize; col++) {
                if (!(row == currRow && col == currCol) && puzzle.cells[row][col].possibleValues.equals(list)) {
                    removePairValuesFromBlock(puzzle, currRow, currCol, list);
                }
            }
        }
    }

    private void removePairValuesFromRow(Puzzle puzzle, int currRow, List<Character> list) {
        for (int i = 0; i < puzzle.gridSize; i++) {
            if (!puzzle.cells[currRow][i].possibleValues.equals(list)) {
                puzzle.cells[currRow][i].possibleValues.remove(list.get(0));
                puzzle.cells[currRow][i].possibleValues.remove(list.get(1));
            }
        }
    }

    private void removePairValuesFromColumn(Puzzle puzzle, int currCol, List<Character> list) {
        for (int i = 0; i < puzzle.gridSize; i++) {
            if (!puzzle.cells[i][currCol].possibleValues.equals(list)) {
                puzzle.cells[i][currCol].possibleValues.remove(list.get(0));
                puzzle.cells[i][currCol].possibleValues.remove(list.get(1));
            }
        }
    }

    private void removePairValuesFromBlock(Puzzle puzzle, int currRow, int currCol, List<Character> list) {
        int blockRow = getBlockIndex(puzzle, currRow);
        int blockCol = getBlockIndex(puzzle, currCol);
        for(int row = blockRow; row < blockRow + puzzle.blockSize && row < puzzle.gridSize; row++){
            for(int col = blockCol; col < blockCol + puzzle.blockSize && col < puzzle.gridSize; col++){
                if(!puzzle.cells[row][col].possibleValues.equals(list)){
                    puzzle.cells[row][col].possibleValues.remove(list.get(0));
                    puzzle.cells[row][col].possibleValues.remove(list.get(1));
                }
            }
        }
    }
}
