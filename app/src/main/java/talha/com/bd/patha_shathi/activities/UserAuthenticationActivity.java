
package talha.com.bd.patha_shathi.activities;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import androidx.appcompat.app.AlertDialog;
import talha.com.bd.patha_shathi.R;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class UserAuthenticationActivity extends AppCompatActivity {

    private static final String TAG = "UserAuthenticationActiv";
    Button regButton, loginButton, button;
    ImageView myLanguage;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        if ("bn".equalsIgnoreCase(loadLang())) {
            setTheme(R.style.Theme_Small);
        } else if ("en".equalsIgnoreCase(loadLang())) {
            setTheme(R.style.Theme_Large);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_authentication);

        myLanguage = findViewById(R.id.myLanguage);
        myLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showChangeLanguageDialog();

            }
        });

        regButton = findViewById(R.id.regButton);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regPageIntent = new Intent(UserAuthenticationActivity.this, UserRegisterActivity.class);
                startActivity(regPageIntent);
            }
        });

        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserAuthenticationActivity.this, UserLoginActivity.class);
                startActivity(intent);
            }
        });




    }

    private void showChangeLanguageDialog() {
        final String[] listItem = {"বাংলা", "English"};
        AlertDialog.Builder mBilder = new AlertDialog.Builder(UserAuthenticationActivity.this);
        mBilder.setTitle("Change language..");
        mBilder.setSingleChoiceItems(listItem, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int selectLanguage) {

                if (selectLanguage == 0) {
                    setLocale("bn", "BD", "AppThemeBangla");
                    Toast.makeText(UserAuthenticationActivity.this, loadLang(), Toast.LENGTH_LONG).show();
                    recreate();
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);


                } else if (selectLanguage == 1) {
                    setLocale("en", "EN", "AppThemeEnglish");
                    Toast.makeText(UserAuthenticationActivity.this, loadLang(), Toast.LENGTH_LONG).show();
                    recreate();
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);

                }
                dialog.dismiss();
            }
        });
        AlertDialog mDialog = mBilder.create();
        mDialog.show();
    }

    private void setLocale(String lang, String country, String fontFamily) {
        Locale locale = new Locale(lang, country);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("textViewStyle", fontFamily);  //setting custom fontFamily
        editor.putString("lang", lang);
        editor.putString("country", country);
        editor.apply();
    }

    public String loadLang() {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String lan = prefs.getString("lang", "");
        return lan;
    }
}
