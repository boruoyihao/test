package com.guava.hashing;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

/**
 * Created by zhaolizhen on 17-1-10.
 */
public class MathTest {
    private static String str="{\"P0000001\":\"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC8knWEU5B+vvX1vBQUABhGYze4U2f647njxydZX7Jl/veNTo759dsm2oyXNmNW1nL88Vz8mHik4Hs+Q+gsN2Tq2sG1l7LqpMns/MX1mZypAUhypQl3bE09aoi1icjM8Oo5U7PbACJffh9WF/1Pyu0nbw28c6D3/kmrZ9vox18pkwIDAQAB\",\"P0000001-name\":\"北京银行消费贷款\",\"P0000002\":\"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsirwjoPpeHuraj01vav6LyPpWiZaw6j0XYDNfLjEOVmd3dmxPuDt/YaMtM1+ci/JkYLtSY6fx4vBhmyBG+p12gF+3SKj7i03v8wz/+3uIzTfdvoezgM52BBqGPgdTpA6oZs7HgGMUuuVJwxoBf2OGrwS+p1vuAsTo4ExyiHJGrwIDAQAB\",\"P0000002-name\":\"货币基金\",\"P0000003\":\"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/4n6V9CGo9aVMxmSxUzuAfJ8hUIvuWENlCXUU+8uujN+PAM/4fQytiKCxZYM0PLSYBVStZEfGtR1dNA6yR6EhtV76KlijUel+c5Sbh2U1EzA9n2/ETDcSMTUKXrsTm1sPjBSVIdfw5fhXUt5doxB7g7J1KAfSRj+s8N2ssTPuvQIDAQAB\",\"P0000003-name\":\"信用卡还款\",\"P0000004\":\"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDWwRHPVDCD81vulmut/+ME1+ZUMf9sf2S1jYmtTsOPP+cmYXFL7DCwWh59WOhVcHBsgcm6IYIJB8yCWP9T6mbeitKRLq8UiCctp+aCLNW6Q1/DdD0mzw0JDtZsAWZ8cfze7K/gV7OmnB9fA4iA4Wix6K4I68pwvafm3AyS12TSwIDAQAB\",\"P0000004-name\":\"小米支付\",\"corePartner\":\",P0000001,P0000002,P0000003,P0000004,11135143,11142636,1000003527,1000000372,\",\"S0000001\":\"NULL\",\"S0000001-name\":\"安全中心\",\"S0000002\":\"NULL\",\"S0000002-name\":\"小米账号\",\"S0000003\":\"NULL\",\"S0000003-name\":\"成长体系\"}";
    public static void main(String args[]){
        System.out.println();
        System.out.println(Hashing.md5().hashString(str, Charsets.UTF_8));
//
//        for(int i=0;i<1000000000;i++) {
//            String hash = Hashing.md5().hashString("zhaolizhen dd", Charsets.UTF_8).toString();
//            String hash1 = Hashing.md5().hashString("zhaolizhen dd", Charsets.UTF_8).toString();
//            if(!hash.equalsIgnoreCase(hash1)) {
//                System.out.println("mismathch");
//            }
//        }
    }
}
