package course_project.sea_battle.model;

import java.util.HashMap;
import java.util.Map;

public class CoordinateTranslator {
    private static Map<String, Integer> coordinateTranslatorMap;
    static {
        coordinateTranslatorMap = new HashMap<>();
        coordinateTranslatorMap.put("a", 0);
        coordinateTranslatorMap.put("b", 1);
        coordinateTranslatorMap.put("c", 2);
        coordinateTranslatorMap.put("d", 3);
        coordinateTranslatorMap.put("e", 4);
        coordinateTranslatorMap.put("f", 5);
        coordinateTranslatorMap.put("g", 6);
        coordinateTranslatorMap.put("h", 7);
        coordinateTranslatorMap.put("i", 8);
        coordinateTranslatorMap.put("j", 9);
    }
    public static int coordinate(String key){
        if(key == null) return 10;
        return coordinateTranslatorMap.get(key);
    }
}
