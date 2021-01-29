package com.coreBankDummy.demo.service;

import com.trebeyainterview.spring_boot_soap.Account;
import com.trebeyainterview.spring_boot_soap.OwnTransferInput;
import com.trebeyainterview.spring_boot_soap.OwnTransferOutput;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {

    private static final Map<String, Account> accounts = new HashMap<>();

    @PostConstruct
    public void initiate(){
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

    public Account getAccounts(String accountNumber){
        return accounts.get(accountNumber);
    }

    public Double getAccountBalance(String userId){
        double totalBalance = 0;
        for (Map.Entry account : accounts.entrySet()) {
            if(accounts.get(account.getKey()).getUserId().equals(userId)){
                totalBalance += accounts.get(account.getKey()).getBalance();
            }
        }
        return totalBalance;
    }

    public OwnTransferOutput ownAccountTransfer(OwnTransferInput ownTransferInput){
        OwnTransferOutput output = new OwnTransferOutput();
        Account toAccount = accounts.get(ownTransferInput.getToAccount());
        Account fromAccount = accounts.get(ownTransferInput.getFromAccount());
        System.out.println(toAccount);
        System.out.println(fromAccount);

        if(toAccount.getUserId().equals(fromAccount.getUserId())){
            toAccount.setBalance(toAccount.getBalance() + ownTransferInput.getAmount());
//            fromAccount.setBalance(fromAccount.getBalance() - ownTransferInput.getAmount());
//            output.setFromAccount(fromAccount.getAccountNo());
//            output.setToAccount(toAccount.getAccountNo());
//            output.setUserId(ownTransferInput.getUserId());
//            output.setAmount(ownTransferInput.getAmount());
//            output.setFromBalance(fromAccount.getBalance());
//            output.setToBalance(toAccount.getBalance());

//                fromAccount.setBalance(fromAccount.getBalance() - ownTransferInput.getAmount());
                output.setFromAccount(fromAccount.getAccountNo());
                output.setToAccount(toAccount.getAccountNo());
                output.setUserId(ownTransferInput.getUserId());
                output.setAmount(ownTransferInput.getAmount());
                output.setFromBalance(fromAccount.getBalance());
                output.setToBalance(toAccount.getBalance());
        }
        output.setFromAccount("fromAccount.getAccountNo()");
        output.setToAccount("toAccount.getAccountNo()");
        output.setUserId("ownTransferInput.getUserId()");
        output.setAmount(2000);
        output.setFromBalance(3999);
        output.setToBalance(39394);
        return output;
    }


}
