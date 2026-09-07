/*
Lucas Walker
Mr. Menezes
AT CS
9/8/26
*/

public class Homework3 {
    final static double fieldLenghtInches = 651.22;
    final static double fieldWidthInches = 317.69;
    final static double fieldLenghtMeters = convertMeters(fieldLenghtInches);
    final static double fieldWidthMeters = convertMeters(fieldWidthInches);
    final static double halfWidthMeters = fieldWidthMeters/2;
    final static double halfLenghtMeters = fieldLenghtMeters/2;
    public static void main(String[]args) {
        String action = args[0];
        String xPose = args[1];
        String yPose = args[2];
        String headingRadians = args[3];
        double x = Double.parseDouble(xPose);
        double y = Double.parseDouble(yPose);
        double headingRadsDouble = Double.parseDouble(headingRadians);
        float headingDegrees = (float)(Math.toDegrees(headingRadsDouble));
    }
    public static double convertMeters(double a) {
        double ans = a * 0.0254;
        return ans;
    }
    public static String getFieldQuadrant(double x, double y){
        String quadrant = null;
        if (x > halfLenghtMeters && y > halfWidthMeters) {
            quadrant = "upper right";
        }
        else if (x > halfLenghtMeters && y < halfWidthMeters) {
            quadrant = "lower left";
        }
        else if (x < halfLenghtMeters && y < halfWidthMeters) {
            quadrant = "lower right";
        }
        else if (x < halfLenghtMeters && y > halfWidthMeters) {
            quadrant = "upper left";
        }
        else {
            throw new IllegalArgumentException("you have to input X and Y or else robot sad :( ");
        }
        return quadrant;
    }
    public static String getAlliance(double x, double y){
        String quad = getFieldQuadrant(x, y);
        String Alliance = "blue";
        if (quad.equals("Upper Right") || quad.equals("Lower Right")) {
            Alliance = "red";
        }
        return Alliance;
    }
    public static String mirrorXOnly(double x, double y, float heading) {
        double xMirrored = fieldLenghtMeters - x;
        float headingMirrored = 180 - heading;
        String ans = "Your new pose is " + xMirrored + "," + y + ". Your new heading is" + headingMirrored;
        return ans;
    }
    public static String mirrorStandard(double x, double y, float heading) {
        double xMirrored = fieldLenghtMeters - x;
        double yMirrored = fieldWidthMeters - y;
        float headingMirrored = heading - 180;
        String ans = "Your new pose is " + xMirrored + "," + yMirrored + ". Your new heading is" + headingMirrored;
        return ans;
    }
    public static String mirrorYOnly(double x, double y, float heading) {
        double yMirrored = fieldWidthMeters - y;
        float headingMirrored = -heading;
        String ans = "Your new pose is " + x + "," + yMirrored + ". Your new heading is" + headingMirrored;
        return ans;
    }
}