package cn.ysf.ydma.ysf.util;

import java.io.Serializable;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma.entity
 * @data 2020/4/23
 */
public class YdmaResult implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
