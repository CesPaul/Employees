package com.cespaul.employees.model.entities;

import java.util.GregorianCalendar;

public class ExperienceInfo {
    // Опыт работы (2я ЭФ)
    public String position;

    public enum jobEvaluation{
        II,
        III,
        IV
    }

    public GregorianCalendar dateOfAcceptance;

    public int experience;
}
