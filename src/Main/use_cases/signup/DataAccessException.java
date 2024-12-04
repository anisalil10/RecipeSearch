package Main.use_cases.signup;

public class DataAccessException extends Exception {
    public DataAccessException(String string) {
        super(string);
    }
}