package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.*;
import java.util.*;
public class Excel_Input {
    private Excel_Input() {
    }

    public static List<University> readExcelUnivers(String filePath) throws IOException {

        List<University> univer = new ArrayList<>();

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

        return univer;
    }

    public static List<Student> readExcelStds(String filePath) throws IOException {

        List<Student> students = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook wrkb = new XSSFWorkbook(inputStream);
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

        return students;
    }
}
