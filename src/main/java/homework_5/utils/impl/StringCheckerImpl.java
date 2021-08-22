package homework_5.utils.impl;

import homework_5.utils.StringChecker;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringCheckerImpl implements StringChecker {
    private Pattern pattern;

    public boolean checkData(String data) {
        if (pattern == null) pattern = Pattern.compile("default");
        return pattern.matcher(data).matches();
    }

    public StringCheckerImpl setPattern(String patternLiteral) throws PatternSyntaxException{
        this.pattern = Pattern.compile(patternLiteral);
        return this;
    }
}
