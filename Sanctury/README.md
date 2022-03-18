# OVERVIEW
This program basically converts the sanctuary operations, paper version into an automated version.

# FEATURES
1. Isolation starts with limited number of animals in it.
2. Sanctuary starts with limited number  of animals and fixed size of teh troop.
3. Monkeys can be added to teh isolation,  with teh help of the type Monkey.
4. After monkey gets added set medication could be given to the monkey before it could be added to the enclosure.
5. A method send to is used to send the monkey from isolation to enclosure.
6. With the use of  enclosure object one could traverse through teh list of enclosures and can use methods such as get sign, get species etc.
7. A particular enclosure would only house one troop of monkey.
8. Also if you exceed the total  size or  the species of monkey could be added in the enclosure it is gonna throw an Illegal Argument exception.
9. Monkeys could be deleted and added from the enclosures and Isolation.
10. We can print where the monkey is hosted, location of the monkey and other details through our main class.


# RUN THE PROGRAM
1. Download the .zip file, extract it.
2. Open IntelliJ IDEA click file>NEW>PROJECT
3. Locate the folder and open it.
4. In the res folder open Sanctuary.jar.
5. RIght click and run the JAR file


# DESCRIPTION OF EXAMPLES
Open the /res folder  and check output.txt file.

# DESIGN/ MODEL CHANGES
Following changes were done:
1. The below  methods were implemented in the Enclosure class insted of the abstract class.
   +getSign():String
   +printEnclosureState():void
   +sendToEnclosure():void
   +setSpecies:()void
   +returnSpeciesLocation():string
   +getSpecies():<String>
   +deleteMonkeyEnclosure():void
   +getEnclosures():<Troop>
   2.The below  methods were implemented in the Isolation class insted of the abstract class.
   +addMonkeyIsolation():void
   +setMedication():voidt





# ASSUMPTIONS

It is assumes that  t he sanctuary could house any species and there is no specific types created for it.

# LIMITATIONS
1. The max value of Isolation animals as been kept to 1000.
2. The max value of troop is 100 and the size of the troop is 1000
