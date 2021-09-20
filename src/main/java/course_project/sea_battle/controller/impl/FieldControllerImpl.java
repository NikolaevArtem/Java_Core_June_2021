package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.FieldController;
import course_project.sea_battle.controller.IOController;
import course_project.sea_battle.model.CellStatus;
import course_project.sea_battle.model.Field;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public final class FieldControllerImpl implements FieldController {
    private static final String TOP =            "   ╔══════════╗";
    private static final String HUD =            "   ║ABCDEFGHIG║";
    private static final String SPLIT_TOP_LINE = "╔══╬══════════╣";
    private static final String SPLIT_BOT_LINE = "╚══╩══════════╝";
    private static final String SPLIT_COL_LINE = "║";

    private final IOController ioController = IOControllerImpl.getInstance();

    private FieldControllerImpl() {}

    @Override
    public Field instance() {
        Field field = new Field();
        this.fillWater(field);
        return field;
    }

    private void fillWater(Field field) {
        if (field == null) return;
        CellStatus[][] cells = field.getCells();
        for (CellStatus[] row :
                cells) {
            Arrays.fill(row, CellStatus.WATER);
        }
    }

    @Override
    public void drawFields(Field... fields) {
        Optional<String[]> reduce = Arrays.stream(fields)
                .map(this::prepareForPrint)
                .reduce((arr1, arr2) -> {
                    Arrays.setAll(arr1, i -> arr1[i] + "\t" + arr2[i]);
                    return arr1;
                });
        reduce.ifPresent(x -> Arrays.stream(x).forEach(ioController::print));
    }

    private String[] prepareForPrint(Field field) {
        String[] arr = new String[field.getCells().length + 4];
        arr[0] = TOP;
        arr[1] = HUD;
        arr[2] = SPLIT_TOP_LINE;
        arr[arr.length - 1] = SPLIT_BOT_LINE;
        StringBuilder sb = new StringBuilder();
        int bound = Field.FIELD_SIZE;
        IntStream.range(0, bound).forEachOrdered(i -> {
            sb.append(String.format(SPLIT_COL_LINE + "%2s" + SPLIT_COL_LINE, i + 1));
            Arrays.stream(field.getCells()[i]).forEachOrdered(sb::append);
            sb.append(SPLIT_COL_LINE);
            arr[i + 3] = sb.toString();
            sb.setLength(0);
        });
        return arr;
    }

    public static FieldControllerImpl getInstance() {
        return FieldControllerImpl.Holder.INSTANCE;
    }

    private static class Holder {
        static final FieldControllerImpl INSTANCE = new FieldControllerImpl();
    }
}
