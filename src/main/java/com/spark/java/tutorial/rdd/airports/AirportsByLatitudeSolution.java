package com.spark.java.tutorial.rdd.airports;

import org.apache.commons.lang.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class AirportsByLatitudeSolution {

    public static void main(String[] args) throws Exception {

        //Check whether sufficient params are supplied
        if (args.length < 2) {
            System.out.println("Usage: AirportsByLatitudeSolution <input> <output>");
            System.exit(1);
        }
        String base_datadir = args[0];
        System.out.println(" Input Path :: " + base_datadir );
        String output_path = args[1];
        System.out.println(" Output Path :: " + output_path );
        
        SparkConf conf = new SparkConf()
                .setAppName("airports")
                .setMaster("local[*]");

        JavaSparkContext sc = new JavaSparkContext(conf);
        
        JavaRDD<String> airports = sc.textFile("in/airports.text");
        String COMMA_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        JavaRDD<String> airportsInUSA = airports.filter(line -> Float.valueOf(line.split(COMMA_DELIMITER)[6]) > 40);

        JavaRDD<String> airportsNameAndCityNames = airportsInUSA.map(line -> {
            String[] splits = line.split(COMMA_DELIMITER);
            return StringUtils.join(new String[]{splits[1], splits[6]}, ",");
        });

        airportsNameAndCityNames.saveAsTextFile("outputs/airports_by_latitude");
        sc.close();
    }
}
