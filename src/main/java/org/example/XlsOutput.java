package org.example;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsOutput {

    public static void TableGenerator(List<Statistics> statList, String path) throws IOException {

        XSSFWorkbook wrkb = new XSSFWorkbook();
        XSSFSheet statisticsSheet = wrkb.createSheet("Статистика");

        Font headerFont = wrkb.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        CellStyle headerStyle = wrkb.createCellStyle();

        headerStyle.setFont(headerFont);

        int rw = 0;
        Row hRow = statisticsSheet.createRow(rw++);

        Cell studyProfile = hRow.createCell(0);
        studyProfile.setCellValue("Профиль обучения");
        studyProfile.setCellStyle(headerStyle);

        Cell avgExamScore = hRow.createCell(1);
        avgExamScore.setCellValue("Средний балл за экзамены по профилю");
        avgExamScore.setCellStyle(headerStyle);

        Cell profileStudentCount = hRow.createCell(2);
        profileStudentCount.setCellValue("Количество студентов по профилю");
        profileStudentCount.setCellStyle(headerStyle);

        Cell profileUniverCount = hRow.createCell(3);
        profileUniverCount.setCellValue("Количество университетов по профилю");
        profileUniverCount.setCellStyle(headerStyle);

        Cell univerName = hRow.createCell(4);
        univerName.setCellValue("Университеты");
        univerName.setCellStyle(headerStyle);

        for (Statistics statistics : statList) {

            Row crw = statisticsSheet.createRow(rw++);
            Cell profileCell = crw.createCell(0);
            profileCell.setCellValue(statistics.getStudyProfile()); //.getProfileName()

            Cell avgScoreCell = crw.createCell(1);
            avgScoreCell.setCellValue(statistics.getAvgExamScore());

            Cell numberOfStudentsCell = crw.createCell(2);
            numberOfStudentsCell.setCellValue(statistics.getProfileStudentCount());

            Cell numberOfUniversitiesCell = crw.createCell(3);
            numberOfUniversitiesCell.setCellValue(statistics.getProfileUniverCount());

            Cell universitiesCell = crw.createCell(4);
            universitiesCell.setCellValue(statistics.getUniverName());
        }

        try (FileOutputStream outputStream = new FileOutputStream(path)) {
            wrkb.write(outputStream);
        }
    }
}
