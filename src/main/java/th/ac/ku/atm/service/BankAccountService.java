package th.ac.ku.atm.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.BankAccount;
import org.springframework.web.client.RestTemplate;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


@Service
public class BankAccountService {

    private RestTemplate restTemplate;

    public BankAccountService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<BankAccount> getCustomerBankAccount(int customerId) {
        String url = "http://localhost:8091/api/bankaccount/customer/" +
                customerId;
        ResponseEntity<BankAccount[]> response =
                restTemplate.getForEntity(url, BankAccount[].class);

        BankAccount[] accounts = response.getBody();

        return Arrays.asList(accounts);
    }

    private ArrayList<BankAccount> bankAccountList;

    @PostConstruct
    public void postContruct() {
        bankAccountList = new ArrayList<>();
    }

    public void createBankAccount(BankAccount bankAccount) {
        bankAccountList.add(bankAccount);
    }

    public List<BankAccount> getBankAccounts() {
        return new ArrayList<>(this.bankAccountList);
    }

    public BankAccount findBankAccount(int id) {
        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount.getId() == id)
                return bankAccount;
        }
        return null;
    }
}