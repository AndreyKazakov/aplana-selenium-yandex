package enums;

import java.util.HashMap;
import java.util.Map;

public enum VariablesStorage {

    VARIABLES;

    private final HashMap<Object, Object> storage;

    VariablesStorage() {
        storage = new HashMap<Object, Object>();
    }

    public Map<Object, Object> get(){
        return storage;
    }
}
