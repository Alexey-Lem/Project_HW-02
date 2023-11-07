
import comparators.StudentComparator;
import comparators.UniverComparator;
import enums.StudentEnum;
import enums.UniverEnum;
import Utils.StatUtil;
import Utils.UtilClass;
import org.example.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import static java.util.logging.Level.INFO;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {

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

        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        XmlWriter.generateXmlReq(fullInfo);
        JsonWriter.writeJsonReq(fullInfo);

        logger.log(INFO, "Application finished");
    }


}