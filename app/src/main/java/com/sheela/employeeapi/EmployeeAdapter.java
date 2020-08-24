package com.sheela.employeeapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sheela.employeeapi.model.Employee;

import java.util.List;


public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {
    Context mContext;
    List<Employee> employeeList;

    public EmployeeAdapter(Context mContext, List<Employee> employeeList) {
        this.mContext = mContext;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_contacts, parent, false);
        return new EmployeeViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.NoId.setText(Integer.toString(employee.getId()));
        holder.txtName.setText(employee.getEmployee_name());
        holder.txtSalary.setText(Float.toString(employee.getEmployee_salary()));
        holder.txtAge.setText(Integer.toString(employee.getEmployee_age()));


    }
//


    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {


        TextView NoId, txtName, txtSalary, txtAge;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            NoId = itemView.findViewById(R.id.NoId);
            txtName = itemView.findViewById(R.id.txtName);
            txtSalary = itemView.findViewById(R.id.txtSalary);
            txtAge = itemView.findViewById(R.id.txtAge);


        }

    }
}
