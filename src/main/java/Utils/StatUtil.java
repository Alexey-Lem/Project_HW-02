package Utils;

import org.apache.commons.lang3.StringUtils;
import org.example.Statistics;
import org.example.Student;
import enums.StudyProfile;
import org.example.University;

import java.math.*;
//import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
//import java.util.List;
//import java.util.OptionalDouble;
//import java.util.Set;
//import java.util.stream.Collectors;

public class StatUtil {

    public static List<Statistics> createStatistics(List<Student> students,
                                                    List<University> univers) {

        List<Statistics> statList = new ArrayList<>();

//      Нихера не понял из задания.
//      Пришлось все тиснуть и адаптировать
//
        Set<StudyProfile> profiles = univers.stream()  //Почему  stream ?
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statList.add(statistics);
            statistics.setStudyProfile(String.valueOf(profile));

            List<String> profileUniversityIds = univers.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setProfileUniverCount(profileUniversityIds.size());
            statistics.setUniverName(StringUtils.EMPTY);
            univers.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setUniverName(
                            statistics.getUniverName() + fullNameUniversity + ";"));

            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setProfileStudentCount(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });

        return statList;
    }
}
