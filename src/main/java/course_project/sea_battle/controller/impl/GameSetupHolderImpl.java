package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.GameSetupHolder;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public final class GameSetupHolderImpl implements GameSetupHolder {
    private final Map<Integer, Integer> map;

    private GameSetupHolderImpl() {
        map = new TreeMap<>(Comparator.reverseOrder());
        map.put(4, 1);
        map.put(3, 2);
        map.put(2, 3);
        map.put(1, 4);
    }

    @Override
    public Map<Integer, Integer> getMapShips() {
        TreeMap<Integer, Integer> copyMap = new TreeMap<>(Comparator.reverseOrder());
        copyMap.putAll(map);
        return copyMap;
    }

    public static GameSetupHolderImpl getInstance() {
        return GameSetupHolderImpl.Holder.INSTANCE;
    }

    private static class Holder {
        static final GameSetupHolderImpl INSTANCE = new GameSetupHolderImpl();
    }
}
