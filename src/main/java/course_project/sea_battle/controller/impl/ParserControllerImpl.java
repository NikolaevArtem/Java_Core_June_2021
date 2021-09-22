package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.ParseController;

public final class ParserControllerImpl implements ParseController {
    private ParserControllerImpl() {}

    @Override
    public int[] parseCoordinate(String coordinate) {
        int x = coordinate.toLowerCase().charAt(0) - 'a';
        int y = Integer.parseInt(coordinate.toLowerCase().substring(1)) - 1;
        return new int[]{x, y};
    }

    @Override
    public boolean isVerticalVector(String vector) {
        return vector.equalsIgnoreCase("v");
    }

    public static ParserControllerImpl getInstance() {
        return ParserControllerImpl.Holder.INSTANCE;
    }

    private static class Holder {
        static final ParserControllerImpl INSTANCE = new ParserControllerImpl();
    }
}
