import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class SVG_3013_CCTest {

    @Test
    @DisplayName("timeCal should return 0 when distance is negative")
    void timeCalShouldReturnZeroWhenDistanceIsNegative() {
        double result = SVG_3013_CC.timeCal(10.0, -5.0);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    @DisplayName("timeCal should return 0 when distance is zero")
    void timeCalShouldReturnZeroWhenDistanceIsZero() {
        double result = SVG_3013_CC.timeCal(10.0, 0.0);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    @DisplayName("timeCal should return 0 when speed is zero")
    void timeCalShouldReturnZeroWhenSpeedIsZero() {
        double result = SVG_3013_CC.timeCal(0.0, 100.0);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    @DisplayName("timeCal should return 0 when both speed and distance are zero")
    void timeCalShouldReturnZeroWhenBothZero() {
        double result = SVG_3013_CC.timeCal(0.0, 0.0);
        assertEquals(0.0, result, 0.001);
    }

        void timeCalShouldCalculateCorrectTime(double speed, double distance, double expectedTime) {
        double result = SVG_3013_CC.timeCal(speed, distance);
        assertEquals(expectedTime, result, 0.001);
    }

    @Test
    @DisplayName("timeCal should handle decimal values correctly")
    void timeCalShouldHandleDecimalValues() {
        double result = SVG_3013_CC.timeCal(45.5, 100.25);
        assertEquals(2.2033, result, 0.001);
    }

    @Test
    @DisplayName("timeCal should handle large numbers")
    void timeCalShouldHandleLargeNumbers() {
        double result = SVG_3013_CC.timeCal(1000000.0, 5000000000.0);
        assertEquals(5000.0, result, 0.001);
    }

    @Test
    @DisplayName("timeCal should handle very small numbers")
    void timeCalShouldHandleSmallNumbers() {
        double result = SVG_3013_CC.timeCal(0.001, 0.0005);
        assertEquals(0.5, result, 0.001);
    }

    @Test
    @DisplayName("buildReport should return correctly formatted string")
    void buildReportShouldReturnCorrectlyFormattedString() {
        String result = SVG_3013_CC.buildReport(50.0, 100.0);
        assertEquals("distance: 100.0 ,time: 2.0, speed: 50.0", result);
    }

    @Test
    @DisplayName("buildReport should handle zero values in report")
    void buildReportShouldHandleZeroValues() {
        String result = SVG_3013_CC.buildReport(0.0, 0.0);
        assertEquals("distance: 0.0 ,time: 0.0, speed: 0.0", result);
    }

    @Test
    @DisplayName("buildReport should handle negative distance in report")
    void buildReportShouldHandleNegativeDistance() {
        String result = SVG_3013_CC.buildReport(50.0, -100.0);
        assertEquals("distance: -100.0 ,time: 0.0, speed: 50.0", result);
    }

    @Test
    @DisplayName("buildReport should handle zero speed in report")
    void buildReportShouldHandleZeroSpeed() {
        String result = SVG_3013_CC.buildReport(0.0, 100.0);
        assertEquals("distance: 100.0 ,time: 0.0, speed: 0.0", result);
    }


    @Test
    @DisplayName("buildReport should handle large numbers in report")
    void buildReportShouldHandleLargeNumbers() {
        String result = SVG_3013_CC.buildReport(1000000.0, 5000000000.0);
        assertEquals("distance: 5.0E9 ,time: 5000.0, speed: 1000000.0", result);
    }

    @Test
    @DisplayName("buildReport should call timeCal method")
    void buildReportShouldCallTimeCal() {
        // This verifies that buildReport uses timeCal correctly
        // For a given speed and distance, the time should be distance/speed
        double speed = 75.0;
        double distance = 150.0;
        String result = SVG_3013_CC.buildReport(speed, distance);
        String expected = "distance: 150.0 ,time: 2.0, speed: 75.0";
        assertEquals(expected, result);
    }
}