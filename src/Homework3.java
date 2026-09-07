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
        String xPose = args[0];
        String yPose = args[1];
        String headingRadians = args[2];
        double x = Double.parseDouble(xPose);
        double y = Double.parseDouble(yPose);
        double headingRadsDouble = Double.parseDouble(headingRadians);
        double headingDegrees = Math.toDegrees(headingRadsDouble);
        final String quadrant = getFieldQuadrant(x, y);
    }
    public static double convertMeters(double a) {
        double ans = a * 0.0254;
        return ans;
    }
    public static String getFieldQuadrant(double x, double y){
        String quadrant = null;
        if (x > halfLenghtMeters && y > halfWidthMeters) {
            quadrant = "Upper Right";
        }
        else if (x > halfLenghtMeters && y < halfWidthMeters) {
            quadrant = "Lower Left";
        }
        else if (x < halfLenghtMeters && y < halfWidthMeters) {
            quadrant = "Lower Right";
        }
        else if (x < halfLenghtMeters && y > halfWidthMeters) {
            quadrant = "Upper Left";
        }
        else {
            throw new IllegalArgumentException("You have to input X and Y or else robot is sad :( ");
        }
        return quadrant;
    }
}