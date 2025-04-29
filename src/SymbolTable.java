package src;

import java.util.HashMap;

public class SymbolTable {
    private HashMap<String, String> symbols = new HashMap<>();

    public void declare(String name, String type) {
        symbols.put(name, type);
    }

    public boolean isDeclared(String name) {
        return symbols.containsKey(name);
    }

    public String getType(String name) {
        return symbols.get(name);
    }
}