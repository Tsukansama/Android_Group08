package com.example.cainiaoguo.domain;

public class MailResultInfo {

    /**
     * flag : true
     * data : null
     * errorMsg :
     */

    private boolean flag;
    private Object data;
    private String errorMsg;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
