package app004.flagquizapp;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.widget.Toast;


import java.util.Set;

public class ConfigChangeListener_MJ implements OnSharedPreferenceChangeListener {
    private MainActivity_MJ mainActivityBandera;

    public ConfigChangeListener_MJ(MainActivity_MJ mainActivityBandera) {
        this.mainActivityBandera = mainActivityBandera;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        this.mainActivityBandera.setPreferencesChanged(true);

        if (key.equals(this.mainActivityBandera.getREGIONS())) {
            this.mainActivityBandera.getQuizViewModel().setGuessRows(sharedPreferences.getString(
                    MainActivity_MJ.CHOICES, null));
            this.mainActivityBandera.getQuizFragment().resetQuiz();
        } else if (key.equals(this.mainActivityBandera.getCHOICES())) {
            Set<String> regions = sharedPreferences.getStringSet(this.mainActivityBandera.getREGIONS(),
                    null);
            if (regions != null && regions.size() > 0) {
                this.mainActivityBandera.getQuizViewModel().setRegionsSet(regions);
                this.mainActivityBandera.getQuizFragment().resetQuiz();
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                regions.add(this.mainActivityBandera.getString(R.string.default_region));
                editor.putStringSet(this.mainActivityBandera.getREGIONS(), regions);
                editor.apply();
                Toast.makeText(this.mainActivityBandera, R.string.default_region_message,
                        Toast.LENGTH_LONG).show();
            }
        }

        Toast.makeText(this.mainActivityBandera, R.string.restarting_quiz,
                Toast.LENGTH_SHORT).show();
    }
}
