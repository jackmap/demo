package com.example.entity.sys;

import java.io.Serializable;

public class R<T> implements Serializable {
    private static final long serialVersionUID = -4577255781088498763L;
    private static final int OK = 0;
    private static final int FAIL = 1;
    private static final int UNAUTHORIZED = 2;
    private T data; //服务端数据
    private int status = OK;

   // 状态码
    private String msg = "";

    private int count ;
   // 描述信息 //APIS

    public static R isOk() {
        return new R(0,"查詢成功");
    }

    public static R isFail() {
        return new R(1,"查詢失敗");
    }

    public static R isFail(Throwable e) {
        return isFail().msg(e);
    }

    public R msg(Throwable e) {
        this.setMsg(e.toString());
        return this;
    }

    public R data(T data) {
        this.setData(data);
        return this;
    }

    public R status(int status) {
        this.setStatus(status);
        return this;
    }
    //Constructors
    public R() {

    }

    public R( int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public R(int status, String msg,T data,int count) {
        this.data = data;
        this.status = status;
        this.msg = msg;
        this.count = count;
    }

    //Getter&Setters
    public T getData() {
     return data;
 }

    public void setData(T data) {
        this.data = data;
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
}
