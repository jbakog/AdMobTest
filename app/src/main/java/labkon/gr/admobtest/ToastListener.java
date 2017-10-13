package labkon.gr.admobtest;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;

import static com.google.android.gms.ads.AdRequest.*;

/**
 * Created by john.bakoyannis on 12/10/2017.
 */

public class ToastListener extends AdListener {

    private Context context;

    ToastListener(Context context) {
        this.context = context;
    }

    @Override
    public void onAdLoaded() {
        super.onAdLoaded();
        Toast.makeText(context, "Ad Loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdClosed() {
        Toast.makeText(context, "Ad Closed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdFailedToLoad(int errorCode) {
        Toast.makeText(context, getErrorReason(errorCode), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdOpened() {
        Toast.makeText(context, "Ad Opened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdLeftApplication() {
        Toast.makeText(context, "Ad Left Application", Toast.LENGTH_SHORT).show();
    }

    public String getErrorReason(int errorCode) {
        switch (errorCode) {
            case ERROR_CODE_INTERNAL_ERROR:
                return "Internal error to ad API";
            case ERROR_CODE_INVALID_REQUEST:
                return "Invalid request";
            case ERROR_CODE_NETWORK_ERROR:
                return "Network error";
            case ERROR_CODE_NO_FILL:
                return "No idea!";
            default:
                return "No error";
        }
    }
}
