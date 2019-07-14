package domain;

import domain.message.ErrorMessage;
import util.StringUtils;

import java.util.regex.Pattern;

public class Name {
//    private static final Name NONE = Name.from(null);
    private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z]{3}$");
    
    private String name;
    
    private Name(String name) {
        if (!valid(name)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_VALUE.getMessage());
        }
        this.name = name;
    }
    
    private static boolean valid(String name) {
        return !StringUtils.isEmpty(name) && PATTERN.matcher(name).find();
    }
    
    public static Name from(String name) {
        return new Name(name);
    }
    
    public Boolean isEqualsName(String inputName) {
        return name.equals(inputName);
    }
}
