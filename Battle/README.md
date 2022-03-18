# OVERVIEW
This program creates a battle game and makes player P1 and player P2 fight against each other and simulates the battle game.


# FEATURES
1. The program features creation of players and assigning power to them  through randomly generated numbers.
2. It reflects values of inheritance and mimics real world objects.

# RUN THE PROGRAM

1. Through System.

1. Install the 11.0.2 version of  java on your system.
2. Copy the contents of /res/jar_directory/Battle.jar to your system lets say c directory.
3.  Run the Jar file using below command.
    C:\java\java.exe -jar C:\jar_you_want_to_run.jar


2. Through Intelli J

1. Download the .zip file, extract it.
2. Open IntelliJ IDEA click file>NEW>PROJECT
3. Locate the folder and open it.
4. In the res folder open Sanctuary.jar.
5. Right click and run the JAR file


# HOW TO USE THE PROGRAM
1. The program mostly runs automatically, but a user could provide keyboard input and enter "REMATCH" to play the game again with the same players.

# DESCRIPTION OF EXAMPLE

Run 1 -- Output.txt1.txt
1. Prints the welcome message and shows name of the players to be contesting.
2. Then it shows the initial configuration of the players with basic abilities.
3. P1 is selected by default for initial configuration.
4. Gears are set for P1 and the results were printed in Gear wise  and then alphabetically.
5. Configuration of gears are added to the player configuration and player info is printed then.
6. In the next step Weapon is assigned to teh player and same info is printed as well.
7. After that teh other player p2 is selected.
8. The configuration for P2 follows teh same steps from 4 to 6.
9. After that Toss happens and the winner is printed.
10. Calculations are shown after that as the player takes the  damage turn by turn.
11. Health and other parameters are printed.
12. Winner is printed at the last, and user is asked to send "REMATCH" for a rematch between the players with the same configuration.
13. Rematch version is shown in the text file.
14. Both the players would get to their initial state and the gears and weapon have to be assigned again.

Run 2 -- Output_without_seed.txt
1. Unseeded version of program is shown in the run file.






# DESIGN/ MODEL CHANGES
Following changes were done:
1. Following extra methods were added to the new model for ease of testing and for added functionality.






# ASSUMPTIONS
1. It is assumed that the bag size is a multiple of four so that 25 percent of the diminishing gears could be a whole number.
2. Footwear always come in pair, that is footwear in the selected gear would be



# LIMITATIONS
1. In case the Striking power  of the attacker is  lower than the avoiding power of the defender and vice versa for 25 continuous retries. The match is considered as a draw.
2. In case the actual damage comes as zero or negative  for continuous 25 times the match is considered a draw.



# CITATION
1. https://stackoverflow.com/questions/12458383/java-random-numbers-using-a-seed
