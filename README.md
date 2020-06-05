MINE EXERCISE
There are bunch of mines in a mine field, and you are tasked with
exploding as many of them as you can.  The only caveat is you can
only explode one manually.  The mine you manually explode will set
off a chain reaction.  For any mine that explodes, all mines within
the blast radius of that mine will be triggered to explode in one
second.  The mine you manually explode blows up at time 0.
 
To do so, the program runs through the command line and accepts the location of a text file as a command line argument. The program
will then display a system out of the mines that create the maximum number of explosions as well as the number of explosions
expected

To start the program w/o Maven
In Intellij go to Edit Configurations, to Program Arguments and add the filename location, then run the program

From the command line
Navigate the director to `src\main\java\com\navis` and javac Main.java. Run `java Main <text file location>`

The mine exercise also has the ability to run tests from Maven. To do so, use your preferred IDE,
and add the Exercise as a Maven package. Run maven tests as usual.

