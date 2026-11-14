package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 7–9 (the line sensor's numbers, and followLine)
//
// SECTION C — Stretch. Do Stretch A, then Stretch B. The README says what each one should print.
// Stretch B adds a new class, Lapper, at the bottom of this file.
//
// There is no main method here yet. Typing it is part of the stretch.

@MBotLab(world = "line-track")
public class Stretch {
    public static void main(String[] args){
        /*
        6: STRAIGHT
        12: turn left
        3: turn right
        0: lost it
         */
        int[] readings = {6, 12, 3, 0};
        for (int s : readings) {
            if (s == 4 || s == 8 || s == 12) {
                System.out.println(s + ": turn left");
            } else if (s == 1 || s == 2 || s == 3) {
                System.out.println(s + ": turn right");
            } else if (s == 0) {
                System.out.println(s + ": lost it");
            } else {
                System.out.println(s + ": straight");
            }

            Lapper lapper = new Lapper(new Rover("Loop"));
            lapper.laps(2);
        }
    }

    public static class Lapper {
        private Rover rover;
        private int done;

        public Lapper(Rover rover) {
            this.rover = rover;
            this.done = done;
        }

        public void laps(int s) {
            for (int i = 1; i <= s; i++) {
                rover.followLine(725);
                done++;
                System.out.println("Lap "+done+" done");
            }
        }
    }

}
//the lapper takes the rover as a parameter because the lapper is just a rover doing something where the rover is the object itself.
