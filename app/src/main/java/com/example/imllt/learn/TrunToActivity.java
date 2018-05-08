package com.example.imllt.learn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TrunToActivity extends AppCompatActivity {
    private  EditText userName;
    private  EditText password;
    private  Button IntentBtn;
    private  SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trun_to);
        userName = (EditText) findViewById(R.id.ZUsername);
        password = (EditText) findViewById(R.id.ZPassword);
        IntentBtn = (Button)findViewById(R.id.ComfirmBtn);

        IntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UnameData = userName.getText().toString();
                String UpwData = password.getText().toString();
                editor = getSharedPreferences("UserData",MODE_PRIVATE).edit();
                editor.putString("Name",UnameData);
                editor.putString("Password",UpwData);
                editor.apply();
                Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TrunToActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }

}
