package app004.flagquizapp;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

/**
 * A placeholder fragment containing a simple view.
 */
public class SettingsActivityFragment_Bandera extends PreferenceFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(app004.flagquizapp.R.xml.preferences);
    }
}
