package com.sdxxtop.trackerlibrary.http;

/**
 * Created by Administrator on 2018/5/7.
 */

public class BaseResponse<T> {
    public int code;
    public String msg;
    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
