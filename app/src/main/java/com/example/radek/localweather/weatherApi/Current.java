package com.example.radek.localweather.weatherApi;

import com.google.gson.annotations.SerializedName;

public class Current {

    @SerializedName("last_updated")
    private String lastUpdated;
    @SerializedName("temp_c")
    private double tempInCelsius = 0;
    @SerializedName("pressure_mb")
    private double pressureMb;

    @SerializedName("condition")
    private Condition mCondition;

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public double getTempInCelsius() {
        return tempInCelsius;
    }

    public void setTempInCelsius(double tempInCelsius) {
        this.tempInCelsius = tempInCelsius;
    }

    public double getPressureMb() {
        return pressureMb;
    }

    public void setPressureMb(double pressureMb) {
        this.pressureMb = pressureMb;
    }

    public Condition getCondition() {
        return mCondition;
    }

    public void setCondition(Condition condition) {
        mCondition = condition;
    }
}