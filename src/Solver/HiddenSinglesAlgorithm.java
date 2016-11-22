package Solver;

import Puzzle.Puzzle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ty on 11/16/2016.
 * If the current cell has a possible value not found in the possible values of its row, column, or block,
 * set it as the value
 */
public class HiddenSinglesAlgorithm extends SudokuAlgorithm {

    @Override
    public void applyMethod(Puzzle puzzle, int currRow, int currCol) {
        List<Character> list;

        list = checkRowAndColumn(puzzle, currRow, currCol);
        if(list.size() == 1){
            puzzle.cells[currRow][currCol].setValue(list.get(0));
            return;
        }

        list = checkBlock(puzzle, currRow, currCol);
        if (list.size() == 1) {
            puzzle.cells[currRow][currCol].setValue(list.get(0));
            return;
        }
    }

    /**
     * Examine block of current cell to see if current cell contains hidden single
     *  @param puzzle  Puzzle to be examined
     * @param currRow Row index of current cell
     * @param currCol Column index of current cell
     */
    private List<Character> checkBlock(Puzzle puzzle, int currRow, int currCol) {
        //Find the top left square of the block to which this cell belongs
        int blockRow = -1;
        int blockCol = -1;
        for (int i = 1; i <= puzzle.blockSize; i++) {
            for (int j = 1; j <= puzzle.blockSize && blockCol == -1; j++) {
                if (currCol < j * puzzle.blockSize) {
                    blockCol = (j - 1) * puzzle.blockSize;
                    break;
                }
            }
            if(currRow < i * puzzle.blockSize){
                blockRow = (i - 1) * puzzle.blockSize;
                break;
            }
        }

        List<Character> list = new ArrayList<>(puzzle.cells[currRow][currCol].possibleValues);

        for (int i = blockRow; i < blockRow + puzzle.blockSize && !list.isEmpty(); i++) {
            for (int j = blockCol; j < blockCol + puzzle.blockSize && !list.isEmpty(); j++) {
                if (!(i== currRow && j == currCol) && !puzzle.cells[i][j].hasValue()) {
                    for (Iterator<Character> iterator = list.iterator(); iterator.hasNext(); ) {
                        char c = iterator.next();
                        if (puzzle.cells[i][j].possibleValues.contains(c)) {
                            iterator.remove();
                        }
                    }
                }
            }
        }
        return list;
    }

    /**
     * Examine row and column of current cell to see if current cell contains hidden single
     *
     * @param puzzle  Puzzle to be examined
     * @param currRow Row index of current cell
     * @param currCol Column index of current cell
     * @return true if the list size equals one after a column or row examination
     */
    @SuppressWarnings("all")
    private List<Character> checkRowAndColumn(Puzzle puzzle, int currRow, int currCol) {
        List<Character> list = new ArrayList<>(puzzle.cells[currRow][currCol].possibleValues);

        for (int col = 0; col < puzzle.gridSize && !list.isEmpty(); col++) {
            if (col != currCol && !puzzle.cells[currRow][col].hasValue()) {
                for (Iterator<Character> iterator = list.iterator(); iterator.hasNext(); ) {
                    char c = iterator.next();
                    if (puzzle.cells[currRow][col].possibleValues.contains(c)) {
                        iterator.remove();
                    }
                }
            }
        }

        if (list.size() == 1) return list;
        list = new ArrayList<>(puzzle.cells[currRow][currCol].possibleValues);

        for (int row = 0; row < puzzle.gridSize && !list.isEmpty(); row++) {
            if (row != currRow && !puzzle.cells[row][currCol].hasValue()) {
                for (Iterator<Character> iterator = list.iterator(); iterator.hasNext(); ) {
                    char c = iterator.next();
                    if (puzzle.cells[row][currCol].possibleValues.contains(c)) {
                        iterator.remove();
                    }
                }
            }
        }
        return list;
    }
}
