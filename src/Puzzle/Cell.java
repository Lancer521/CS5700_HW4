package Puzzle;

import java.util.List;

/**
 * Created by Ty on 11/16/2016.
 * A Puzzle.Cell is the basic unit in a Sudoku puzzle.  It knows its value and/or possible values.
 */
public class Cell {

    private char value;
    public List<Character> possibleValues;

    public Cell(){

    }

    public void setValue(char val){
        value = val;
        if(hasValue()){
            possibleValues.clear();
        }
    }

    public char getValue(){
        return value;
    }

    public boolean hasValue(){
        return value != '-';
    }
}
