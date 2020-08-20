package com.example.autopermission.bean;

import java.io.Serializable;

public class ASIntentBean implements Serializable {

    private String packageName;
    private String activityName;
    private String actionName;
    private String uriData;
    //package:com.x.x
    private String uriDataFull;
    private String componenPkg;
    private String componenCls;
    private String extra;
    private String category;
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getUriData() {
        return uriData;
    }

    public void setUriData(String uriData) {
        this.uriData = uriData;
    }

    public String getUriDataFull() {
        return uriDataFull;
    }

    public void setUriDataFull(String uriDataFull) {
        this.uriDataFull = uriDataFull;
    }

    public String getComponenPkg() {
        return componenPkg;
    }

    public void setComponenPkg(String componenPkg) {
        this.componenPkg = componenPkg;
    }

    public String getComponenCls() {
        return componenCls;
    }

    public void setComponenCls(String componenCls) {
        this.componenCls = componenCls;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}