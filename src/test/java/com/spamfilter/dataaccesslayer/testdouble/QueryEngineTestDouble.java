package com.spamfilter.dataaccesslayer.testdouble;

import com.spamfilter.dataaccesslayer.QueryEngine;
import com.spamfilter.spam.EmailAddress;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ketan on 7/23/2014.
 */
public class QueryEngineTestDouble implements QueryEngine {
    public static final double spamf = 1.0;
    public static final double geniunf = 2.0;
    private String key;
    private String subkey;
    private Double value;
    private Double value2;
    private String caption;
    private String id;
    private List<EmailAddress> emailAddressList;
    public QueryEngineTestDouble(){
        emailAddressList=new LinkedList<EmailAddress>();
    }

    @Override
    public double getScalarValue(String key, String subkey) {
        if (subkey.equals("spamFrequency")) {
            return spamf;
        }else if (subkey.equals("geniunFrequecy")) {
            return geniunf;
        }
        return 0.33;
    }

    @Override
    public void saveScalarValues(String key, String subkey, Double value, Double value2) {
        this.key=key;
        this.subkey=subkey;
        this.value=value;
        this.value2=value2;
    }

    @Override
    public void saveSclarValue(EmailAddress emailAddress) {
        emailAddressList.add(emailAddress);
    }

    @Override
    public boolean isPresent(EmailAddress emailAddress) {
        for (EmailAddress emailAddress1:emailAddressList){
            if(emailAddress.equals(emailAddress1)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(EmailAddress emailAddress) {
        for (EmailAddress emailAddress1:emailAddressList){
            if(emailAddress.equals(emailAddress1))
                emailAddressList.remove(emailAddress);
        }

    }



}
