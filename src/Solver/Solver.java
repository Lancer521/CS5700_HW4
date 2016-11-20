package Solver;

import java.util.ArrayList;
import java.util.List;
import Puzzle.Puzzle;

/**
 * Created by Ty on 11/16/2016.
 *
 */
public class Solver {

    List<SudokuAlgorithm> algorithms;

    public int solve(Puzzle puzzle){

        puzzle.printToConsole();
        if(!isValidPuzzle(puzzle)) return Puzzle.BAD_PUZZLE;

        new AddNotesAlgorithm().applyMethod(puzzle);

        initializeAlgorithmsList();

        while(!isSolved(puzzle)) {
            for (SudokuAlgorithm algorithm : algorithms) {
                algorithm.solve(puzzle);
            }
        }

        puzzle.printToConsole();

        return -1;
    }

    private void initializeAlgorithmsList(){
        algorithms = new ArrayList<>();
        algorithms.add(new SinglesAlgorithm());
//        algorithms.add(new HiddenSinglesAlgorithm());
//        algorithms.add(new LockedCandidateRowColAlgorithm());
//        algorithms.add(new LockedCandidateBlockAlgorithm());
//        algorithms.add(new NakedPairsAlgorithm());
    }

    private boolean isSolved(Puzzle puzzle){
        return isFull(puzzle) && isLegalState(puzzle);
    }

    private boolean isFull(Puzzle puzzle){
        for(int i = 0; i < puzzle.gridSize; i++){
            for(int j = 0; j < puzzle.gridSize; j++){
                if(!puzzle.cells[i][j].hasValue()){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * A puzzle is not valid if it:
     *  a) is not formatted correctly
     *  b) doesn't contain the provided symbols
     *  c) doesn't have a solution
     *  d) has more than one solution
     * Parts a) and b) depend on the state of the puzzle as it is received, and can be immediately checked for validity
     * Part c) can sometimes be discovered if the puzzle is in an illegal initial state
     * Parts c) and d) are discovered through the Solver, and therefore cannot be immediately checked for validity
     * @param puzzle Puzzle to be validated
     * @return true if parts a, b, and c are satisfied, else false
     */
    public boolean isValidPuzzle(Puzzle puzzle){
        return isFormattedCorrectly(puzzle) && hasCorrectSymbols(puzzle) && isLegalState(puzzle);
    }

    /**
     * Check for correct dimensions
     * Acceptable dimensions are 4x4, 9x9, 16x16, 25x25, and 36x36
     * @param puzzle Puzzle to be validated
     * @return true if dimensions are correct
     */
    private boolean isFormattedCorrectly(Puzzle puzzle){
        return puzzle.gridSize == 4 || puzzle.gridSize == 9 || puzzle.gridSize == 16 || puzzle.gridSize == 25 || puzzle.gridSize == 36;
    }

    /**
     * Check whether the symbol in each set cell value is in the provided list of symbols
     * @param puzzle Puzzle to be validated
     * @return true if all set cell values are in the provided list of symbols
     */
    public boolean hasCorrectSymbols(Puzzle puzzle){
        for(int i = 0; i < puzzle.gridSize; i++){
            for(int j = 0; j < puzzle.gridSize; j++){
                if(puzzle.cells[i][j].hasValue() && !puzzle.symbols.contains(puzzle.cells[i][j].getValue())){
                    return false;
                }
            }
        }
        return true;
    }

    @SuppressWarnings("all")
    public boolean isLegalState(Puzzle puzzle){
        List<Character> rowList = new ArrayList<>();
        List<Character> colList = new ArrayList<>();
        for(int i = 0; i < puzzle.gridSize; i++){
            for(int j = 0; j < puzzle.gridSize; j++) {
                if (puzzle.cells[i][j].hasValue()) {
                    char val = puzzle.cells[i][j].getValue();
                    if (rowList.contains(val)) {
                        return false;
                    }
                    rowList.add(val);
                }
                if (puzzle.cells[j][i].hasValue()) {
                    char val = puzzle.cells[j][i].getValue();
                    if (colList.contains(val)) {
                        return false;
                    }
                    colList.add(val);
                }
            }
            rowList.clear();
            colList.clear();
        }

        List<Character> blockList = new ArrayList<>();
        int blockSize = ((Double) Math.sqrt(puzzle.gridSize)).intValue();
        //Iterate to each block
        for (int i = 0; i < puzzle.gridSize; i += blockSize) {
            for (int j = 0; j < puzzle.gridSize; j += blockSize) {
                //Iterate cells within each block
                for(int rowIndex = i; rowIndex < i + blockSize && rowIndex < puzzle.gridSize; rowIndex++){
                    for(int colIndex = j; colIndex < j + blockSize && rowIndex < puzzle.gridSize; colIndex++){
                        if (puzzle.cells[rowIndex][colIndex].hasValue()) {
                            char val = puzzle.cells[rowIndex][colIndex].getValue();
                            if (blockList.contains(val)) {
                                return false;
                            }
                            blockList.add(val);
                        }
                    }
                }
                blockList.clear();
            }
        }
        return true;
    }
}
