package com.sheela.employeeapi.api;

import com.sheela.employeeapi.model.Employee;
import com.sheela.employeeapi.model.EmployeeCUD;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmployeeAPI {
    @GET("employees")
    Call<List<Employee>> getAllEmployees();
    //GET employee on basis of EmpID
    @GET("employee/{empID}")
    Call<Employee> getEmployeeByID(@Path("empID") int empId);
    @POST("create")
    Call<Void>registerEmployee(@Body EmployeeCUD emp);
    //update Employee
    @PUT("update/{empID}")
    Call<Void>updateEmployee(@Path("empID") int empID, @Body EmployeeCUD emp);
    //delete
    @DELETE("delete/{empID}")
    Call<Void> deleteEmployee(@Path("empID")int empID);

}
