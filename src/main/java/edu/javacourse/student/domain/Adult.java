package edu.javacourse.student.domain;


import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public class Adult extends Person{

    private String passportSerial;
    private String passportNumber;
    private LocalDate issueDate;

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
}
