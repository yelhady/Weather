package com.weather.dom;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherObjectWrapper {

    @JsonProperty("data")
    private DataJsonObject dataJsonObject;

    private SystemNote systemNote;

    public DataJsonObject getDataJsonObject() {
        return dataJsonObject;
    }

    public void setDataJsonObject(DataJsonObject dataJsonObject) {
        this.dataJsonObject = dataJsonObject;
    }

    public SystemNote getSystemNote() {
        return systemNote;
    }

    public void setSystemNote(SystemNote systemNote) {
        this.systemNote = systemNote;
    }
}
