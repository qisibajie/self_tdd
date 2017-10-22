package ir4.arp.length;

class Length {

    private int value;
    private String unit;
    private static final String DEFAULT_UNIT = "cm";

    Length(int length, String unit) {
        if (length < 0) {
            throw new RuntimeException("The Length is invalid");
        }
        this.value = length;
        this.unit = unit;
    }

    Length(int length) {
        if (length < 0) {
            throw new RuntimeException("The Length is invalid");
        }
        this.value = length;
        this.unit = DEFAULT_UNIT;
    }

    int getValue() {
        return this.value;
    }

    private String getUnit() {
        return this.unit;
    }

    int compare(Length lengthB) {
        Integer valueB = UnitConvertTool.convertToMM(lengthB.getValue(), lengthB.getUnit());
        Integer valueA = UnitConvertTool.convertToMM(this.value, this.unit);
        return valueA.compareTo(valueB);
    }

}
