package com.sheela.employeeapi.api;

import com.sheela.employeeapi.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeAPI {
    @GET("employees")
    Call<List<Employee>> getAllEmployees();

}
