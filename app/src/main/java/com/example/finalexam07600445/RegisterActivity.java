package com.example.finalexam07600445;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button RegisButton = findViewById(R.id.register_button);
        RegisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText fullnameRegisEditText = findViewById(R.id.full_name_edit_text);
                String fullname = fullnameRegisEditText.getText().toString();

                EditText userRegisEditText = findViewById(R.id.username_edit_text);
                String userRegis = userRegisEditText.getText().toString();

                EditText passRegisEditText = findViewById(R.id.password_edit_text);
                String passRegis = passRegisEditText.getText().toString();

                regisitem item = new regisitem(fullname, userRegis , passRegis);

                RegisterRepository repo = new RegisterRepository(RegisterActivity.this);
                repo.insertRegister(item, new RegisterRepository.InsertCallback() {
                    @Override
                    public void onInsertSuccess() {
                        Toast.makeText(
                                RegisterActivity.this,
                                "Register successfully",
                                Toast.LENGTH_SHORT
                        ).show();
                        finish();
                    }
                });

            }
        });


    }
}
    }
}
