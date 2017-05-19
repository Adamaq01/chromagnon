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
            case -1:
                return "Invalid";
            case 0:
                return "Success";
            case 5:
                return "Access denied";
            case 6:
                return "Invalid handle";
            case 50:
                return "Not supported";
            case 87:
                return "Invalid parameter";
            case 1062:
                return "The service has not been started";
            case 1152:
                return "Cannot start more than one instance of the specified program";
            case 1167:
                return "Device not connected";
            case 1168:
                return "Element not found";
            case 1235:
                return "Request aborted";
            case 1247:
                return "An attempt was made to perform an initialization operation when initialization has already been completed";
            case 4309:
                return "Resource not available or disabled";
            case 4319:
                return "Device not available or supported";
            case 5023:
                return "The group or resource is not in the correct state to perform the requested operation";
            case 259:
                return "No more items";
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
