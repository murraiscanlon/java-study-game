# Final Project - Team 30 - Javenture Game

*Team Members*

Diane Hoffstetter | Jen Macklin | Murrai Scanlon

### Overview

Tired of studying for the Java exam? Are you interested in an alternative method for learning foundational knowledge of the Java programming language? Look no further than Javenture, a role playing game designed to test the player's knowledge of Java. 

### Description
:european_castle:  :moneybag:  

Javenture is an adventure game where a player traverses a castle, collecting treasure in order to free a great wizard. Lurking in the castle are Java monsters who hold the key to freeing the wizard. The player collects treasure only if they correctly answer a question about Java, the monsters' native language. 

### Milestone Key Points

* Created classes to support game play 
* Rooms contains a substantial method
* Rooms contains JUnit Tests
* Treasures, SwingInterface, Questions and Characters also contain some methods
* Remaining Classes contain basic structures and placeholder methods

#### Class Descriptions

* Room/Rooms (and Tests) - Sets up one room and the associated rooms the player can visit in the game
* Treasure/Treasures - Sets up treasure attributes and populates an ArrayList of Treasures to go in Rooms
* Character/Characters - Sets up character attributes and populates an ArrayList of Characters to go in Rooms 
* Question/QuestionReader/Questions - Sets up multiple choice question with hint, reads in .csv of questions, and populates method to feed questions when player attempts to collect Treasures. 
* Score - Keeps track of running score and displays final score at the end of game
* Player - Contains player attributes and inventory list
* SwingInterface - Manages the rooms and interacts with Treasures; will eventually interact with Characters
* Game Manager - Manages player interactions and controls flow of the game
* GamePlayer - Contains the main method

#### Notes
* Additional classes not included in the above list are for testing purposes and will not be part of the final project submission


