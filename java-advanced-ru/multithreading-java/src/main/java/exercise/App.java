package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static void main(String[] args) {
        int[] numbers = {10, -4, 67, 100, -100, 8};
        System.out.println(getMinMax(numbers));
        LOGGER.info(App.getMinMax(numbers).toString());
    }

    public static Map<String, Integer> getMinMax(int[] list) {
        Map<String, Integer> result = new HashMap<>();
        MinThread minThread = new MinThread(list);
        MaxThread maxThread = new MaxThread(list);
        maxThread.start();
        LOGGER.info("Max number search started");
        minThread.start();
        LOGGER.info("Min number search started");

        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            LOGGER.info("Поток был прерван");
        }
        LOGGER.info("Threads ready to show result");
        result.put("max", maxThread.getMaxNumber());
        result.put("min", minThread.getMinNumber());
        return result;
    }
    // END
}
