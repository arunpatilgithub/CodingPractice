public class RobotBoundedInCircle {

    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
    }

    public static boolean isRobotBounded(String instructions) {
        //If we do not end up in the North direction, that means we are going to in cycle.

        //Initialize array for all the directios in a particular order.
        //This is because, if we are going in a certain direction, moving left and right should
        //give us the corresponding direction.

        char[] directions = new char[]{'E', 'S', 'W', 'N'};
        //0 -> E, 1 -> S, 2 ->W, 3 ->N;

        //Since we start with facing North direction.
        int currentDirection = 3;
        int x = 0;
        int y = 0;

        for (int i=0; i<instructions.length(); i++) {

            if (instructions.charAt(i) == 'L') {

                if (currentDirection - 1 < 0) {
                    currentDirection = 3;
                } else {
                    currentDirection = currentDirection - 1;
                }

            } else if (instructions.charAt(i) == 'R') {
                if (currentDirection + 1 > directions.length - 1) {
                    currentDirection = 0;
                } else {
                    currentDirection = currentDirection + 1;
                }
            } else {

                if (currentDirection == 0) {
                    x = x + 1;
                } else if (currentDirection == 1) {
                    y = y - 1;
                } else if (currentDirection == 2) {
                    x = x - 1;
                } else {
                    y = y + 1;
                }
            }

        }

        return (x ==0 && y == 0) || (currentDirection != 3);
    }
}
