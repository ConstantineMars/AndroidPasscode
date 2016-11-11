package cmars.androidpasscode;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.nightonke.blurlockview.BlurLockView;
import com.nightonke.blurlockview.Directions.HideType;
import com.nightonke.blurlockview.Eases.EaseType;
import com.nightonke.blurlockview.Password;

public class MainActivity extends AppCompatActivity implements BlurLockView.OnPasswordInputListener, BlurLockView.OnLeftButtonClickListener {

    BlurLockView blurLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        blurLockView = (BlurLockView) findViewById(R.id.blurlockview);

        // Set the view that need to be blurred
        blurLockView.setBlurredView(imageView);

        // Set the password
        blurLockView.setPasswordLength(4);
        blurLockView.setCorrectPassword("1234");

        blurLockView.setType(Password.NUMBER, true);

        blurLockView.setLeftButton("Options");
        blurLockView.setRightButton("Backspace");

        blurLockView.setOnPasswordInputListener(this);
    }

    @Override
    public void correct(String inputPassword) {
        Log.d(MainActivity.class.getName(), String.format("correct: %s", inputPassword));
        blurLockView.hide(1000, HideType.FADE_OUT, EaseType.EaseInBack);
    }

    @Override
    public void incorrect(String inputPassword) {
        Log.d(MainActivity.class.getName(), String.format("incorrect: %s", inputPassword));
    }

    @Override
    public void input(String inputPassword) {
        Log.d(MainActivity.class.getName(), String.format("input: %s", inputPassword));
    }

    @Override
    public void onClick() {
        Log.d(MainActivity.class.getName(), String.format("left clicked"));
    }
}
