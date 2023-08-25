package com.sms.studentManagementSystem.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column
    private String studentName;

    @Column
    private Integer studentNumber;

    @Column
    private Date dateOfBirth;

    @Column
    private String gender;

    @Column
    private Date startingDate;

    @Column
    private Date leavingDate;

    @Column
    private String address;

//    @OneToOne
//    private Category category;
//
//    @ManyToMany
//    @JoinTable(name = "STUDENT_CONTACT",
//            joinColumns = @JoinColumn(name="STUDENT_ID"),
//            inverseJoinColumns = @JoinColumn(name = "CONTACT_ID"))
//    private List<Contact> contacts = new ArrayList<>();

    public Student() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(Date leavingDate) {
        this.leavingDate = leavingDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}