package com.example.localstorage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localstorage.prefs.Prefs;

public class MainActivity extends AppCompatActivity {
    EditText edtName,edtUserName;
    Button btnSave,btnGet;
    TextView txtSavedMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName=findViewById(R.id.edtName);
        edtUserName=findViewById(R.id.edtUserName);
        btnGet=findViewById(R.id.btnGet);
        btnSave=findViewById(R.id.btnSave);
        txtSavedMsg=findViewById(R.id.txtsavedmsg);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidation();

            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData();
            }
        });
    }

    void checkValidation() {
        if (edtName.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter Name",Toast.LENGTH_SHORT).show();
        }
        else if (edtUserName.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter UserName",Toast.LENGTH_SHORT).show();

        }
        else {
           saveData();
        }
    }
    private void saveData(){
        Prefs.saveEmployeeName(MainActivity.this,edtName.getText().toString());
        Prefs.saveEmployeeUserName(MainActivity.this,edtUserName.getText().toString());

    }

    private void showData(){
        txtSavedMsg.setText(
            Prefs.getEmployeeName(MainActivity.this)+"\n"+
                    Prefs.getEmployeeUsernameName(MainActivity.this)
    );
        }

    }

