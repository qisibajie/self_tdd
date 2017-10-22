package ir4.arp.length;

import javax.xml.bind.annotation.XmlType;

public class Length {

    public int value;
    public String unit;
    private static final String DEFAULT_UNIT = "cm";

    public Length(int length, String unit) {
        if (length < 0) {
            throw new RuntimeException("The Length is invalid");
        }
        this.value = length;
        this.unit = unit;
    }

    public Length(int length) {
        if (length < 0) {
            throw new RuntimeException("The Length is invalid");
        }
        this.value = length;
        this.unit = DEFAULT_UNIT;
    }

    public int getvalue() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }

    public int compare(Length lengthB) {
        Integer valueB = UnitConvertTool.convertToMM(lengthB.getvalue(), lengthB.getUnit());
        Integer valueA = UnitConvertTool.convertToMM(this.value, this.unit);
        return valueA.compareTo(valueB);
    }

}
