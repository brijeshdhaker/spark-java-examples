package com.spark.java.tutorial.rdd.sumOfNumbers;

import java.util.Arrays;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SumOfNumbersProblem {

    public static void main(String[] args) throws Exception {

        /* 
            Create a Spark program to read the first 100 prime numbers from in/prime_nums.text,
            print the sum of those numbers to console.
        */
        //Check whether sufficient params are supplied
        if (args.length < 2) {
            System.out.println("Usage: SumOfNumbersProblem <input> <output>");
            System.exit(1);
        }
        String base_datadir = args[0];
        System.out.println(" Input Path :: " + base_datadir );
        String output_path = args[1];
        System.out.println(" Output Path :: " + output_path );
        
        SparkConf conf = new SparkConf()
                .setAppName("SumOfNumbersProblem")
                .setMaster("local[*]");
        
        JavaSparkContext jsc = new JavaSparkContext(conf);
        JavaRDD<String> lines = jsc.textFile(base_datadir+"in/prime_nums.text");
        
        JavaRDD<String> numbers = lines.flatMap(line -> Arrays.asList(line.split("\\s+")).iterator());
        
        /*
           Each row of the input file contains 10 prime numbers separated by spaces.
        */
    }
}
