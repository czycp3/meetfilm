package com.stylefeng.guns.core.base.tips;

/**
 * @author czy
 * @date 2019/6/5 17:44
 */
public class ErrorMsg {
    private int status;
    private String msg;

    public ErrorMsg() {
    }

    public ErrorMsg(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ErrorMsg{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }
}
