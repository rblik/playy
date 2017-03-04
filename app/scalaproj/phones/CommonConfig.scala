package scalaproj.phones

import java.io.{File, FileInputStream}

import scalaproj.spark.SparkContextLoader.sc
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import scala.collection.mutable

/**
  * Created by Blik on 03/04/2017.
  */
object CommonConfig {
  @transient
  private val operators = {
    val map = mutable.Map[String, Operator]()

    var sheet = new XSSFWorkbook(new FileInputStream(new File("data/phone/operators.xlsx"))).getSheetAt(0)
    val rowIterator = sheet.rowIterator()
    while (rowIterator.hasNext) {
      val row = rowIterator.next()
      map(row.getCell(0).getStringCellValue) = Operator(row.getCell(1).getStringCellValue, row.getCell(2).getStringCellValue)
    }
    map
  }
  val broadcast = sc.broadcast(operators)

  }
