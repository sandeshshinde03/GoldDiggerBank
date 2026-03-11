package com.BWA.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BWA.Entites.ATM;
import com.BWA.Services.ATMService;

@Controller
public class ATMController {

    @Autowired
    private ATMService atmserv;

    @GetMapping("/atmservices")
    public String visitATMServices() {
        return "atmservices";
    }

    @GetMapping("/atmForm")
    public String visitATMForm() {
        return "atmForm";
    }

    @PostMapping("/addATM")
    public String addAtmDetails(@ModelAttribute ATM atm, Model model) {

        ATM savedATM = atmserv.addATM(atm);

        model.addAttribute("atm", savedATM);

        return "showatm";
    }
    
    
    @RequestMapping("/verifyATM")
    public String visitVerificationForm() {
        return "verifyATM";
    }

   
    @GetMapping("/verifyATMData")
    public String verifyDetails(@RequestParam("cardno") long cno,
                                @RequestParam("pin") int pin,
                                Model model) {

        ATM atm = atmserv.fetchSingleData(cno);

        if(atm != null && pin == atm.getPin()) {

            model.addAttribute("atm", atm);
            return "showatmDetails";

        } else {

            model.addAttribute("error", "Invalid Card Number or PIN");
            return "verifyATM";
        }
    }
    
    @RequestMapping("/verifyCard")
    public String verifyToBlockCard() {
    	return "blockCard";
    }
    
    @GetMapping("/blockCard")
    public String blockCard(@RequestParam("cardno") long cno,
                            @RequestParam("pin") int pin,
                            Model model) {

        ATM atm = atmserv.blockCard(cno, pin);

        if(atm != null) {

            model.addAttribute("atm", atm);
            return "blockSuccess";

        } else {

            model.addAttribute("error", "Invalid Card Number or PIN");
            return "blockCard";
        }
    }

}