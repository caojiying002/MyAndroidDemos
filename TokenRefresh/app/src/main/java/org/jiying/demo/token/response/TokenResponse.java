package org.jiying.demo.token.response;

public class TokenResponse {
    public boolean success;
    public int error_code;
    public Data data;

    public static class Data {
        public String token;
    }
}
