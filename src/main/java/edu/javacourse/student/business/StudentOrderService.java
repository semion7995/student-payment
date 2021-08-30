package edu.javacourse.student.business;

import edu.javacourse.student.dao.*;
import edu.javacourse.student.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentOrderService {

    private static final Logger LOG = LoggerFactory.getLogger(StudentOrderService.class);


    @Autowired
    private StudentOrderRepository dao;
    @Autowired
    private StudentOrderChildRepository daoChild;

    @Autowired
    private StreetRepository daoStreet;
    @Autowired
    private PassportOfficeRepository daoPassportOffice;
    @Autowired
    private UniversityRepository daoUniversity;

    @Autowired
    private RegisterOfficeRepository daoRegisterOffice;
    @Autowired
    private StudentOrderStatusRepository daoStatus;

    @Transactional
    public void testSave() {
        StudentOrder so = new StudentOrder();
        so.setHusband(buildPerson(false));
        so.setWife(buildPerson(true));

        so.setStatus(daoStatus.getById(1l));
        so.setStudentOrderDateTime(LocalDateTime.now());
        so.setCertificateNumber("CERTIFICATE");
        so.setRegisterOffice(daoRegisterOffice.getById(1l));
        so.setMarriageDate(LocalDate.now());
        dao.save(so);
        StudentOrderChild soc = buildChild(so);
        daoChild.save(soc);

    }
    @Transactional
    public void testGet() {
        List<StudentOrder> sos = dao.findAll();
        LOG.info(sos.get(0).getWife().getGivenName());
        LOG.info(sos.get(0).getChildren().get(0).getGivenName());
    }

    private Adult buildPerson(boolean wife){
        Adult p = new Adult();
        p.setDateOfBirth(LocalDate.now());
        Address a = new Address();
        a.setPostCode("190000");
        a.setBuilding("21");
        a.setExtension("B");
        a.setApartment("199");
        Street byId = daoStreet.getById(1l);
        a.setStreet(byId);
        p.setAddress(a);
        if (wife){
            p.setSurName("Рюрик");
            p.setGivenName("Марфа");
            p.setPatronymic("Васильевна");
            p.setPassportSerial("WIFE_S");
            p.setPassportNumber("WIFE_N");
            p.setIssueDate(LocalDate.now());
            p.setPassportOffice(daoPassportOffice.getById(1l));
            p.setUniversity(daoUniversity.getById(1l));
            p.setStudentNumber("12345");
        }
        else{
            p.setSurName("Рюрик");
            p.setGivenName("Иван");
            p.setPatronymic("Васильевич");
            p.setPassportSerial("HUSBAND_S");
            p.setPassportNumber("HUSBAND_N");
            p.setIssueDate(LocalDate.now());
            p.setPassportOffice(daoPassportOffice.getById(1l));
            p.setUniversity(daoUniversity.getById(1l));
            p.setStudentNumber("67890");
        }

        return p;

    }
private StudentOrderChild buildChild(StudentOrder studentOrder){
        StudentOrderChild p = new StudentOrderChild();
        p.setStudentOrder(studentOrder);

        p.setDateOfBirth(LocalDate.now());
        Address a = new Address();
        a.setPostCode("190000");
        a.setBuilding("21");
        a.setExtension("B");
        a.setApartment("199");
        Street byId = daoStreet.getById(1l);
        a.setStreet(byId);
        p.setAddress(a);
    /**
     *     private StudentOrder studentOrder;

           private String certificateNumber;

           private LocalDate certificateDate;

     *     private RegisterOffice registerOffice;
     */

            p.setSurName("Рюрик");
            p.setGivenName("Дмитрий");
            p.setPatronymic("Иванович");
            p.setCertificateDate(LocalDate.now());
            p.setCertificateNumber("BIRTH N");
            p.setRegisterOffice(daoRegisterOffice.getById(1l));



        return p;

    }


}
