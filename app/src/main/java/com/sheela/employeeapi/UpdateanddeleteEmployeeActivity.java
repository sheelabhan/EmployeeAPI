package com.sheela.employeeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sheela.employeeapi.api.EmployeeAPI;
import com.sheela.employeeapi.model.Employee;
import com.sheela.employeeapi.model.EmployeeCUD;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateanddeleteEmployeeActivity extends AppCompatActivity {
    private EditText etEnumber, etNumber, etSsalary, etNum;
    private Button btnSeearch, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateanddelete_employee);
        etEnumber = findViewById(R.id.etEnumber);
        etNumber = findViewById(R.id.etNumber);
        etSsalary = findViewById(R.id.etSsalary);
        etNum = findViewById(R.id.etNum);
        btnSeearch = findViewById(R.id.btnSeearch);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateEmployee();
            }
        });
        btnSeearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();

            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteEmployee();
            }
        });
    }


    private void loadData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);

        Call<Employee> listCall = employeeAPI.getEmployeeByID(Integer.parseInt(etEnumber.getText().toString()));
        listCall.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                etNumber.setText(response.body().getEmployee_name());
                etSsalary.setText(Float.toString(response.body().getEmployee_salary()));
                etNum.setText(Integer.toString(response.body().getEmployee_age()));

            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(UpdateanddeleteEmployeeActivity.this, "Error" + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateEmployee() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);
        EmployeeCUD employee = new EmployeeCUD(
                etNumber.getText().toString(),
                Float.parseFloat(etSsalary.getText().toString()),
                Integer.parseInt(etNum.getText().toString())
        );
        Call<Void> voidCall = employeeAPI.updateEmployee(Integer.parseInt(etEnumber.getText().toString()), employee);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(UpdateanddeleteEmployeeActivity.this, "updated", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(UpdateanddeleteEmployeeActivity.this, "Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteEmployee() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);

        Call<Void> voidCall = employeeAPI.deleteEmployee(Integer.parseInt(etEnumber.getText().toString()));
        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(UpdateanddeleteEmployeeActivity.this, "successfully deleted", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
            Toast.makeText(UpdateanddeleteEmployeeActivity.this,"Error"
                    +t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}





