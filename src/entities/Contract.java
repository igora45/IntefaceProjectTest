package entities;

import model.ContractService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private int number;
    private LocalDate date;
    private double totalValue;
    private String company;
    private ContractService contractService;
    private List<Installment> installments = new ArrayList<>();

    public Contract(){}

    public Contract(int number, LocalDate date, double totalValue, String company, ContractService contractService){
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
        this.company = company;
        this.contractService = contractService;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ContractService getContractService() {
        return contractService;
    }

    public List<Installment> getInstallments() {
        return installments;
    }
}