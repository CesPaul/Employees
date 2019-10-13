package com.cespaul.employees.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.cespaul.employees.Converters;
import com.cespaul.employees.model.entities.Employee;
import com.cespaul.employees.model.entities.Experience;

@Database(entities = {Employee.class, Experience.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract EmployeeDao employeeDao();
}
