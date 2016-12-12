# CS5700_HW4 / CS5700_HW5



Justification of Design Decisions:
I found that every single algorithm was iterating over the entire puzzle (among more complex/specific iterating), so
I decided to use the template pattern to let a template method iterate over each cell in the puzzle.  This meant writing
each algorithm so that it was only concerned with one cell at a time, allowing the template method to make sure each
algorithm was applied across the board (rather than each algorithm having to do it on its own).



If you run the program such that it solves all 30 of the test puzzles, it will save them to src/Output/[puzzlename].txt



Things learned in my revision:
- Using and traversing Strings instead of Lists for the 'possibleValues' property of each cell actually MORE THAN DOUBLED the time required to solve all 30
puzzles.  Unfortunately it took a few hours of refactoring to realize that.  Fortunately though, IntelliJ quickly reverted these uncommitted changes for me
(yay version control).
- Writing test cases actually helped me identify a few methods that weren't properly named, ie. the 'getBlockIndex' method implies that it is a simple
getter to a property, however the method actually contains logic that figures out the top-left index of that block containing the given cell.  It is much
more appropriate to call it 'calculateBlockIndex'