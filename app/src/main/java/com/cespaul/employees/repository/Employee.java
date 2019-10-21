package com.cespaul.employees.repository;

import android.service.autofill.FillEventHistory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Employee{
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    public String number;
    public String name;
    public String surname;
    public String patronymic;
    public String birthDate;
    public String gender;
    public String position;
    public String jobEvaluation;
    public String currentExperience;
    public String totalExperience;
    public String training;
    public String briefings;
    public String certificationOt;
    public String certificationPb;
    public String preExaminer;
    public String physical;
    public String breathalyzer;
    public String disease;
    public String dateOfAccidents;
    public String expOfAccidents;
    public String provision;
    public String disruptionsForYear;
    public String disruptionTotal;

    private Date date;

    public Employee() {
        this.number = "2914495";
        this.name = "Иван";
        this.surname = "Иванов";
        this.patronymic = "Иванович";
        /*try {
            date = format.parse("10.05.1997");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        this.birthDate = "01.10.1991";
        this.gender = "муж.";
        this.position = "ГРОЗ";
        this.jobEvaluation = "IV";
        this.currentExperience = 7 + " лет";
        this.totalExperience = 13 + " лет";
        this.training = 100 + "%";
        this.briefings = 100 + "%";
        this.certificationOt = 60 + " дн.";
        this.certificationPb = 60 + " дн.";
        this.preExaminer = 83 + "%";
        this.physical = 23 + " дн.";
        this.breathalyzer = 100 + "%";
        this.disease = "пнемокониоз";
        this.dateOfAccidents = "Дата: 12.10.2010";
        this.expOfAccidents = "Стаж работы: " + 5 + "лет";
        this.provision = "Очки, наушники";
        this.disruptionsForYear = 16 + "";
        this.disruptionTotal = 125 + "";
    }

}
