package fr.adamaq01.chromagnon;

/**
 * Created by Adamaq01 on 19/05/2017.
 */
public class ChromagnonException extends RuntimeException {

    private int error;

    public ChromagnonException(String string, int error) {
        super("Error in " + string + ": " + errorCodeToString(error)+ " (" + error + ")");
        this.error = error;
    }

    /**
     * Translates an error code in a human readable String
     * @param error
     *          The error code
     * @return
     *          A human readable version of the error code
     */
    public static String errorCodeToString(int error) {
        switch (error) {
            case 0:
                return "No error";
            case 87:
                return "Invalid parameter";
            case 50:
                return "Not supported";
        }
        return "Unknown(" + error + ")";
    }

    /**
     * Returns the error code associated with this error
     * @return
     *          The error code
     */
    public int getErrorCode() {
        return this.error;
    }
}
