/**
 * 宝龙电商
 * com.plocc.framework.exception
 * ViewException.java
 *
 * 2013-7-5-下午6:05
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.framework.exception;

/**
 * ViewException
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-7-5-下午6:05
 * @email zhanggj-hws@powerlong.com
 * @description View异常，从 Controller 抛出
 */
public class ViewException extends BaseRuntimeException {
    /**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @zhuh 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;

	public ViewException(String exceptionCode) {
        super(exceptionCode);
    }
    
    public ViewException(ExceptionEnum exceptionEnum) {
    	super();
		if (exceptionEnum!= null) {
			super.exceptionCode = exceptionEnum.getCode();
			super.message = exceptionEnum.getMessage();
		}
	}

    public ViewException(String exceptionCode, String param1) {
        super(exceptionCode, param1);
    }

    public ViewException(String exceptionCode, String param1, String param2) {
        super(exceptionCode, param1, param2);
    }

    public ViewException(String exceptionCode, String param1, String param2, String param3) {
        super(exceptionCode, param1, param2, param3);
    }
}
