package com.cespaul.employees.model.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "employee")
public class Employee {

    @PrimaryKey
    public long id;

    public long number;

    public String name;

    public String surname;

    public String patronymic;

    public Date birthDate;

    public String gender;

    public int internship;

    public int briefings;

    public int certificationOt;

    public int certificationPb;

    public int preExaminer;

    public int physical;

    public int breathalyzer;

    public String disease;

    public Date dateOfAccidents;

    public String provision;

    public int disruptionsForYear;

    public int disruptionTotal;
}
