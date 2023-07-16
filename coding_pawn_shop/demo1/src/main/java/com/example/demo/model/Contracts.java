package com.example.demo.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table()
public class Contracts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( columnDefinition = "VARCHAR(250)")
    private String productName;
    @Column( columnDefinition = "VARCHAR(250)")
    private String contractCode;
    private Long loans;
    private Long profit;
    @Column( columnDefinition = "TEXT")
    private String image;
    @Column( columnDefinition = "VARCHAR(25)")
    private String startDate;
    @Column( columnDefinition = "VARCHAR(25)")
    private String endDate;
    @Column( columnDefinition = "DATETIME DEFAULT now()", updatable = false)
    @CreationTimestamp
    private LocalDateTime createDate;
    @Column( columnDefinition = "DATETIME DEFAULT now()", updatable = true)
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @Column( columnDefinition = "BIT DEFAULT 0")
    private boolean isDelete;
    @ManyToOne
    @JoinColumn
    private ProductType productType;
    @ManyToOne
    @JoinColumn
    private Customers customers;
    @ManyToOne
    @JoinColumn
    private ContractStatus contractStatus;
    @ManyToOne
    @JoinColumn
    private Employees employees;
    @ManyToOne
    @JoinColumn
    private ContractType contractType;


    public Contracts(){
    }

    public Contracts(Long id) {
        this.id = id;
    }

    public Contracts(String contractCode) {
        this.contractCode = contractCode;
    }

    public Contracts(Long id, String productName, String contractCode, Long loans, Long profit, String image, String startDate, String endDate, LocalDateTime createTime, LocalDateTime updateTime, boolean isDelete, ProductType productType, Customers customers, ContractStatus contractStatus, Employees employees, ContractType contractType) {
        this.id = id;
        this.productName = productName;
        this.contractCode = contractCode;
        this.loans = loans;
        this.profit = profit;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createDate = createTime;
        this.updateDate = updateTime;
        this.isDelete = isDelete;
        this.productType = productType;
        this.customers = customers;
        this.contractStatus = contractStatus;
        this.employees = employees;
        this.contractType = contractType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public Long getLoans() {
        return loans;
    }

    public void setLoans(Long loans) {
        this.loans = loans;
    }

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getCreateTime() {
        return createDate;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createDate = createTime;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateTime) {
        this.updateDate = updateTime;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }


}
