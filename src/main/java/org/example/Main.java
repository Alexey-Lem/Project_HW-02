package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.io.IOException;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

//        University univ1 = new University("CMU","City Main Univerity","Main Univer",5, MEDICINE);
//        Student std1 = new Student("Петров А.П.", "1",2, 3.56F);
//
//        System.out.println(univ1);
//        System.out.println(std1);

        try {
            List<University> univer = Excel_Input.readExcelUnivers("src/main/resources/universityInfo.xlsx");
            for (University university : univer) {
                System.out.println(university);
                log.info(university);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            List<Student> std = Excel_Input.readExcelStds("src/main/resources/universityInfo.xlsx");
            for (Student student : std) {
                System.out.println(student);
                log.info(student);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}