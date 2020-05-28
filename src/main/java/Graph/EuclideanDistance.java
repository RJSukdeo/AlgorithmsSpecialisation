package Graph;

public class EuclideanDistance {

    private EuclideanDistance() {
    }

    public static double getEuclideanDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static double getEuclideanDistance(TwoDimensionPoint point1, TwoDimensionPoint point2) {
        return getEuclideanDistance(point1.getX(), point2.getX(), point1.getY(), point2.getY());
    }

}
