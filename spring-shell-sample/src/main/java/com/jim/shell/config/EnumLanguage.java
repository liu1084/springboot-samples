package com.jim.shell.config;
public enum EnumLanguage {

    LANGUAGE_EN("en", "english"),
    LANGUAGE_FR("fr", "france"),
    LANGUAGE_SCH("sch", "simple-chinese"),
    ;
    private String shortcut;
    private String language;
    EnumLanguage(String shortcut, String language) {
        this.shortcut =shortcut;
        this.language = language;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
