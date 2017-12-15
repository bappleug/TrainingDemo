package com.tw.apistack.endpoint.login.dto;

public class Session {
    private String session;

    public Session(String session) {
        this.session = session;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
