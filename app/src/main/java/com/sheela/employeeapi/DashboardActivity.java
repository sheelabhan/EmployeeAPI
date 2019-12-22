package com.sheela.employeeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {
 private Button btnSEmploye, btnREmployee, btnSSEmployee, btnUDEmployee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btnSEmploye=findViewById(R.id.btnSEmployee);
        btnREmployee=findViewById(R.id.btnREmployee);
        btnSSEmployee=findViewById(R.id.btnSSEmployee);
        btnUDEmployee=findViewById(R.id.btnUDEmployee);
        btnSEmploye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DashboardActivity.this, ShowEmployeeActivity.class);
                startActivity(intent);
            }
        });
        btnREmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DashboardActivity.this, RegisterEmployeeActivity.class);
                startActivity(intent);
            }
        });
        btnSSEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DashboardActivity.this, SearchEmployeeActivity.class);
                startActivity(intent);
            }
        });
        btnUDEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DashboardActivity.this, UpdateanddeleteEmployeeActivity.class);
                startActivity(intent);
            }
        });
    }
}
