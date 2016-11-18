package Solver;

import Puzzle.Puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ty on 11/16/2016.
 * For each "empty" cell, searches through its row, column, and block, and updates its list of possible values
 */
public class UpdateNotesAlgorithm extends SudokuAlgorithm {

    @Override
    public void applyMethod(Puzzle puzzle) {
        for(int colIndex = 0; colIndex < puzzle.gridSize; colIndex++){
            for(int rowIndex = 0; rowIndex < puzzle.gridSize; rowIndex++){
                updatePossibleValuesInColumn(colIndex, puzzle);
                updatePossibleValuesInRow(rowIndex, puzzle);
                updatePossibleValuesInBlock(colIndex, rowIndex, puzzle);
            }
        }
        //Remove values from possVals
    }

    private void updatePossibleValuesInColumn(int colIndex, Puzzle puzzle) {
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < puzzle.gridSize; i++){
            if(puzzle.cells[colIndex][i].hasValue()){
                list.add(puzzle.cells[colIndex][i].getValue());
            }
        }
        for(int i = 0; i < puzzle.gridSize; i++){
            for(char c : list){
                if(puzzle.cells[colIndex][i].possibleValues.contains(c)){
                    puzzle.cells[colIndex][i].possibleValues.remove(c);
                }
            }
        }
    }

    private void updatePossibleValuesInRow(int rowIndex, Puzzle puzzle) {
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < puzzle.gridSize; i++){
            if(puzzle.cells[i][rowIndex].hasValue()){
                list.add(puzzle.cells[i][rowIndex].getValue());
            }
        }
        for(int i = 0; i < puzzle.gridSize; i++){
            for(char c : list){
                if(puzzle.cells[i][rowIndex].possibleValues.contains(c)){
                    puzzle.cells[i][rowIndex].possibleValues.remove(c);
                }
            }
        }
    }

    private void updatePossibleValuesInBlock(int colIndex, int rowIndex, Puzzle puzzle) {
        int size = ((Double)Math.sqrt(puzzle.gridSize)).intValue();
        List<Character> list = new ArrayList<>();

    }

}
