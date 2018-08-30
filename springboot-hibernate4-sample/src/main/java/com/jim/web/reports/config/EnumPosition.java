package com.jim.web.reports.config;

public enum EnumPosition {
    BOSS("老板"),
    M_T("高级"),
    M_M("中级"),
    M_B("低级"),
    STAFF("普通员工");

    private String position;

    EnumPosition(String p) {
        this.position = p;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
