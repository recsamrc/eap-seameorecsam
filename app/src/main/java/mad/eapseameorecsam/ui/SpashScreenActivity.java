package mad.eapseameorecsam.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.concurrent.TimeUnit;

import mad.eapseameorecsam.R;

public class SpashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);

        SimpleDraweeView img = findViewById(R.id.splash_image);
        img.setImageURI(Uri.parse("https://upload.wikimedia.org/wikipedia/commons/c/c9/Online-shop_button.jpg"));

    }

    @Override
    protected void onResume() {
        super.onResume();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        startActivity(new Intent(this, MainActivity.class));
        finish();

    }
}