package com.coreBankDummy.demo.endpoint;

import com.coreBankDummy.demo.service.AccountService;
import com.trebeyainterview.spring_boot_soap.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccountEndpoint {

    @Autowired
    private AccountService accountService;

    @PayloadRoot(namespace = "http://www.trebeyainterview.com/spring-boot-soap",
    localPart = "getAccountRequest")
    @ResponsePayload
    public GetAccountResponse getAccountResponse(@RequestPayload GetAccountRequest request){
        GetAccountResponse response = new GetAccountResponse();
        response.setAccount(accountService.getAccounts(request.getAccountNo()));
        return response;
    }


    @PayloadRoot(namespace = "http://www.trebeyainterview.com/spring-boot-soap",
        localPart = "getBalanceRequest")
    @ResponsePayload
    public GetBalanceResponse getBalanceResponse(@RequestPayload GetBalanceRequest request){
        GetBalanceResponse response = new GetBalanceResponse();
        response.setBalance(accountService.getAccountBalance(request.getUserId()));
        return response;

    }

    @PayloadRoot(namespace = "http://www.trebeyainterview.com/spring-boot-soap",
            localPart = "ownAccountTransferRequest")
    @ResponsePayload
    public OwnAccountTransferResponse ownAccountTransferResponse(@RequestPayload OwnAccountTransferRequest request){
        OwnAccountTransferResponse response = new OwnAccountTransferResponse();
        response.setOwnTransferOutput(accountService.ownAccountTransfer(request.getOwnTransferInput()));
        return  response;
    }
}
