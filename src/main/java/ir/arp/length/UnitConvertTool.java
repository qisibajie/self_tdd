package ir.arp.length;

import ir.arp.length.exception.InitException;
import ir.arp.length.exception.NoSupportedUnitException;

class UnitConvertTool {

    private UnitConvertTool() {
        throw new InitException("Could not be init");
    }

    static Integer convertToMM(int valueA, String unitA) {
        Integer basic = LengthUnit.mapUnit.get(unitA);
        if (basic == null) {
            throw new NoSupportedUnitException("The unit " + unitA + " is not supported");
        }
        return valueA * basic;
    }
}
