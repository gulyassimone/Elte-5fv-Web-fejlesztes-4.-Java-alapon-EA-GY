package hu.elte.bankapp.controllers;

import hu.elte.bankapp.webdomain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TransactionController {
    CustomerView customerView;
    List<TransactionView> transactionViews;
    List<TransactionView> savedTransactionViews;
    List<AccountView> personalAccountViews;
    List<AccountView> savingAccountViews;
    List<DirectDebitView> directDebitViews;


    @PostMapping("/transfer")
    public ModelAndView transfer(@ModelAttribute("transaction") TransactionView transactionView) {

        if (transactionViews == null) {
            dummyTransactions();
        }
        transactionView.setDate(LocalDateTime.now());
        transactionView.setType("Transfer");
        transactionViews.add(transactionView);
        transactionViews.forEach(System.out::println);

        return new ModelAndView("redirect:/");
    }

    @PostMapping("/save_transaction")
    public ModelAndView saveTransaction( @ModelAttribute("transaction") TransactionView transactionView) {

        savedTransactionViews.add(transactionView);
        savedTransactionViews.forEach(System.out::println);

        return new ModelAndView("redirect:/transfer");
    }

    @RequestMapping("/direct_debit")
    public String getDirectDebit(Model model) {

        model.addAttribute("title", "Direct Debit");

        if(directDebitViews == null) {
            dummyDirectDebits();
        }
        model.addAttribute("directDebitView", new DirectDebitView());
        model.addAttribute("directDebitViews", directDebitViews);

        return "direct_debit_module.html";
    }



    @GetMapping("/transfer")
    public String getTransfer(Model model) {

        model.addAttribute("title", "Transfer");

        if (savedTransactionViews == null) {
            dummySavedTransactions();
        }

        model.addAttribute("transactionViews", savedTransactionViews);


        TransactionView transaction = new TransactionView();
        model.addAttribute("transaction", transaction);

        if (personalAccountViews == null) {
            dummyPersonalAccounts();
        }
        model.addAttribute("personalAccounts", personalAccountViews);

        return "transfer.html";
    }

    @GetMapping("/regular_transaction")
    public String getTRegularTransaction(Model model) {

        model.addAttribute("title", "Regular Transaction");

        if (savedTransactionViews == null) {
            dummySavedTransactions();
        }

        model.addAttribute("transactionViews", savedTransactionViews);


        TransactionView transaction = new TransactionView();
        model.addAttribute("transaction", transaction);

        if (personalAccountViews == null) {
            dummyPersonalAccounts();
        }
        model.addAttribute("personalAccounts", personalAccountViews);

        return "transfer.html";
    }


    @PostMapping("/add_direct_debit")
    public ModelAndView addDirectDebit(@ModelAttribute("directDebit") DirectDebitView directDebitView) {
        directDebitViews.add(directDebitView);
        System.out.println(directDebitView);

        return new ModelAndView("redirect:/direct_debit");
    }


    @PostMapping("/filter")
    public ModelAndView doFilter(@ModelAttribute("account") AccountView accountView) {

        return new ModelAndView("redirect:/history");
    }


    private void dummySavedTransactions() {
        savedTransactionViews = new ArrayList<>();
        TransactionView transaction1 = new TransactionView("Deposit", 25000, null, null, null, "77665775");
        TransactionView transaction2 = new TransactionView("Deposit", 100000, null, null, null, "77665775");
        savedTransactionViews.add(transaction1);
        savedTransactionViews.add(transaction2);
    }

    private void dummyPersonalAccounts() {
        personalAccountViews = new ArrayList<>();
        AccountView accountView1 = new AccountView(1540, "7335300594110");
        AccountView accountView2 = new AccountView(3230, "60232312312344");
        personalAccountViews.add(accountView1);
        personalAccountViews.add(accountView2);
    }

    private void dummyTransactions() {

        transactionViews = new ArrayList<>();

        TransactionView transaction1 = new TransactionView("Withdraw", 25000, "Rezsi", null, "888888", "77665775");
        TransactionView transaction2 = new TransactionView("Withdraw", 100000, "Albérlet", null, "333333", "77665775");

        transactionViews.add(transaction1);
        transactionViews.add(transaction2);
    }
    private void dummySavingAccounts() {
        savingAccountViews = new ArrayList<>();
        AccountView accountView1 = new AccountView(1540, "999999999999");
        AccountView accountView2 = new AccountView(3230, "876543211111");
        savingAccountViews.add(accountView1);
        savingAccountViews.add(accountView2);
    }

    private void dummyDirectDebits() {
        directDebitViews = new ArrayList<>();

        DirectDebitView directDebitView1 = new DirectDebitView("Provider1", "176788873", 5000);
        DirectDebitView directDebitView2 = new DirectDebitView("Provider1", "176788873", 7000);
        DirectDebitView directDebitView3 = new DirectDebitView("Provider2", "6666666666", 23999);

        directDebitViews.add(directDebitView1);
        directDebitViews.add(directDebitView2);
        directDebitViews.add(directDebitView3);
    }

}
