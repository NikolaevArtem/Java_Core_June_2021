package homework_5;

import homework_5.utils.MyReader;
import homework_5.utils.StringChecker;
import homework_5.utils.impl.MyReaderImpl;
import homework_5.utils.impl.StringCheckerImpl;

import java.util.NoSuchElementException;

public class AppHW_5 {
    private static final String PATTERN = "default";

    private final MyReader reader;
    private final StringChecker matcher;
    private final StringBuilder dataSB = new StringBuilder();
    private boolean isReaderClose = false;

    protected AppHW_5() {
        this(PATTERN);
    }

    public AppHW_5(String patternString) {
        reader = new MyReaderImpl();
        matcher = new StringCheckerImpl().setPattern(patternString);
    }

    public void clearData() {
        dataSB.setLength(0);
    }

    public boolean readData() throws NoSuchElementException {
        boolean result = true;
        if (isReaderClose) {
            result = false;
        } else {
            dataSB.append(reader.readData());
        }
        return result;
    }

    protected boolean check() {
        return matcher.checkData(dataSB.toString());
    }

    protected void closeReader() {
        isReaderClose = true;
        reader.close();
    }

    protected String getData() {
        return this.dataSB.toString();
    }

}
