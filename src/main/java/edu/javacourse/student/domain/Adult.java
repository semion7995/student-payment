package edu.javacourse.student.domain;


import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public class Adult extends Person{

    private String passportSerial;
    private String passportNumber;
    private LocalDate issueDate;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private PassportOffice passportOffice;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private University university;


    private String studentNumber;


    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public PassportOffice getPassportOffice() {
        return passportOffice;
    }

    public void setPassportOffice(PassportOffice passportOffice) {
        this.passportOffice = passportOffice;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
