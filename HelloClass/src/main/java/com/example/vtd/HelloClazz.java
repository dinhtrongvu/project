package com.example.vtd;

public class HelloClazz {
    private String msg;

    public HelloClazz() {
        this.msg = "From Constructor: Constructor";
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void printMsg () {
        System.out.println("Your Msg: "+msg);
    }

    private void initMsg() {
        msg = "From init Msg: Chao em";
    }
}
