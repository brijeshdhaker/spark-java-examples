package com.spark.java.tutorial.rdd.commons;

public class Utils {

    // a regular expression which matches commas but not commas within double quotations
    public static final String COMMA_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
}
