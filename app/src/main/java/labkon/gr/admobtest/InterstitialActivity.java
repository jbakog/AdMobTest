package labkon.gr.admobtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialActivity extends AppCompatActivity {

    private Button mShowButton;
    private InterstitialAd mInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);

        mShowButton = (Button) findViewById(R.id.button_interstitial_not_ready);
        mShowButton.setEnabled(false);
    }

    public void loadInterstitial(View view) {
        mShowButton.setEnabled(false);
        mShowButton.setText(R.string.interstitial_loading);

        mInterstitial = new InterstitialAd(this);
        mInterstitial.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
        mInterstitial.setAdListener(new ToastListener(this) {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mShowButton.setText(R.string.interstitial_show);
                mShowButton.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                mShowButton.setText(getErrorReason(errorCode));
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitial.loadAd(adRequest);
    }

    public void showInterstitial(View view) {
        if (mInterstitial.isLoaded()) {
            mInterstitial.show();
        }

        mShowButton.setText(R.string.interstitial_not_ready);
        mShowButton.setEnabled(false);
    }
}
