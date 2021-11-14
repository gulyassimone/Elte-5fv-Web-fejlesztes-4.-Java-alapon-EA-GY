package hu.elte.bankapp.controllers;

import hu.elte.bankapp.webdomain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountsController {
    CustomerView customerView;
    List<TransactionView> transactionViews;
    List<TransactionView> savedTransactionViews;
    List<AccountView> personalAccountViews;
    List<AccountView> savingAccountViews;
    List<DirectDebitView> directDebitViews;



    @RequestMapping("/personal_account")
    public String getPersonalAccounts(Model model) {
        model.addAttribute("title", "Personal Accounts");

        if (personalAccountViews == null) {
            dummyPersonalAccounts();
        }

        if (transactionViews == null) {
            dummyTransactions();
        }

        model.addAttribute("accountViews", personalAccountViews);
        model.addAttribute("transactionViews", transactionViews);

        return "personal_accounts.html";
    }
    @RequestMapping("/account_history")
    public String getAccountHistory(Model model) {
        model.addAttribute("title", "Account history");
        if(transactionViews == null) {
            dummyTransactions();
        }
        if(personalAccountViews == null) {
            dummyPersonalAccounts();
        }
        model.addAttribute("account", new AccountView(123, "9809890"));
        model.addAttribute("accounts", personalAccountViews);
        model.addAttribute("transactions", transactionViews);

        return "account_history_module.html";
    }


    @RequestMapping("/saving_account")
    public String getSavingAccounts(Model model) {

        model.addAttribute("title", "Saving Accounts");

        if (transactionViews == null) {
            dummyTransactions();
        }

        if (personalAccountViews == null) {
            dummyPersonalAccounts();
        }

        if (savingAccountViews == null) {
            dummySavingAccounts();
        }

        model.addAttribute("transactionViews", transactionViews);
        model.addAttribute("accountViews", savingAccountViews);
        return "saving_accounts.html";
    }



    //DUMMY DATA
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
