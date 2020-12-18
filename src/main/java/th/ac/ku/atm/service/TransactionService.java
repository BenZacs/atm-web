package th.ac.ku.atm.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.atm.model.Transaction;

@Service
public class TransactionService {
    private RestTemplate restTemplate;

    private TransactionService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public void makeTransaction(Transaction transaction) {
        String url = "http://localhost:8091/api/bankaccount/transaction";
        restTemplate.postForObject(url, transaction, Transaction.class);
    }
}
