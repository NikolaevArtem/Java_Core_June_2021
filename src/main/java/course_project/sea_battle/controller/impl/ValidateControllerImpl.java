package course_project.sea_battle.controller.impl;

public final class ValidateControllerImpl {
    private ValidateControllerImpl() {}

    public boolean coordinate(String str) {
        return !str.toLowerCase().matches("[a-i]([1-9]|10)");
    }

    public boolean vector(String str) {
        return str.toLowerCase().matches("[vg]");
    }

    public static ValidateControllerImpl getInstance() {
        return ValidateControllerImpl.Holder.INSTANCE;
    }

    private static class Holder {
        static final ValidateControllerImpl INSTANCE = new ValidateControllerImpl();
    }
}
