package com.alevel.hometask.oop;

public class Group {
    private Student[] students;

    public Group(Student[] students) {
        this.students = students;
    }

    public void printContractorData() {
        for (Student student : students) {
            if (student instanceof ContractStudent) {
                System.out.println("Имя : " + student.getName() + System.lineSeparator() +
                        "Стоимость : " + ((ContractStudent) student).getValue());

            }
        }
    }
}
