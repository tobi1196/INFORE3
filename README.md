##  Projektbeschreibung INFORE3

Dieses Projekt ist das Abschlussprojekt des Modules Informatik an der Technischen Hochschule Bingen. 

Der Bearbeitungszeitraum für das Projekt ist vom 15. Oktober ab 18:00 Uhr bis zum 2. November um 18:00 Uhr.

Die Beteiligten des Projektes sind zwei Studierende zusammen in einer Gruppe:

    adrianstarkbaum
    tobi1196

Zur Hilfestellung des Projektes steht der Dozent zur verfügung:

    Nicolai Parlog

## Lizenz

Die Lizenzrechte sind in der Datei LICENSE.txt zu lesen. Sie beinhaltet Informationen zu Nutzungsrecht, Schutz und Übertragbarkeit des Codes zu diesem Projekt.

## Ausführen des Programm

Das Programm kann als .jar Datei mit Java über die Command Line folgendermaßen gestartet werden:

    java –jar <Pfad zum Programm>

Die Jar Datei befindet sich im Ordner \out\artifacts\INFORE3

## Sprachregeln

Für das Projekt gelten festgelegte Regeln für die Sprache. Dies soll Durcheinander bei der Kommunikation miteinander und dem Code vermeiden.

## Es gilt zu beachten:

    Code mit all seinen Bestandteilen (Klassen, Variablennamen, Testnamen, Kommentare) auf Englisch
    Commits beziehungsweise deren Beschreibung (sowohl beim lokalen Committen als auch Merge-Commits auf GitHub) auf Deutsch
    GitHub: mit den verschiedenen Bestandteilen wie Kommentare, Beschreibungen von Issues und PullRequests sowie Milestones auf Deutsch

## Project Infrastructure

Create the project’s infrastructure:

    create a README.md describing the project and listing your names (they do not have to be real names if you don’t want; GitHub user names are fine as well)
    add a license and document it in the README
    decide on a language (e.g. by discussing it on the issue that belongs to this task) and document it in the README:
        code (e.g. classes and variables) needs to be English
        comments can be English or German but must be consistent
        conversation on GitHub can be English or German but must be consistent (does not have to be the same as comments)
    research what a code of conduct is, how it relates to open source projects, and pick one; add it as a file to the project and document it in the README
    create a .gitignore file that prevents adding files/folders that are specific to IntelliJ IDEA and Maven
    create a Maven/Kotlin project that contains a simple HelloWorld.kt class with a main method printing "Hello, World." and that successfully builds a JAR; use de.thbingen.info2 as group ID and your group name as artifact ID
    integrate with Travis (I’ll tell you how to do that - ping me on the issue when Maven is set up)
    set up JUnit 4 by extending pom.xml and writing a small HelloWorldTest
    extend the README to tell users how to launch the application

When all that’s done:

    release version 1.0

## Create a Simple Rail Network Simulation

Now that the infrastructure is set up, you can write some code. Please always include tests for your code and remember to use issues and pull requests, like described above. The goal is to implement a simple rail network simulation.

    create a simulation consisting of trains, schedules, rail segments, and a rail network; the network consists of a five rail segments that each has a capacity for three trains, each train has a schedule which determines on which segment it wants to drive; implement a single simulation step (which is supposed to represent a quarter hour), where:
        each individual train announces on which segment it wants to drive based on its schedule
        the network tallies up the number of trains on each segment and compares it to the capacity
        the network decides for each train whether it drives or is delayed due to the segment being at maximum capacity:
            less than or equal to capacity ~> all trains drive
            over capacity ~> all trains are delayed
    write a scenario function that simulates a scenario with about a dozen trains and call it from the main program
    let the trains keep track of whether they can drive or were delayed and, within the scenario function, print that information at the end of the simulation
    write an external function, which uses Univocity Parsers to parse input (trains and their schedules), triggers the simulation, and writes resulting data (drive vs delay) as CSV (this does not touch on the scenario function, which should be unchanged) and call external from main

When all that’s done:

    release version 2.0

## Extend Simulation By Making It More Configurable

    make the number of segments configurable and parse the value from CSV; update scenario and external
    make the segments’ capacity configurable and parse the values from CSV; update scenario and external
    let the network keep track of the segments’ remaining and total capacity and write the results to console (scenario) or CSV (external)
    on each segment, only delay as many trains as are over capacity (example: if capacity is 3 and there are 5 trains, only delay 2 of them)
    randomize the decision which trains are delayed on any given segment; make sure that of all the trains that want to use a segment each is equally likely to be delayed
    extend the README by writing a user documentation, explaining users how to use the program

When all that’s done:

    release version 3.0

## Extend Simulation to Cover an Entire Day

    base a train’s likelihood of getting delayed on its priority:
        give each train one of three priorities (include that in CSV input and update scenario and external)
        make sure that each increase in priority halves the relative likelihood of that train getting delayed (example: trains with prio 1, 2, 3 should have delay chances of ~57%, ~29%, ~14%; trains with prio 1, 2, 2, 3, 3 should have chances 40%, 20%, 20%, 10%, 10%)
    cover an entire train-day (6am to 10pm) by simulating 64 steps in a row:
        trains now need to know for each of the steps, on which segment they want to drive
        if a train gets delayed it needs to complete that segment in the next simulation step, which means the unfulfilled part of its schedule gets shifted one step (example: wanted to drive at 0800 in #3, 0815 in #6, 0830 in #8; if it gets delayed at 0815, it’s new schedule is 0800 in #3, 0815 in #6, 0830 in #6, 0845 in #8)
        extend result tracking by making sure that each train knows for every step in which segment it was
        update the scenario function to the simulation’s new requirements
    extend CSV input/output and external to match the new requirements and results:
        extend input to include for each step in which segment a train wants to drive
        extend output to include for each step in which segment the train was
    extend the README by writing a user documentation, explaining users how to use the program

When all that’s done:

    release version 4.0
