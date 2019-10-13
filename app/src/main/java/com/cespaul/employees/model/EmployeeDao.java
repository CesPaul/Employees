package com.cespaul.employees.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cespaul.employees.model.entities.Employee;
import com.cespaul.employees.model.entities.EmployeeInfo;

@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM employee")
    EmployeeInfo getAll();

    @Query("SELECT * FROM employee WHERE id = :id")
    Employee getById(long id);

    @Insert
    void insert(Employee employee);

    @Update
    void update(Employee employee);

    @Delete
    void delete(Employee employee);
}
