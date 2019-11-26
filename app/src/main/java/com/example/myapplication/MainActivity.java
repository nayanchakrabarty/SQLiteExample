package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.db.UsersDb;

public class MainActivity extends AppCompatActivity {

    EditText eTname, eTpass;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTname = findViewById(R.id.eTuserName);
        eTpass = findViewById(R.id.eTPassward);

        save = findViewById(R.id.btnSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName, strPwd;
                strName = eTname.getText().toString();
                strPwd = eTpass.getText().toString();

                if (strName.isEmpty() || strPwd.isEmpty()){
                    Toast.makeText(MainActivity.this, "Field is empty", Toast.LENGTH_SHORT).show();
                } else {
                    UsersDb usersDb = new UsersDb(getApplicationContext());
                    UsersModel usersModel = new UsersModel();

                    usersModel.username = strName;
                    usersModel.password = strPwd;

                    usersDb.insertUser(usersModel);

                    Toast.makeText(getApplicationContext(),"Save", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
