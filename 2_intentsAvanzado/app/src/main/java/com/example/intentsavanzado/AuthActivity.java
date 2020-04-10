package com.example.intentsavanzado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.UUID;

public class AuthActivity extends AppCompatActivity {

    private TextView idUSer;
    private EditText nameUSer;
    private Button authUser;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        idUSer = findViewById(R.id.idUser);
        nameUSer = findViewById(R.id.nameUser);
        authUser = findViewById(R.id.authUser);

        idUSer.setText(UUID.randomUUID().toString());

        Serializable serializable = getIntent().getExtras().getSerializable("user");

        if (serializable == null){
            idUSer.setText(UUID.randomUUID().toString());
        }else{
            user = (User) serializable;
            idUSer.setText(user.getId());
            nameUSer.setText(user.getName());
        }


        authUser.setOnClickListener(

                (v)->{
                    User user = new User(idUSer.getText().toString(),nameUSer.getText().toString());
                    Intent i = new Intent();
                    i.putExtra("user",user);
                    setResult(RESULT_OK, i);
                    finish();
                }
        );
    }
}
