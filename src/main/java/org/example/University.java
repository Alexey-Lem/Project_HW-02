package org.example;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

public class University {
    @SerializedName("universityId")
    String id;
    @SerializedName("universityName")
    String fullName;
    @SerializedName("universityShortName")
    String shortName;
    @SerializedName("foundation")
    int yearOfFoundation;
    @SerializedName("profile")
    StudyProfile mainProfile;

    public University() {
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }


    public String getId() {
        return id;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return "Идентификатор: "+ id +",\tПолное название: " + fullName+ "\tСокр.название: " + shortName +
                ",\tДата основания: "+ yearOfFoundation + ",\tНаправление: " + getMainProfile();
    }
}
