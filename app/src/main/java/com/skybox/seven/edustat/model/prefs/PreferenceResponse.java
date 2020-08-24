package com.skybox.seven.edustat.model.prefs;

import java.util.List;
import com.squareup.moshi.Json;



public class PreferenceResponse {

    @Json(name = "preferences")
    private Preferences preferences;
    @Json(name = "warnings")
    private List<Object> warnings = null;

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public List<Object> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<Object> warnings) {
        this.warnings = warnings;
    }

}




