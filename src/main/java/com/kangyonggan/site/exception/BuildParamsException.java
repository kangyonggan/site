package com.kangyonggan.site.exception;

/**
 * @author kangyonggan
 * @since 2016/10/23
 */
public class BuildParamsException extends RuntimeException {

    @Override
    public String getMessage() {
        return "构建api请求参数异常, 请联系康永敢";
    }
}
