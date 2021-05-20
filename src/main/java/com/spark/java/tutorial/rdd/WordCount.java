package com.spark.java.tutorial.rdd;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.Map;

public class WordCount {

    public static void main(String[] args) throws Exception {

        //Check whether sufficient params are supplied
        if (args.length < 2) {
            System.out.println("Usage: WordCount <input> <output>");
            System.exit(1);
        }
        String base_datadir = args[0];
        String output_path = args[1];
        System.out.println("Input Path :: " + base_datadir +" Output Path :: " + output_path );
        
        int a = "AB-CD".indexOf('-');
        System.out.println("a is  -- " + a);
        
        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkConf conf = new SparkConf().setAppName("wordCounts").setMaster("local[3]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> lines = sc.textFile(base_datadir+"in/word_count.text");
        JavaRDD<String> words = lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());

        Map<String, Long> wordCounts = words.countByValue();

        for (Map.Entry<String, Long> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
        //Thread.sleep(86400000); //throws InterruptedException.
        sc.stop();
    }
}
