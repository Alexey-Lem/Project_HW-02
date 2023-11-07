package org.example;


import enums.StudyProfile;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class XlsInput {
    private XlsInput() {
    }
    private static final Logger logger = Logger.getLogger(XlsInput.class.getName());
    public static List<University> readExcelUnivers(String filePath) throws IOException {

        List<University> univer = new ArrayList<>();

        try {
            logger.log(Level.INFO, "Excel reading started");
            FileInputStream input = new FileInputStream(filePath);
            XSSFWorkbook wrkb = new XSSFWorkbook(input);
            XSSFSheet sheet = wrkb.getSheet("Университеты");

            Iterator<Row> rw = sheet.iterator();
            rw.next();

            while (rw.hasNext()) {
                Row crw = rw.next();
                University university = new University();
                univer.add(university);
                university.setId(crw.getCell(0).getStringCellValue());
                university.setFullName(crw.getCell(1).getStringCellValue());
                university.setShortName(crw.getCell(2).getStringCellValue());
                university.setYearOfFoundation((int)crw.getCell(3).getNumericCellValue());
                university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, crw.getCell(4).getStringCellValue()));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Excel reading failed", e);
            return univer;
        }

        return univer;
    }

    public static List<Student> readExcelStds(String filePath) throws IOException {

        List<Student> students = new ArrayList<>();

        try {
            logger.log(Level.INFO, "Excel reading started");
            FileInputStream input = new FileInputStream(filePath);
            XSSFWorkbook wrkb = new XSSFWorkbook(input);
            XSSFSheet sheet = wrkb.getSheet("Студенты");

            Iterator<Row> rw = sheet.iterator();
            rw.next();

            while (rw.hasNext()) {
                Row crw = rw.next();
                Student student = new Student();
                students.add(student);
                student.setUniversityId(crw.getCell(0).getStringCellValue());
                student.setFullName(crw.getCell(1).getStringCellValue());
                student.setCurrentCourseNumber((int)crw.getCell(2).getNumericCellValue());
                student.setAvgExamScore((float)crw.getCell(3).getNumericCellValue());
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Excel reading failed", e);
            return students;
        }

        return students;
    }
}
