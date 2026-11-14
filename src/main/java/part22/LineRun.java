package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 7–9
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and follows the loop of tape all the way round.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

@MBotLab(world = "line-track")
public class LineRun {
    public static void main(String[] args) {
        Rover rover = new Rover("Tracker");
        //creates a new rover
        rover.followLine(400);
        //call the method for rover
        System.out.println("Halfway round");
        //prints the statement
        rover.followLine(325);
        //call the method for rover
        System.out.println(rover + " finished a lap");
        //prints the statement
    }

}
