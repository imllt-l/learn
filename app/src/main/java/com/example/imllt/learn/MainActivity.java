package com.example.imllt.learn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //声明变量
    private Button Login;
    private Button turnButton;
    private SharedPreferences.Editor editor;
    private SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //初始化变量
        final EditText userName = (EditText) findViewById(R.id.Username);
        final EditText password = (EditText) findViewById(R.id.Password);

        //监听按键并将文本存入数据库
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String Account = userName.getText().toString();
              String Password = password.getText().toString();
              String N = pref.getString("Name","");
              String P = pref.getString("Password","");
              userName.setText(N);
              password.setText(P);
              //判断密码
              if(Account.equals(N)&&Password.equals(P)){
                  Toast toast = Toast.makeText(getApplicationContext(),"成功登陆",Toast.LENGTH_SHORT);
                  toast.show();
                    Intent intent = new Intent(MainActivity.this,FirstActivity.class);
                  startActivity(intent);
              }
              else {
                  Toast toast = Toast.makeText(getApplicationContext(),"登入失败",Toast.LENGTH_SHORT);
                  toast.show();
              }
            }
        });
        turnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TrunToActivity.class);
                startActivity(intent);
            }
        });

    }
    //初始化按键与输入文本
    private void init(){
        turnButton = (Button)findViewById(R.id.SetUp);
        Login = (Button)findViewById(R.id.Login);
        pref= getSharedPreferences("UserData",MODE_PRIVATE);
    }
}

