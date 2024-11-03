import org.apache.spark.sql.SparkSession

abstract class SparkApp {
  val spark: SparkSession = SparkSession.builder
    .appName(getClass.getSimpleName)
    .master("spark://spark-master:7077") // Connect to the Spark master
    .getOrCreate()

  def run(): Unit  // Abstract method to be implemented by subclasses

  // Method to stop Spark session
  def stop(): Unit = {
    spark.stop()
  }
}