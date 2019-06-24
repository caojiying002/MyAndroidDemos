package org.jiying.demo.token.response;

public class NormalResponse {
    public boolean success;
    public int error_code;
    public Data data;

    public static class Data {
        public boolean result;
    }
}
