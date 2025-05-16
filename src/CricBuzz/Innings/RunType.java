package CricBuzz.Innings;

public enum RunType {

    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    SIX(6);

    public int value;

    RunType(int valueLocal) {
        this.value = valueLocal;
    }

    public static RunType getRunTypeForValue(int value) {
        for (RunType type : RunType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }

    public static int getValueForRunType(RunType type) {
        for (RunType typeLocal : RunType.values()) {
            if (typeLocal == type) {
                return type.value;
            }
        }
        return 0;
    }


}
