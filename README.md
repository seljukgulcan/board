Board Package v2.0
=====

Overview
--------

  Note: I'm currently coding version2.0 of this package. There will be huge changes and new features such as hexagonal and triangular grids, search functions, state maps and so on. If you would like to improve this repository, wait a bit for version 2 or contact me to help me coding. Thanks.

  This project is started to create java classes useful for any kind of board games. Package contains Board, Tile and Area classes and Placeable interface. For more information, look at UML page in wiki of the project.

This package contains these files :
 - Board.java
 - Tile.java
 - Area.java
 - Placeable.java
 
Feaures
--------

 - Implements square based grids as 2D array.
 - Every piece in the grid is considered as a Tile object.
 - Tile objects hold 3 main data:
  - States: integer information about the states of the tile.
  - Properties: string information.
  - Placeable objects: Any object implements Placeable interface.

Progress
--------

 - Github repository and wiki for a development platform. (OK)
 - UML class diagram. (Need changes)
 - Coding java classes according to UML diagram. (In progress)
 - Testing and debugging.
 - Creating some board games to test this package.
 - Modifying the projects according to last step.
 - Documentation.

Projects Using Board Package (Uses board package v1.0)
--------

  These are the projects created to show what can be done with Board package.

 - [Minesweeper](https://github.com/Shathra/mine-sweeper)

License
--------

![alt tag](http://i.creativecommons.org/l/by/3.0/88x31.png)

This work is licensed under a [Creative Commons Attribution 3.0](http://creativecommons.org/licenses/by/3.0/) Unported License.
