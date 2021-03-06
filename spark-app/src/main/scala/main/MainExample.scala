package main

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.log4j.Logger

object MainExample {

  def main(arg: Array[String]) {

    var logger = Logger.getLogger(this.getClass())
    System.out.println("TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST")
    if (arg.length < 2) {
      logger.error("=> wrong parameters number")
      System.err.println("Usage: MainExample <path-to-files> <output-path>")
      System.exit(1)
    }

    val jobName = "MainExample"
    val conf = new SparkConf().setAppName(jobName)
    val sc = new SparkContext(conf)

    //val pathToFiles = arg(0)
    //val outputPath = arg(1)
    
    val pathToFiles = "/user/user01/git/sparkapp/spark-app/src/main/resources/inputexample.txt"
    val outputPath = "/user/user01/output/output.txt"
    

    logger.info("=> jobName \"" + jobName + "\"")
    logger.info("=> pathToFiles \"" + pathToFiles + "\"")

    val files = sc.textFile(pathToFiles)
    
    // do your work here
    val rowsWithoutSpaces = files.map(_.replaceAll(" ", ","))

    // and save the result
    rowsWithoutSpaces.saveAsTextFile(outputPath)

  }
}
