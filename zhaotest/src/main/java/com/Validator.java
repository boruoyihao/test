package com;

import com.google.common.base.Strings;

import java.net.URI;
import java.net.URISyntaxException;

public class Validator {

    public static boolean isValidAbsoluteUrl(String url) {
        if (Strings.isNullOrEmpty(url)) {
            return false;
        }

        try {
            URI uri = new URI(url);
            return uri.isAbsolute();
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public static void main(String args[]){
        System.out.println(isValidAbsoluteUrl(""));
    }
}