package LFUCache;

public class Node {

    private final String key;
    private int value;
    private int frequency;

    public Node(String key, int value) {
        this.key = key;
        this.value = value;
        this.frequency = 0;
    }

    // Getter for key
    public String getKey() {
        return key;
    }

    // Getter for value
    public int getValue() {
        return value;
    }

    public int setValue(int value) {
        this.value = value;
        return this.value;
    }

    // Getter for frequency
    public int getFrequency() {
        return frequency;
    }

    // Setter for frequency
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
