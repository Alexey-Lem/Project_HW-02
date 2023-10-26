package org.example;

import Comparators.*;
import Enums.StudentEnum;
import Enums.UniverEnum;
import Utils.JsonUtil;
import Utils.StatUtil;
import Utils.UtilClass;

import java.util.List;
import java.io.IOException;


public class Main {
//    private static final Logger log = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
//------------------------------------------------------------------------------------------------------------------
//        По заданию 25.9 п.7 "Очищаем" код написанный до сих пор.
//        До сих пор еще все было более-менее понятно.
//------------------------------------------------------------------------------------------------------------------

//        try {
//            List<University> univer = XlsInput.readExcelUnivers("src/main/resources/universityInfo.xlsx");
//            UniverComparator univerComp = UtilClass.getUniverComparator(UniverEnum.fullName);
//            univer.stream()
//                    .sorted(univerComp)
//                    .forEach(System.out::println);
//                        }
//        catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            List<Student> std = XlsInput.readExcelStds("src/main/resources/universityInfo.xlsx");
//            StudentComparator studentComp = UtilClass.getStudentComparator(StudentEnum.fullName);
//            std.stream()
//                    .sorted(studentComp)
//                    .forEach(System.out::println);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

// ----------------------------------------------------------------------------------------------------------------
//        Это вставленный код, цельнотянутый, просто потому что нихера не понятно в постановке задачи:
//        п.7 - Очистить метод main от предыдущего кода. Вместо этого реализовать получение коллекций с использованием
//        написанного в п.4 класса, затем вывести в консоль все полученные элементы коллекций.
//        Что такое JSON - хер знает.
// ----------------------------------------------------------------------------------------------------------------

        List<University> universities = XlsInput.readExcelUnivers("src/main/resources/universityInfo.xlsx");
        UniverComparator univerComparator = UtilClass.getUniverComparator(UniverEnum.yearOfFoundation);
        universities.sort(univerComparator);
        String universitiesJson = JsonUtil.universityListToJson(universities);
        // проверяем, что json создан успешно
        System.out.println(universitiesJson);
        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        // проверяем, что обратно коллекция воссоздаётся в таком же количестве элементов
        System.out.println(universities.size() == universitiesFromJson.size());
        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            // проверяем, что json из отдельного элемента создан успешно
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            // проверяем, что обратно элемент воссоздаётся
            System.out.println(universityFromJson);
        });

        List<Student> students = XlsInput.readExcelStds("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = UtilClass.getStudentComparator(StudentEnum.avgExamScore);
        students.sort(studentComparator);
        String studentsJson = JsonUtil.studentListToJson(students);
        // проверяем, что json создан успешно
        System.out.println(studentsJson);
        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
        // проверяем, что обратно коллекция воссоздаётся в таком же количестве элементов
        System.out.println(students.size() == studentsFromJson.size());
        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            // проверяем, что json из отдельного элемента создан успешно
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            // проверяем, что обратно элемент воссоздаётся
            System.out.println(studentFromJson);
        });
// -------------------------------------------------------------------------------------------------------------------

        List<Statistics> statisticsList = StatUtil.createStatistics(students, universities);
        XlsOutput.TableGenerator(statisticsList, "src/main/resources/statistics.xlsx");
    }


}