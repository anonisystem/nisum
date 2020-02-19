package cl.nissum.app.config;

/**
 * Application constants.
 */
public final class Constants {

    // Regex for acceptable 
    public static final String PASSWORD_REGEX = "[0-9{2}a-zA-Z{1}]+";
    public static final String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";
    public static final String NAME_REGEX = "[a-zA-Z ]+";
    private Constants() {
    }
}
