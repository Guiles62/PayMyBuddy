package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.model.PmbAccount;
import com.paymybuddy.paymybuddy.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.paymybuddy.paymybuddy.repository.PmbAccountRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class PmbAccountService {

    @Autowired
    private PmbAccountRepository pmbAccountRepository;

    public Iterable<PmbAccount> getPmbAccount() {
        return pmbAccountRepository.findAll();
    }

    public PmbAccount addPmbAccount(PmbAccount pmbAccount) {
        return pmbAccountRepository.save(pmbAccount);
    }

    public void deletePmbAccount(PmbAccount pmbAccount) {
        pmbAccountRepository.delete(pmbAccount);
    }

}
