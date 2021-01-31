package com.coreBankDummy.demo.service;


import com.trebeyainterview.spring_boot_soap.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {

    private static final Map<String, Account> accounts = new HashMap<>();

    @PostConstruct
    public void initiate() {
        Account ac1 = new Account();
        ac1.setUserId("111");
        ac1.setAccountNo("123123123");
        ac1.setBalance(8450);

        accounts.put(ac1.getAccountNo(), ac1);

        Account ac2 = new Account();
        ac2.setUserId("111");
        ac2.setAccountNo("456456456");
        ac2.setBalance(5000);

        accounts.put(ac2.getAccountNo(), ac2);

        Account ac3 = new Account();
        ac3.setUserId("222");
        ac3.setAccountNo("789789789");
        ac3.setBalance(3000);

        accounts.put(ac3.getAccountNo(), ac3);

        Account ac4 = new Account();
        ac4.setUserId("333");
        ac4.setAccountNo("567567567");
        ac4.setBalance(8000);

        accounts.put(ac4.getAccountNo(), ac4);
    }

    /**
     * Get account details
     * @param accountNumber Account number of the account
     * @return Account object (Account details) related to the given account number
     */
    public Account getAccounts(String accountNumber) {
        return accounts.get(accountNumber);

    }

    /**
     * Get total balance of a particular user
     * @param userId User Id
     * @return Total balance of all accounts owned by the given user
     */
    public Double getAccountBalance(String userId) {
        double totalBalance = 0;
        for (Map.Entry account : accounts.entrySet()) {
            if (accounts.get(account.getKey()).getUserId().equals(userId)) {
                totalBalance += accounts.get(account.getKey()).getBalance();
            }
        }
        return totalBalance;
    }

    /**
     * Own accounts transactions
     * @param ownAccountTransferRequest Object containing toAccountNo, fromAccountNo, userId and amount
     * @return OwnTransferOutput object contains transaction details
     */
    public OwnTransferOutput ownAccountTransfer(OwnAccountTransferRequest ownAccountTransferRequest) {
        OwnTransferOutput output = new OwnTransferOutput();
        Account toAccount = accounts.get(ownAccountTransferRequest.getToAccount());
        Account fromAccount = accounts.get(ownAccountTransferRequest.getFromAccount());

        if (toAccount.getUserId().equals(fromAccount.getUserId())) {
            if(fromAccount.getBalance() >= ownAccountTransferRequest.getAmount()){
                toAccount.setBalance(toAccount.getBalance() + ownAccountTransferRequest.getAmount());
                fromAccount.setBalance(fromAccount.getBalance() - ownAccountTransferRequest.getAmount());
                output.setFromAccount(fromAccount.getAccountNo());
                output.setToAccount(toAccount.getAccountNo());
                output.setUserId(ownAccountTransferRequest.getUserId());
                output.setAmount(ownAccountTransferRequest.getAmount());
                output.setFromBalance(fromAccount.getBalance());
                output.setToBalance(toAccount.getBalance());
            }
        }
        return output;
    }


    /**
     * Inter account transactions
     * @param interAccountTransferRequest Object containing toAccountNo, fromAccountNo and amount
     * @return  InterTransferOutput object contains transaction details
     */
    public InterTransferOutput interAccountTransfer(InterAccountTransferRequest interAccountTransferRequest) {
        InterTransferOutput output = new InterTransferOutput();
        Account toAccount = accounts.get(interAccountTransferRequest.getToAccount());
        Account fromAccount = accounts.get(interAccountTransferRequest.getFromAccount());

        if(fromAccount.getBalance() >= interAccountTransferRequest.getAmount()){
            toAccount.setBalance(toAccount.getBalance() + interAccountTransferRequest.getAmount());
            fromAccount.setBalance(fromAccount.getBalance() - interAccountTransferRequest.getAmount());
            output.setFromAccount(fromAccount.getAccountNo());
            output.setToAccount(toAccount.getAccountNo());
            output.setAmount(interAccountTransferRequest.getAmount());
            output.setFromBalance(fromAccount.getBalance());
            output.setToBalance(toAccount.getBalance());
        }

        return output;
    }


}
