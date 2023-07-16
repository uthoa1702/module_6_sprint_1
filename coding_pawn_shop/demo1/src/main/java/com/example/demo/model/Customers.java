package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String birthday;
    private int gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String citizenCode;
    private String image;
    private String frontCitizen;
    private String backCitizen;
    private String quantityContract;
    @Column(name = "create_date", columnDefinition = "DATETIME DEFAULT now()", updatable = false)
    private LocalDateTime createDate;
    @Column(name = "update_date", columnDefinition = "DATETIME DEFAULT now()", updatable = true)
    private LocalDateTime updateDate;
    private boolean isDelete;
    @Column(name = "note", columnDefinition = "text")
    private String note;

    public Customers() {
    }

    public Customers(Long id, String name, String birthday, int gender, String phoneNumber, String email, String address, String citizenCode, String image, String frontCitizen, String backCitizen, String quantityContract, LocalDateTime createDate, LocalDateTime updateDate, boolean isDelete, String note) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.citizenCode = citizenCode;
        this.image = image;
        this.frontCitizen = frontCitizen;
        this.backCitizen = backCitizen;
        this.quantityContract = quantityContract;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isDelete = isDelete;
        this.note = note;
    }

    public Customers(Long id, String name, String birthday, int gender, String phoneNumber, String email, String address, String citizenCode, String image, String frondCitizen, String backCitizen, String quantityContract, LocalDateTime createDate, LocalDateTime updateDate, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.citizenCode = citizenCode;
        this.image = image;
        this.frontCitizen = frondCitizen;
        this.backCitizen = backCitizen;
        this.quantityContract = quantityContract;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isDelete = isDelete;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCitizenCode() {
        return citizenCode;
    }

    public void setCitizenCode(String citizenCode) {
        this.citizenCode = citizenCode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFrontCitizen() {
        return frontCitizen;
    }

    public void setFrontCitizen(String frontCitizen) {
        this.frontCitizen = frontCitizen;
    }

    public String getBackCitizen() {
        return backCitizen;
    }

    public void setBackCitizen(String backCitizen) {
        this.backCitizen = backCitizen;
    }

    public String getQuantityContract() {
        return quantityContract;
    }

    public void setQuantityContract(String quantityContract) {
        this.quantityContract = quantityContract;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
