Features I have implemented in your extension:
  + Pockets and More Coloured Balls
  + Difficulty Level
  + Time and Score
  + Undo and Cheat
  
How to run the program:
- After launching the program by running gradle run, the pool table will be displayed, but without the balls. The user must choose one of the levels by clicking onto one of the easy, normal or hard buttons on the screen. After successfully choosing the level, the balls will be displayed on the pool table, and the user can start playing.

Note for undo feature:
- If the user click undo button more than the amount of the saved state recorded, there will be a message saying the user has reached the very initial state of the game in the terminal, there is no more previous state to retrieve.

Note for strategy:
  + BallStrategy class holds strategy logic for orange ball, yellow ball and red ball.
  + BlackStrategy class holds strategy logic for black ball and brown ball.
  + BlueStrategy class holds strategy logic for green ball, purple ball and blue ball.
  
Note for cheat feature:
- The user can press in keyboard these following letters to make the corresponding color balls dissapear from the screen:
    + Letter S for blue balls
    + Letter P for purple balls
    + Letter Y for yellow balls
    + Letter B for black balls
    + Letter R for red balls
    + Letter O for orange balls
    + Letter H for brown balls


Design pattern

- Factory pattern classes:
  + BallReader class
  + BallReaderFactory class
  + PocketReader class
  + PocketReaderFactory class
  + Reader interface
  + ReaderFactory interface
  + TableReader class
  + TableReaderFactory class

- Builder pattern classes:
  + Ball class
  + BallBuilder interface
  + BallDirector class
  + Pocket class
  + PocketBuilder interface
  + PocketDirector class
  + PoolBallBuilder class
  + PoolPocketBuilder class
  
- Strategy pattern classes:
  + BallStrategy class
  + BlackStrategy class
  + BlueStrategy class
  + PocketStrategy abstract class
  
- Memento pattern classes:
  + Caretaker class
  + Memento class
  + GameManager class as originator

- Prototype pattern classes
  + BallPrototype abstract class as protype participant
  + Ball class as concrete prototype participant
  
- Observer pattern classes
  + GameManagerObserver interface
  + Subject interface
  + GameManager class as concrete subject
  + Clock class and Score class as concrete observers


