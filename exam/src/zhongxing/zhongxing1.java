package zhongxing;

public class zhongxing1 {
    public static int minWireLength(int numOfBulbs, int[] glowState,
                                    int[] distanceOfBulb) {
        int wireLength = 0;

        for (int i = 0; i < numOfBulbs; i++) {
            int minLength = 0;
            if (glowState[i] == 0) {
                if (i + 1 < numOfBulbs) {
                    minLength = distanceOfBulb[i+1] - distanceOfBulb[i];
                }

                if (i > 0) {
                    if (minLength == 0 || minLength > distanceOfBulb[i] - distanceOfBulb[i-1]) {
                        minLength = distanceOfBulb[i] - distanceOfBulb[i-1];
                    }
                }

                wireLength += minLength;
            }
        }

        return wireLength;
    }

    public static void main(String[] args) {
        int numOfBulbs = 8;
        int[] glowState = {0, 1, 0, 0, 1, 1, 0, 0};
        int[] distanceOfBulb = {3, 5, 10, 12, 13, 23, 30, 38};

        System.out.println(minWireLength(numOfBulbs, glowState, distanceOfBulb));
    }
}
