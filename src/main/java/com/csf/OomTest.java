package com.csf;

import com.alibaba.fastjson.JSONObject;

public class OomTest {

    public static void main(String[] args) {
        String s = "a";
        for (int i = 0; i < 204800; i++) {
            s += "a";
        }
        BigObject bigObject = new BigObject(s);
        while (true) {
            System.out.println(JSONObject.toJSONString(bigObject));

        }
    }
}

class BigObject {
    private String string;

    BigObject(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}


