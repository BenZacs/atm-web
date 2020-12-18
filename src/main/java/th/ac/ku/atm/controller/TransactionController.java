package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.Transaction;
import th.ac.ku.atm.service.BankAccountService;
import th.ac.ku.atm.service.TransactionService;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    private BankAccountService accountService;
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService,BankAccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    @PostMapping
    public String makeTransaction(@ModelAttribute Transaction transaction, Model model) {
    transactionService.makeTransaction(transaction);
    model.addAttribute("bankaccounts", accountService.getBankAccounts());
        return "redirect:/bankaccount";
    }
}
