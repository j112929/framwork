package com.plocc.framework.exception;

/**
 * 宝龙电商
 * org.powerlong.framework.exception
 * BaseRuntimeException
 * <p/>
 * 2013-6-27-下午02:01:53
 * 2013宝龙公司-版权所有
 */
public class BaseRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 3905807495715960369L;
    protected String exceptionCode;
    protected String message;

    private String param1;
    private String param2;
    private String param3;

    public BaseRuntimeException() {
    	super();
	}
    
    public BaseRuntimeException(String exceptionCode) {
        super(exceptionCode);
    }

    public BaseRuntimeException(String exceptionCode, String param1) {
        super(exceptionCode);
        this.param1 = param1;
    }

    public BaseRuntimeException(String exceptionCode, String param1, String param2) {
        super(exceptionCode);
        this.param1 = param1;
        this.param2 = param2;
    }

    public BaseRuntimeException(String exceptionCode, String param1, String param2,
                                String param3) {
        super(exceptionCode);
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }

    public BaseRuntimeException(ExceptionEnum exceptionEnum) {
        super();
        if (exceptionEnum != null) {
            exceptionCode = exceptionEnum.getCode();
            message = exceptionEnum.getMessage();
        }
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExceptionCode() {
        return this.exceptionCode;
    }
}
