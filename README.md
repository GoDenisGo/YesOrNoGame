# YesOrNoGame
A simple terminal game where the user answers questions in terminal to follow a pre-made storyline about whether they should revise or not.
This project was built as a part of my 1st Year Java programming coursework. The 2nd year project will include a rewrite of this project into Dartlang and feature a
working GUI (to be continued as of 18/11/2022).

### Installation:
Simply clone the entire folder to a local direcotry. Some IntelliJ files are included, but it is the Java code that is required.

### Usage:
You may run the Userinteractions file in your IDE after building the project. This file holds the main class.
The user enters "1" to say "Yes" and "2" to say "No". Entering "9" exits the program prematurely.

The program loads an entire CSV file into a buffered reader object; the CSV containing all the data required to construct the storyline.
The program asks the user for an input. After each "Yes" or "No" decision, the Server class does a linear search of the file and loads the next response into a Node
object (from the Node class). The Node represents the current state or position of the storyline. The Node holds an important value called "description" which is what
the user sees as an output. This is how the user is guided to decide another input to the program.

### Future considerations:
- The program uses a flat-file structure. As part of my 2nd year project, it will feature a working database, likely to be in PSQL. A database may require an improved
architecture of the system (how each class behaves and how data is represented in storage).
- A weakness of CSV is that the meaning of each column is not well-defined. A databse would fix this by providing a "name" for everycolumn in the table.
- The program could become more robust by checking that the data retrieved from the database is safe. This may be incorporated into the 2nd year project.
- The code could be modularised; many if statements are nested within a single function. The code is readable but some abstraction may improve future maintainability.
- Each NodeID from the data.csv file (the first column) could be implicitly calculated, as each ID roughly corresponds to the iterations of linear searches.
- Scalability; the program doesn't include a native way to change the storyline. This could be fixed by letting the user input their own storyline, though it is unlikely to be added to the 2nd Year project (not part of the scope of the coursework).
