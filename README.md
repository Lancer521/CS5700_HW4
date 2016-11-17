# CS5700_HW4



Justification of Design Decisions:
1.  At first, I thought I could split the algorithms into (1)find applicable cells, (2)apply method, and (3) update affected cells.
The problem that I found was that all three steps were unique to each algorithm, and that (2) and (3) had to be done for every
applicable cell.  So it's not a natural candidate for the Template pattern.  However, if I choose to involve some empirical studies,
I can have (1)start, (2)apply method, and (3) finish, where apply method involves all three of the steps I described initially.
It's not an exciting example of the Template pattern but it seemed to make the most sense.
