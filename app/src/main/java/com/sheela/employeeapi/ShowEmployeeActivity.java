package com.sheela.employeeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.sheela.employeeapi.api.EmployeeAPI;
import com.sheela.employeeapi.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowEmployeeActivity extends AppCompatActivity {
  RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_employee);
       recyclerView=findViewById(R.id.recycleview);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        EmployeeAPI employeeAPI= retrofit.create(EmployeeAPI.class);
        Call<List<Employee>> listCall= employeeAPI.getAllEmployees();
        //enqueue means asynchronous
        listCall.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(ShowEmployeeActivity.this, "Code error"+ response.code(),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Employee> employeeList= response.body();
                EmployeeAdapter employeeAdapter= new EmployeeAdapter(getBaseContext(),employeeList);
                recyclerView.setAdapter(employeeAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
//                for(Employee employee:employeeList){
//                    String data= "";
//                    data += "Employee name :" + employee.getEmployee_name() + "\n";
//                    data += "Employee Salary :" + employee.getEmployee_salary() + "\n";
//                    data += "Employee age :" + employee.getEmployee_age() + "\n";
//                    data += ".......................";
//                    tvOutput.append(data);
//                }


            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.d("my message","onFailure:" + t.getLocalizedMessage());
                Toast.makeText(ShowEmployeeActivity.this,"Error" + t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
