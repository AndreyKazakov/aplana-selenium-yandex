package steps;

import enums.VariablesStorage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AbstractStepHolder {

    private static VariablesStorage variables = VariablesStorage.VARIABLES;

    public static void setVariable(String name, Object value) { variables.get().put(name, value); }

    private final static String VAR_PATTERN = "\\#\\{(?<var>[^{^(^}^)]*)\\}";
    public final static Pattern VAR_PATTERN_COMPILED = Pattern.compile(VAR_PATTERN);

    public static <T> T evalVariable(String param) {
        if (param.trim().matches(".*" + VAR_PATTERN + ".*")) {
            Matcher varMatcher = VAR_PATTERN_COMPILED.matcher(param);
            StringBuffer varSB = new StringBuffer();
            while (varMatcher.find()) {
                String value = String.valueOf(variables.get().get(varMatcher.group("var")));
                varMatcher.appendReplacement(varSB, Matcher.quoteReplacement(value));
            }
            varMatcher.appendTail(varSB);
            return evalVariable(varSB.toString());
        }
        return (T)param;
    }
}
