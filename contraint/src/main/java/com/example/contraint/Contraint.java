package com.example.contraint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import com.example.constraint.R;

public class Contraint extends AppCompatActivity {

    EditText edtUsename,edPassword;

    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contraint);
        edtUsename=findViewById(R.id.edUsename);
        edPassword=findViewById(R.id.edPassword);
        btn1=findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle=new Bundle();
                bundle.putString("callFrom","Registration");

                Intent intent=new Intent(Contraint.this,Registration.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        

    }

    }

