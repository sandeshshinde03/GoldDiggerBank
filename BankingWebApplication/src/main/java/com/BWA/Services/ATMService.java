package com.BWA.Services;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BWA.Entites.ATM;
import com.BWA.Repository.ATMRepository;

@Service
public class ATMService {

    @Autowired
    private ATMRepository atmrepo;

    public ATM addATM(ATM atm) {

        // Set Bank Name Automatically
        atm.setBankname("GoldDiggerBank");

        // Get Valid From Date
        Date validDate = atm.getValidFrom();

        // Add 2 years
        Calendar cal = Calendar.getInstance();
        cal.setTime(validDate);
        cal.add(Calendar.YEAR, 2);

        Date expireDate = cal.getTime();

        // Set Expiry Date
        atm.setExpUpTo(expireDate);

        return atmrepo.save(atm);
    }
    
    public ATM fetchSingleData(long cno) {

        Optional<ATM> op = atmrepo.findById(cno);

        if(op.isPresent()) {
            return op.get();
        }
        return null;
    }
    
    public ATM blockCard(long cno, int pin) {

        Optional<ATM> op = atmrepo.findById(cno);

        if(op.isPresent()) {

            ATM atm = op.get();

            if(atm.getPin() == pin) {

                atmrepo.delete(atm);
                return atm;
            }
        }

        return null;
    }
    
    
}