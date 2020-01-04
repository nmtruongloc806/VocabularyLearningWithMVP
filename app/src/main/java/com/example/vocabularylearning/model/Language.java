package com.example.vocabularylearning.model;

import android.graphics.Color;

import java.io.Serializable;

public class Language implements Serializable {

    private int idLogo;
    private String content;
    private int idColor;

    public Language(int idLogo, String content, int idColor) {
        this.idLogo = idLogo;
        this.content = content;
        this.idColor = idColor;
    }

    public int getIdLogo() {
        return idLogo;
    }

    public String getContent() {
        return content;
    }

    public int getIdColor() {
        return idColor;
    }
}
