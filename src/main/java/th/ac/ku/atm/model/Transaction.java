package th.ac.ku.atm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    private int bankAccountId;
    private String transactionType;
    private double amount;


    public int getBankAccountId() {
        return bankAccountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + "0" + ", bankAccountId=" + bankAccountId + ", " +
                "transactionType='" + transactionType + '\'' +
                ", amount=" + amount + '}';
    }
}
