package Solver;

import Puzzle.Puzzle;

import java.util.List;

/**
 * Created by Ty on 11/16/2016.
 *
 */
public class NakedPairsAlgorithm extends SudokuAlgorithm {

    @Override
    public void applyMethod(Puzzle puzzle, int currRow, int currCol) {

        if(puzzle.cells[currRow][currCol].possibleValues.size() != 2) return;
        List<Character> list = puzzle.cells[currRow][currCol].possibleValues;

        //Check row and column
        for(int index = 0; index < puzzle.gridSize; index++){
            if(puzzle.cells[currRow][index].possibleValues.equals(list)){
                //TODO: remove either value from any other cell in the row
                return;
            }
            if(puzzle.cells[index][currCol].possibleValues.equals(list)){
                //TODO: remove either value from any other cell in the column
                return;
            }
        }

        //Check block
        int blockRow = getBlockIndex(puzzle, currRow);
        int blockCol = getBlockIndex(puzzle, currCol);
        for(int row = blockRow; row < blockRow + puzzle.blockSize; row++){
            for(int col = blockCol; col < blockCol + puzzle.blockSize; row++){
                if(row != currRow || col != currCol){
                    if(puzzle.cells[row][col].possibleValues.equals(list)){
                        //TODO: remove either value from any other cell in the block
                    }
                }
            }
        }
    }
}
