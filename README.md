# JavaFinalProject  
----
This project is not so typical web crawler. Despite the functionality of downloading things from the web, a user is presented an interfece within one can choose not only the character but also a wide range variety of boots and weapons, each of them adding up to character's attributes, helping him to win the battle against the oponent.  
So the program is also some sort of a battle simulator.  
 Let me briefly discuss the use of every class...  
----  
* *Boots* and *Items* - classes responsible for choosing character's boots and weapons.  
* *Character* - defines character object its attributes and needed methods.  
* *Creator* - .form file is a specific IntelliJ format for GUI, .java file is hard-coded GUI.  
* *GetLOL* - the very core of the whole project, responsible for downloading all the names, weapons, boots, images needed for the GUI to display properly and the whole program to work without problems. 
The site from which it downloads all the info is [_leagueofgraphs_](https://www.leagueofgraphs.com).   
* *Observer* - as the name suggests, it's a simple interface allowing to implement Observer pattern.   
