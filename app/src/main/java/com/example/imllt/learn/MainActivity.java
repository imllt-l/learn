package com.example.imllt.learn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button Login;
    private Button turnButton;
    private CheckBox Rember;
    private  SharedPreferences.Editor editor;
    private  SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        final EditText userName = (EditText) findViewById(R.id.Username);
        final EditText password = (EditText) findViewById(R.id.Password);
        boolean isRember = pref.getBoolean("Rember_Password",false);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String Account = userName.getText().toString();
              String Password = password.getText().toString();
              String N = pref.getString("Name","");
              String P = pref.getString("Password","");
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
    private void init(){
        turnButton = (Button)findViewById(R.id.SetUp);
        Login = (Button)findViewById(R.id.Login);
        Rember = (CheckBox)findViewById(R.id.Rember);
        pref= getSharedPreferences("UserData",MODE_PRIVATE);
//        ImageView unameClear = (ImageView) findViewById(R.id.Clear);
//        ImageView pwdClear = (ImageView) findViewById(R.id.Clear);
//        EditTextClearTools.addClearListener(userName,unameClear);
//        EditTextClearTools.addClearListener(password,pwdClear);
    }
}

