### Traffic Light App

__Task:__

- read input how much time gone from the day start from the command line,
parse to Integer, print to the command line traffic light color (GREEN, YELLOW, RED - with different colors)
  
- traffic lights cycle: 60 seconds:
    + 0 <= light < 35 - green
    + 35 <= light < 40 - yellow
    + 40 <= light < 55 - red
    + 55 <= light < 60 - yellow

- input limitations:
    + minimal value is 0
    + maximal value is 24*60*60 - 1 = 86399

- if over then 86399 should print "The day is over"

- if input value is incorrect should print "Only 1 non-negative integer is allowed as passed parameter"

__Extra arguments:__
- App will count the traffic lights result for the current time if call "java Main -now"