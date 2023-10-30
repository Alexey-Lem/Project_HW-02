package Utils;

import comparators.*;
import comparators.StudentUniversityIdComparator;
import enums.StudentEnum;
import enums.UniverEnum;

public class UtilClass {
    public UtilClass() {
    }


    public static UniverComparator getUniverComparator(UniverEnum univEnum){
        UniverComparator result = null;
        switch (univEnum) {
            case id:
                result = new UniverIdComparator();
                break;
            case fullName:
                result = new UniverFullNameComparator();
                break;
            case shortName:
                result = new UniverShortNameComparator();
                break;
            case yearOfFoundation:
                result = new UniverYearOfFoundationComparator();
                break;
            case mainProfile:
                result = new UniverMainProfileComparator();
                break;
        }
        return result;
    }
    public static StudentComparator getStudentComparator(StudentEnum stdEnum){
        StudentComparator result = null;
        switch (stdEnum) {
            case universityId:
                result = new StudentUniversityIdComparator();
                break;
            case fullName:
                result = new StudentFullNameComparator();
                break;
            case currentCourseNumber:
                result = new StudentCurrentCourseNumberComparator();
                break;
            case avgExamScore:
                result = new StudentAvgExamScoreComparator();
                break;
        }
        return result;
    }
}
