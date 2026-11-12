package part21;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 4–9
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and drives it until it is close to the wall.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

@MBotLab(world = "wall-ahead")
public class FollowAlong {
    public static void main(String[] args) {
        Rover scout = new Rover("Scout");
        //creates a new rover
        System.out.println(scout + " is ready");
        //prints the statement
        scout.driveUntilBlocked();
        //calls the method on the scout rover
        System.out.println(scout + " stopped. Something is less than 20 cm ahead.");
        //prints the statement
    }

}
