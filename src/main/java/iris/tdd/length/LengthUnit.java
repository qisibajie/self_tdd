package iris.tdd.length;

import iris.tdd.length.exception.InitException;

import java.util.HashMap;
import java.util.Map;

class LengthUnit {
    private LengthUnit() {
        throw new InitException("Could not be init");
    }

    static final Map<String, Integer> mapUnit = new HashMap<>();

    static {
        mapUnit.put("m", 1000);
        mapUnit.put("cm", 10);
        mapUnit.put("mm", 1);
    }
}