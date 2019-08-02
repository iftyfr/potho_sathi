package talha.com.bd.patha_shathi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import talha.com.bd.patha_shathi.R;


public class StartAppActivity extends AppCompatActivity {

    private TextView textTV, textTV1;
    private ImageView imageIV;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app);
        textTV = findViewById(R.id.title_id);
        textTV1=findViewById(R.id.title_id1);

        imageIV = findViewById(R.id.logo_id);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytrasition);
        textTV.startAnimation(myanim);
        textTV1.startAnimation(myanim);

        imageIV.startAnimation(myanim);


        handler = new Handler();

        handler.postDelayed(new Runnable() {

            @Override

            public void run() {

                Intent intent = new Intent(StartAppActivity.this,UserAuthenticationActivity.class);

                startActivity(intent);

                finish();

            }

        },4000);

    }

}
