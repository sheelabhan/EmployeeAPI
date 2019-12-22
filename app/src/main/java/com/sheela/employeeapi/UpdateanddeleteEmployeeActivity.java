package com.sheela.employeeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateanddeleteEmployeeActivity extends AppCompatActivity implements View.OnClickListener {
  private EditText etEnumber, etNaame, etSsalary, etAgge;
  private Button btnSeearch, btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateanddelete_employee);
        etEnumber=findViewById(R.id.etEnumber);
        etNaame=findViewById(R.id.etNaame);
        etSsalary=findViewById(R.id.etSsalary);
        btnSeearch=findViewById(R.id.btnSeearch);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(this);
        btnSeearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
