package com.example.finalexam07600445;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.finalexam07600445.R;
import com.example.finalexam07600445.RegisterActivity;

import th.ac.su.sc.finalexam07600659.Operations.Operation;
import th.ac.su.sc.finalexam07600659.Operations.bad;
import th.ac.su.sc.finalexam07600659.Operations.good;
import th.ac.su.sc.finalexam07600659.Operations.mid;

//import static th.ac.su.sc.finalexam07600659.R.id.register_button;
import static th.ac.su.sc.finalexam07600659.R.id.username_edit_text;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private Button register;
    private static final Operation[] operation={new good(),new mid(),new bad()};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.username_edit_text);
        password = (EditText) findViewById(R.id.password_edit_text);
        login = (Button) findViewById(R.id.login_button);
        register=(Button) findViewById(R.id.register_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, RegisterActivity.class);
                // intent.putExtra("Register a New Account",0);
                //  intent.
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = username.getText().toString();
                String str1 = password.getText().toString();
                login.clearComposingText();
                if (findlogin(str, str1)) {
                    //  if(username.getFreezesText() && password.getFreezesText() ){
                    print();



                    username.clearComposingText();
                    password.clearComposingText();
                }else if(findlogin(str,str1)){
                    if(!username.getFreezesText() && !password.getFreezesText()){
                        new AlertDialog.Builder(MainActivity.this).setMessage("Invalid username or password ").show();
                    }
                }
                else {
                    new AlertDialog.Builder(MainActivity.this).setMessage("All fields are required ").show();
                    // printt();;
                }
            }
        });
    }


    public boolean findlogin(String str, String str1) {
        for(int i=0;i<operation.length;i++){
            if(str.length()>0 && str1.length()>0){
                return true;
            }else if(str.length()>0 || str1.length()>0){
                return true;
            }
        }
       /* if (username.getFreezesText() && password.getFreezesText()) {
            return true;
        }else {
          return   false;
        }*/

        return false;
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        // new AlertDialog.Builder(this).setTitle("Welcome").setMessage(builder.toString()).show();

        if(username.length()>0 && password.length()>0) {
            new AlertDialog.Builder(this).setTitle("Welcome").setMessage(username.getText()).show();
        }else if(username.length()>0 || password.length()>0) {
            new AlertDialog.Builder(this).setMessage("Invalid username or password ").show();
        }

    }
  /*  public void printt(){
        StringBuilder builder = new StringBuilder();
        new AlertDialog.Builder(this).setTitle("All fields are required").show();
    }*/
}