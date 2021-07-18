package com.bazarek.bazarek.function.example;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@ToString
public class SecurityCodeDataBase {

    public List<SecurityCode> allSecurityCode = new ArrayList<>();

    public static Stream<SecurityCode> getWbk(){
        Stream<SecurityCode> codeStream = SecurityCodeDataBase
    }


    public void addSecurityCode (SecurityCode securityCode) {
        if (securityCode != null){
            allSecurityCode.add(securityCode);
        }else {
            log.warn("WRONG!");
        }

    }

    public static void main(String[] args) {
        SecurityCode securityCode1 = new SecurityCode(1,"wbk","aaswe212","wwwq2121","wer.wwewe");
        SecurityCode securityCode2 = new SecurityCode(2,"pko","Qwere212","masza321234","wer.wwewe");
        SecurityCode securityCode3 = new SecurityCode(3,"millenium","pppoew212","rewrte","wer.wwewe");
        SecurityCode securityCode4 = new SecurityCode(4,"wbk","kamilio-99","zaq1@WSX","wer.wwewe");


        SecurityCodeDataBase securityCodeDataBase = new SecurityCodeDataBase();
        securityCodeDataBase.addSecurityCode(securityCode1);
        securityCodeDataBase.addSecurityCode(securityCode2);
        securityCodeDataBase.addSecurityCode(securityCode3);
        securityCodeDataBase.addSecurityCode(securityCode4);




        log.info(securityCodeDataBase.toString());
    }
}
