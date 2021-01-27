package com.chris.vueblog.common;

import lombok.Data;

@Data
public class Result {
    private String code;
    private String msg;
    private Object data;

    public static Result succ() {}
}
