package com.i18n.translation.enumaration;

public enum LanguageCode {
    EN("en"),
    TR("tr"),
    DE("de"),
    FR("fr"),
    ES("es"),
    RU("ru");

    private final String code;

    LanguageCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
