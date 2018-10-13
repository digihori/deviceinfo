package tk.horiuchi.deviceinfo;

import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.TextView;

import java.lang.reflect.Method;

import static android.util.DisplayMetrics.DENSITY_280;
import static android.util.DisplayMetrics.DENSITY_360;
import static android.util.DisplayMetrics.DENSITY_400;
import static android.util.DisplayMetrics.DENSITY_420;
import static android.util.DisplayMetrics.DENSITY_560;
import static android.util.DisplayMetrics.DENSITY_HIGH;
import static android.util.DisplayMetrics.DENSITY_LOW;
import static android.util.DisplayMetrics.DENSITY_MEDIUM;
import static android.util.DisplayMetrics.DENSITY_TV;
import static android.util.DisplayMetrics.DENSITY_XHIGH;
import static android.util.DisplayMetrics.DENSITY_XXHIGH;
import static android.util.DisplayMetrics.DENSITY_XXXHIGH;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("build","BOARD:" + Build.BOARD);
        Log.d("build","BOOTLOADER:" + Build.BOOTLOADER);    //Android 1.6未対応
        Log.d("build","BRAND:" + Build.BRAND);
        Log.d("build","CPU_ABI:" + Build.CPU_ABI);
        Log.d("build","CPU_ABI2:" + Build.CPU_ABI2);        //Android 1.6未対応
        Log.d("build","DEVICE:" + Build.DEVICE);
        Log.d("build","DISPLAY:" + Build.DISPLAY);
        Log.d("build","FINGERPRINT:" + Build.FINGERPRINT);
        Log.d("build","HARDWARE:" + Build.HARDWARE);        //Android 1.6未対応
        Log.d("build","HOST:" + Build.HOST);
        Log.d("build","ID:" + Build.ID);
        Log.d("build","MANUFACTURER:" + Build.MANUFACTURER);
        Log.d("build","MODEL:" + Build.MODEL);
        Log.d("build","PRODUCT:" + Build.PRODUCT);
        Log.d("build","RADIO:" + Build.RADIO);              //Android 1.6未対応
        Log.d("build","TAGS:" + Build.TAGS);
        Log.d("build","TIME:" + Build.TIME);
        Log.d("build","TYPE:" + Build.TYPE);
        Log.d("build","UNKNOWN:" + Build.UNKNOWN);          //Android 1.6未対応
        Log.d("build","USER:" + Build.USER);
        Log.d("build","VERSION.CODENAME:" + Build.VERSION.CODENAME);
        Log.d("build","VERSION.INCREMENTAL:" + Build.VERSION.INCREMENTAL);
        Log.d("build","VERSION.RELEASE:" + Build.VERSION.RELEASE);
        Log.d("build","VERSION.SDK:" + Build.VERSION.SDK);
        Log.d("build","VERSION.SDK_INT:" + Build.VERSION.SDK_INT);

        String stext = "";
        //stext += "BOARD:" + Build.BOARD + "\n";
        //stext += "BOOTLOADER:" + Build.BOOTLOADER+ "\n";
        stext += "BRAND:" + Build.BRAND + "\n";
        //stext += "CPU_ABI:" + Build.CPU_ABI + "\n";
        //stext += "CPU_ABI2:" + Build.CPU_ABI2 + "\n";
        //stext += "DEVICE:" + Build.DEVICE + "\n";
        //stext += "DISPLAY:" + Build.DISPLAY + "\n";
        //stext += "FINGERPRINT:" + Build.FINGERPRINT + "\n";
        //stext += "HARDWARE:" + Build.HARDWARE + "\n";
        //stext += "HOST:" + Build.HOST + "\n";
        //stext += "ID:" + Build.ID + "\n";
        //stext += "MANUFACTURER:" + Build.MANUFACTURER + "\n";
        stext += "MODEL:" + Build.MODEL + "\n";
        //stext += "PRODUCT:" + Build.PRODUCT + "\n";
        //stext += "RADIO:" + Build.RADIO + "\n";
        //stext += "TAGS:" + Build.TAGS + "\n";
        //stext += "TIME:" + Build.TIME + "\n";
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd, E, HH:mm:ss", Locale.ENGLISH);
        //String text = sdf.format(Build.TIME);
        //stext += "TIME:" + text + "\n";
        //stext += "TIME:" + sdf.format(Calendar.getInstance().getTime()) + "\n";
        //stext += "TYPE:" + Build.TYPE + "\n";
        //stext += "UNKNOWN:" + Build.UNKNOWN + "\n";
        //stext += "USER:" + Build.USER + "\n";
        //stext += "VERSION.CODENAME:" + Build.VERSION.CODENAME + "\n";
        //stext += "VERSION.INCREMENTAL:" + Build.VERSION.INCREMENTAL + "\n";
        stext += "VERSION.RELEASE:" + Build.VERSION.RELEASE + "\n";
        stext += "VERSION.SDK:" + Build.VERSION.SDK + "\n\n";
        //stext += "VERSION.SDK_INT:" + Build.VERSION.SDK_INT + "\n";

        DisplayMetrics metrics = new DisplayMetrics();
        Display display = getWindowManager().getDefaultDisplay();
        display.getMetrics(metrics);
        Point point = new Point(0, 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            // Android 4.2-
            display.getRealSize(point);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            // Android 3.2-
            try {
                Method getRawWidth = Display.class.getMethod("getRawWidth");
                Method getRawHeight = Display.class.getMethod("getRawHeight");
                int width = (Integer) getRawWidth.invoke(display);
                int height = (Integer) getRawHeight.invoke(display);
                point.set(width, height);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // 流石にこれより古いバージョンは見ない
        }

        //int main_width = metrics.widthPixels;
        //int main_height = metrics.heightPixels;
        Log.w("Main", String.format("widthPixels=%d\n", metrics.widthPixels));
        Log.w("Main", String.format("heightPixels=%d\n", metrics.heightPixels));
        Log.w("Main", String.format("Xdpi=%f\n", metrics.xdpi));
        Log.w("Main", String.format("Ydpi=%f\n", metrics.ydpi));
        Log.w("Main", String.format("density=%f\n", metrics.density));
        Log.w("Main", String.format("densityDpi=%d\n", metrics.densityDpi));
        Log.w("Main", String.format("scaledDensity=%f\n", metrics.scaledDensity));

        String dtext = String.format("widthPixels=%d\n", point.x);
        dtext += String.format("heightPixels=%d\n", point.y);
        dtext += String.format("Xdpi=%f\n", metrics.xdpi);
        dtext += String.format("Ydpi=%f\n", metrics.ydpi);
        dtext += String.format("density=%f\n", metrics.density);
        dtext += String.format("densityDpi=%d(%s)\n", metrics.densityDpi, getGeneralizedDensity(metrics.densityDpi));
        dtext += String.format("scaledDensity=%f\n", metrics.scaledDensity);

        double inchX = metrics.widthPixels / metrics.xdpi;
        double inchY = metrics.heightPixels /metrics.ydpi;
        double inch = Math.sqrt(inchX * inchX + inchY * inchY);
        dtext += String.format("inch=%2.2f\n", inch);

        ((TextView)findViewById(R.id.system_info)).setTextSize(20);
        ((TextView)findViewById(R.id.system_info)).setText(stext + dtext);
    }

    private String getGeneralizedDensity(int dpi) {
        switch (dpi) {
            default: return("mdpi");
            case DENSITY_LOW: return("ldpi");
            case DENSITY_MEDIUM: return("mdpi");
            case DENSITY_TV: return("tvdpi");
            case DENSITY_HIGH: return("hdpi");
            case DENSITY_280: return("DENSITY_280");
            case DENSITY_XHIGH: return("xhdpi");
            case DENSITY_360: return("DENSITY_360");
            case DENSITY_400: return("DENSITY_400");
            case DENSITY_420: return("DENSITY_420");
            case DENSITY_XXHIGH: return("xxhdpi");
            case DENSITY_560: return("DENSITY_560");
            case DENSITY_XXXHIGH: return("xxxhdpi");
        }
    }
}
