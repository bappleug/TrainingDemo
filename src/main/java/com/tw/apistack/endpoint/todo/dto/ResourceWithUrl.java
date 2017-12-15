package com.tw.apistack.endpoint.todo.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jxzhong on 2017/7/3.
 */
@XmlRootElement
public class ResourceWithUrl<T> {

    private String msg;
    private int code;
    private T content;
    private String url;

    public ResourceWithUrl() {
    }

    public ResourceWithUrl(String msg, int code, T content, String url) {
        this.msg = msg;
        this.code = code;
        this.content = content;
        this.url = url;
    }

    @JsonUnwrapped
    @XmlAnyElement
    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
