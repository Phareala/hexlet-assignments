package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread{
    private int maxNumber;
    private final int[] massive;
    MaxThread(int[] numbers) {
        this.massive = numbers;
    }
    @Override
    public void run() {
        maxNumber = Arrays.stream(massive).max().getAsInt();
    }

    public int getMaxNumber() {
        return maxNumber;
    }
}
// END
