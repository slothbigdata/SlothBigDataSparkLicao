package com.slothbigdata.licao

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.{DataFrame, SparkSession}

object WordCount {
  
  def main(args: Array[String]): Unit = {
  
     val sparkConf = new SparkConf().setAppName("Spark Pi").setMaster("local")
     val sc = new SparkContext(sparkConf)
     val textFile = sc.textFile("C:\\dados\\consulta\\*")
     val counts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)
     //counts.map(row => println(row))
     counts.saveAsTextFile("C:\\dados\\wordcountresult")    
    
  }  
}