package br.com.tecnopon.sistecomie.apiclient.model.request.customer;

import java.util.List;

public class Request {

    String call;
    String app_key;
    String app_secret;
    List<Param> param;

    public Request(String call, String app_key, String app_secret, List<Param> param) {
        this.call = call;
        this.app_key = app_key;
        this.app_secret = app_secret;
        this.param = param;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }

    public void setApp_secret(String app_secret) {
        this.app_secret = app_secret;
    }

    public void setParam(List<Param> param) {
        this.param = param;
    }

    public String getCall() {
        return call;
    }

    public String getApp_key() {
        return app_key;
    }

    public String getApp_secret() {
        return app_secret;
    }

    public List<Param> getParam() {
        return param;
    }
}
