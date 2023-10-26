package org.example;

public class Statistics {
    String studyProfile;
    float avgExamScore;
    int profileStudentCount;
    int profileUniverCount;
    String univerName;

    public Statistics() {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.profileStudentCount = profileStudentCount;
        this.profileUniverCount = profileUniverCount;
        this.univerName = univerName;
    }

    public String getStudyProfile() {
        return studyProfile;
    }

    public Statistics setStudyProfile(String studyProfile) {
        this.studyProfile = studyProfile;
        return this;
    }

    public double getAvgExamScore() {
        return avgExamScore;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public int getProfileStudentCount() {
        return profileStudentCount;
    }

    public Statistics setProfileStudentCount(int profileStudentCount) {
        this.profileStudentCount = profileStudentCount;
        return this;
    }

    public int getProfileUniverCount() {
        return profileUniverCount;
    }

    public Statistics setProfileUniverCount(int profileUniverCount) {
        this.profileUniverCount = profileUniverCount;
        return this;
    }

    public String getUniverName() {
        return univerName;
    }

    public Statistics setUniverName(String univerName) {
        this.univerName = univerName;
        return this;
    }
}
