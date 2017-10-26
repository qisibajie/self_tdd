package ir.arp.length;

import ir.arp.length.exception.LengthInvalidException;

class Length {

    private int value;
    private String unit;
    private static final String DEFAULT_UNIT = "cm";

    Length(int length, String unit) {
        if (length < 0) {
            throw new LengthInvalidException("The Length is invalid");
        }
        this.value = length;
        this.unit = unit;
    }

    Length(int length) {
        if (length < 0) {
            throw new LengthInvalidException("The Length is invalid");
        }
        this.value = length;
        this.unit = DEFAULT_UNIT;
    }

    int getvalue() {
        return this.value;
    }

    private String getUnit() {
        return this.unit;
    }


    int compare(Length lengthB) {
        Integer valueB = UnitConvertTool.convertToMM(lengthB.getvalue(), lengthB.getUnit());
        Integer valueA = UnitConvertTool.convertToMM(this.value, this.unit);
        return valueA.compareTo(valueB);
    }

}
