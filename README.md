=======
Group 13 Project - CPSC 219
=======

Team Members:
    <ul>
        <li>Dylan Dobbyn</li>
        <li>Daniel Contreras</li>
        <li>Zsanett Rado</li>
        <li>James Sullivan (Lead)</li>
    </ul>

-----
PROJECT INFORMATION
-----

  The project will consist of a simple Checkers game written in Java.
  <p>
  Features:
    <ul>
        <li>Graphical interface including menus, board, etc</li>
        <li>Two-player checkers game</li>
        <li>One-player checkers game vs. simple AI</li>
        <li>Scoreboard(?)</li>
        <li>Tournament mode(?)</li>
    </ul>
  
  
-----
DOCUMENTATION
-----

  All documentation will be recorded in the Code Repository (GitHub), in .txt format
  <p>
  Each deliverable will contain one summary Document which contains information on the work that was done
  during the deliverable, and updates on the organization of the project.
  <p>
  These Documents will be commited to the Documentation Directory.

-----
CODE FORMAT
-----

  Code will be written with in an object-oriented fashion. All classes will have relevant documentation as a header,
  including all relevant methods.
  <p>
  4-space Indentation will be used for consistency.
  <p>
  Documentation on all classes will be provided giving basic insight into their purpose and their contained methods.
  In addition, line documentation will be used in any relevant areas for clarity.
  <p>
  The Code will be commited to the Project branch.
  
-----
HOW-TO: GIT
-----

Pulling<p>
    <ol>
        <li>Create and sync a local folder with the Git repository (git clone https://github.com/JamesSullivan1/CPSC219_Team13_Project.git)</li>
        <li>Pull the most recent version of the repository (git pull)</li>
    </ol>

Pushing
    <ol>
        <li>Pull the most recent version of the repository (git pull)</li>
        <li>Make any changes to files, add new files, et cetera</li>
        <li>Enter the command (git add -A) to add all updated files to the local repository</li>
        <li>Enter the command (git commit -m "YOUR MESSAGE HERE") to give the commit a brief description</li>
        <li>Enter the command (git push origin master) to push the local version to the global repository</li>
    </ol>

-----
HOW-TO: ANT
-----

First ensure that Apache Ant is installed and up to date. The following commands are entered from the command prompt in the directory of this README.
<p>
ant clean : will clean the directory of remnant builds.<p>
ant compile : builds and compiles the files into the build/ directory. <p>
ant dist : generates a distribution jar file with a datestamp. <p>
ant run : runs the generated jar file to launch the game. <p>
