package com.spark.java.tutorial.rdd;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Uppercase {

    public static void main(String[] args) throws Exception {
        
        //Check whether sufficient params are supplied
        if (args.length < 2) {
            System.out.println("Usage: Uppercase <input> <output>");
            System.exit(1);
        }
        
        String base_datadir = args[0];
        String output_path = args[1];
        System.out.println("Input Path :: " + base_datadir +" Output Path :: " + output_path );
        
        // Create a Java Spark Context.
        SparkConf conf = new SparkConf().setAppName("uppercase").setMaster("local[*]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> lines = sc.textFile(base_datadir+"in/uppercase.text");
        JavaRDD<String> lowerCaseLines = lines.map(line -> line.toUpperCase());

        lowerCaseLines.saveAsTextFile(output_path+ "/uppercase.text");
        
    }
}
