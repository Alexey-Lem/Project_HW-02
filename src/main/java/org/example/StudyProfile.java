package org.example;

public enum StudyProfile {
    MEDICINE("Медицина"),
    ECONOMY("Экономика"),
    FINANCE("Финансы"),
    SCIENCE("Наука"),
    ENGiNEERING("Инженерия");

    private String profile;

    StudyProfile(String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }

    public StudyProfile setProfile(String profile) {
        this.profile = profile;
        return this;
    }

    @Override
    public String toString() {
        return  profile;
    }
}
