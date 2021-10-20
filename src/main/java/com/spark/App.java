package com.spark;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class App {

    public static void main(String[] args) throws Exception {

        SparkConf sparkConf = new SparkConf().setAppName("MainSparkApp");
        JavaSparkContext ctx = new JavaSparkContext(sparkConf);
        //int i = 0;
        // for (int j = 0; j < 100; j++) {
        // System.out.println("message : " + i);
        // }

        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                sparkTask();
            }
        }, 0, 1, TimeUnit.SECONDS);

        // ctx.stop();
        // ctx.close();
    }

    private static void sparkTask() {
        System.out.println("Spark App Runnig");
    }

}