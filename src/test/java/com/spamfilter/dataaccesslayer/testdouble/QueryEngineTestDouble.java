package com.spamfilter.dataaccesslayer.testdouble;

import com.spamfilter.dataaccesslayer.QueryEngine;
import com.spamfilter.spam.entity.Word;
import com.spamfilter.spam.entity.EmailAddress;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ketan on 7/23/2014.
 */
public class QueryEngineTestDouble implements QueryEngine {
    private String key;
    private String subkey;
    private Double value;
    private Double value2;
    private String caption;
    private String id;
    private List<EmailAddress> emailAddressList;
    private List<Word>wordList;

    public QueryEngineTestDouble(){
        wordList=new LinkedList<Word>();
        emailAddressList=new LinkedList<EmailAddress>();
    }


    @Override
    public void saveScalarValues(Word word) {
        for (Word word1: wordList){
            if(word1.getKeyWord().equals(word.getKeyWord()))
                wordList.remove(word1);

        }
        wordList.add(word);
    }
    public  List<Word>li(){
        return wordList;
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
        for (EmailAddress emailAddress1 : emailAddressList) {
            if (emailAddress.equals(emailAddress1))
                emailAddressList.remove(emailAddress);
        }

    }

    @Override
    public Double getScalarValue(Word word) {
        for (Word word1:wordList) {
            if (word1.getKeyWord().equals(word.getKeyWord())){
                if(word1.getSpamLabel().equals(word.getSubkey())){
                    return word1.getSpamCount();
                }else  if(word1.getGenuineLabel().equals(word.getSubkey())) {
                    return word1.getGeuineCount();
                }
                return word1.getProb();
            }
        }
        return 0.0;
    }
}
