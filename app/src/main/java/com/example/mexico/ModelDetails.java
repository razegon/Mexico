package com.example.mexico;

import android.widget.TextView;

public class ModelDetails {

    private String overview, history, curiosities;

    public ModelDetails(String overview, String history, String curiosities) {
        this.overview = overview;
        this.history = history;
        this.curiosities = curiosities;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getCuriosities() {
        return curiosities;
    }

    public void setCuriosities(String curiosities) {
        this.curiosities = curiosities;
    }

    @Override
    public String toString() {
        return "ModelDetails{" +
                "overview='" + overview + '\'' +
                ", history='" + history + '\'' +
                ", curiosities='" + curiosities + '\'' +
                '}';
    }
}