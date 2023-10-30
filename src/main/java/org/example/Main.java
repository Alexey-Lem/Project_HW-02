package org.example;

import comparators.*;
import enums.StudentEnum;
import enums.UniverEnum;
import Utils.JsonUtil;
import Utils.StatUtil;
import Utils.UtilClass;
import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import static java.util.logging.Level.INFO;


public class Main {
//    private static final Logger log = LogManager.getLogger(Main.class.getName());
    private static final Logger logger = Logger.getLogger(Main.class.getName());

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
        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        logger.log(INFO, "Application started, Logger configured");

        List<University> universities = XlsInput.readExcelUnivers("src/main/resources/universityInfo.xlsx");
        UniverComparator univerComparator = UtilClass.getUniverComparator(UniverEnum.yearOfFoundation);
        universities.sort(univerComparator);

        List<Student> students = XlsInput.readExcelStds("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = UtilClass.getStudentComparator(StudentEnum.avgExamScore);
        students.sort(studentComparator);

        List<Statistics> statisticsList = StatUtil.createStatistics(students, universities);
        XlsOutput.TableGenerator(statisticsList, "src/main/resources/statistics.xlsx");
    }


}