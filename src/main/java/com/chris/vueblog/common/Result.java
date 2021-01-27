package com.chris.vueblog.common;

import lombok.Data;

@Data
public class Result {
    private String code;
    private String msg;
    private Object data;

    public static Result succ(Object data) {
        Result m = new Result();
        m.setCode("0");
        m.setMsg("操作成功");
        m.setData(data);
        return m;
    }

    public static Result succ(String msg, Object data) {
        Result m = new Result();
        m.setCode("0");
        m.setMsg(msg);
        m.setData(data);
        return m;
    }

    public static Result fail(Object data) {
        Result m = new Result();
        m.setCode("-1");
        m.setMsg("操作失败");
        m.setData(data);
        return m;
    }

    public static Result fail(Object data, String msg) {
        Result m = new Result();
        m.setCode("-1");
        m.setMsg(msg);
        m.setData(data);
        return m;
    }
}
