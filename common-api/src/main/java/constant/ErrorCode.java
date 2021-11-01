package constant;


import lombok.Getter;

@Getter
public enum ErrorCode {
    // TODO: redefine meaningfull codes
    SUCCESS ("00", "Success"),
    GENERAL_ERROR("01", "General Error"),
    CONNECTION_TIME_OUT("02", "Connection timeout"),
    REQUEST_INVALID("03", "Request Invalid"),
    AUTHENTICATION_FAIL("04", "Authentication fail"),
    CLAIM_NOT_FOUND("05", "Claim not found"),
    PHONE_NUMBER_NOT_FOUND("21", "Phone Number is not found"),
    PHONE_NUMBER_IS_LOGIN("22", "Phone Number is login app"),
    CAM_ID_NOT_FOUND("41", "CamID not found"),
    CAM_ID_ACTIVE("42", "CamID active"),
    CAM_ID_INACTIVE("43", "CamID inactive"),
    CAM_ID_BLOCK("44", "CamID block"),
    CAM_ID_TERMINAL("45", "CamID terminal"),
    OVER_LIMIT_SUB_MOBILE("61", "Over limit sub mobile"),
    OVER_LIMIT_SUB_FIX_BROAD_BAND("62", "Over limit sub fix broad band"),
    OVER_LIMIT_SUB("63", "Over limit sub"),
    SUB_EXIST_IN_USER_SERVICE("64", "Sub existed in user service"),
    SERVICE_NOT_FOUND("65", "Service not found");

    public final String code;
    private final String message;

    ErrorCode(String code, String message){
        this.code = code;
        this.message = message;
    }
}
