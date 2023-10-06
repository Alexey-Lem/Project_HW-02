package org.example;

import static org.example.StudyProfile.*;

public class Main {
    public static void main(String[] args) {

        University univ1 = new University("CMU","City Main Univerity","Main Univer",5, MEDICINE);
        Student std1 = new Student("Петров А.П.", "1",2, 3.56F);

        System.out.println(univ1);
        System.out.println(std1);
    }


}