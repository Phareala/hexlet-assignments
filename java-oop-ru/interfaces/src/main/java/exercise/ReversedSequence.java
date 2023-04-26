package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{

    private final String text;
    private final String reversedText;

    public ReversedSequence(String text, String reversedText) {
        this.text = text;
        this.reversedText = new StringBuilder(text).reverse().toString();
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    @Override
    public String toString() {
        return reversedText;
    }
}
// END
