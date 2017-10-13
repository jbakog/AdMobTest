package labkon.gr.admobtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MainActivity.context;
    }

    public void startBannerAd(View view) {

        Intent intent = new Intent(this, BannerActivity.class);
        startActivity(intent);

    }

    public void startInterstitialAd(View view) {
        Intent intent = new Intent(this, InterstitialActivity.class);
        startActivity(intent);
    }
}
