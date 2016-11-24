# CS5700_HW4



Justification of Design Decisions:
I found that every single algorithm was iterating over the entire puzzle (among more complex/specific iterating), so
I decided to use the template pattern to let a template method iterate over each cell in the puzzle.  This meant writing
each algorithm so that it was only concerned with one cell at a time, allowing the template method to make sure each
algorithm was applied across the board (rather than each algorithm having to do it on its own).



If you run the program such that it solves all 30 of the test puzzles, it will save them to src/Output/[puzzlename].txt