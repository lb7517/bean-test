package com.lb.bean.test.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : lb
 * @date : 2020/9/1 10:47
 * @description : 返回错误码
 */
public enum ResultState {

    SUCCESS(10000, "成功"),
    FAIL(10001, "失败");

    private Integer resCode;
    private String resDesc;

    public static final String RES_CODE = "resCode";
    public static final String RES_DESC = "resDesc";
    public static final String RES_DATA = "data";

    ResultState(Integer code, String message) {
        this.resCode = code;
        this.resDesc = message;
    }

    public Integer getResCode() {
        return resCode;
    }

    public String getResDesc() {
        return resDesc;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(RES_CODE, resCode);
        map.put(RES_DESC, resDesc);
        return map;
    }

    public Map<String, Object> toMap(Object data) {
        Map<String, Object> map = toMap();
        map.put(RES_DATA, data);
        return map;
    }
}
