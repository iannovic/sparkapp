package main

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

/*@
 * let's make this object do something!
 */


object SparkApp {
    def main(arg: Array[String]) {
      var isSandbox = true;  //boolean represents if we are running on windows or on sandbox
      
      System.out.println("TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST")
      
      val jobName = "SparkApp"
      val conf = new SparkConf().setAppName(jobName)
      
      var pathToFiles = "/user/user01/git/sparkapp/spark-app/src/main/resources/inputexample.txt"
      var outputPath = "/user/user01/output/output.txt"
      
      if (!isSandbox) 
      {
        pathToFiles = "src/main/resources/inputexample.txt"
        outputPath = "C:/outputexample.txt"
        conf.setMaster("local")
      }
      
      val sc = new SparkContext(conf)
      val files = sc.textFile(pathToFiles)
      val crimesRDD = files.map(line => line.split(","))
      
      crimesRDD.collect
      
      // do your work here
      //val rowsWithoutSpaces = files.map(_.replaceAll(" ", ","))
      // and save the result
      //rowsWithoutSpaces.saveAsTextFile(outputPath)

  }
}