package ir4.arp.length;

import java.util.HashMap;
import java.util.Map;

class LengthUnit {
    static final Map<String, Integer> mapUnit = new HashMap<String, Integer>() {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        {
            put("m", 1000);
            put("cm", 10);
            put("mm", 1);
        }
    };
}