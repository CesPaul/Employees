package com.cespaul.employees.model.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "exp")
public class Experience {

    @PrimaryKey
    public long expId;

    public String position;

    public String jobEvaluation;

    public Date dateOfAcceptance;

    public int experience;

    @ColumnInfo(name = "employeeId")
    public long employeeId;

}
