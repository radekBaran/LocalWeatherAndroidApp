package com.example.radek.localweather.weatherApi;

import com.google.gson.annotations.SerializedName;

public class RespBody {

    @SerializedName("location")
    private Location location;
    @SerializedName("current")
    private Current current;
    @SerializedName("error")
    private Error error;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}