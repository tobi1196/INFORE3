import com.univocity.parsers.common.record.Record
import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings
import com.univocity.parsers.csv.CsvWriter
import com.univocity.parsers.csv.CsvWriterSettings
import java.io.File
import java.io.FileWriter
import java.io.InputStreamReader

class DataIO {

    fun safeAsCSV(results:List<List<String>>){

        var file = File("Result.csv")
        var out = FileWriter(file)

        var settings = CsvWriterSettings()
        settings.format.delimiter = ';'
        var csvWriter = CsvWriter(out, settings)

        var outPutList:MutableList<Array<Any>> = mutableListOf()
        outPutList.add(arrayOf("TrainID", "Segment", "Status"))

        for(result:List<String> in results){

            outPutList.add(arrayOf(result[0],result[1],result[2]))

        }

        csvWriter.writeRowsAndClose(outPutList)

    }

    fun printResults(resultList:List<List<String>>){

        for(status:List<String> in resultList){

            System.out.println("Train:" + status[0] + " Segment: " + status[1] + " Status: " + status[2])

        }

    }

    fun readScheduleCSV():List<Schedule> {

        var scheduleList:MutableList<Schedule> = mutableListOf()

        var csvSettings = CsvParserSettings()
        csvSettings.format.delimiter = ';'
        var csvParser = CsvParser(csvSettings)

        var reader = InputStreamReader(this.javaClass.getResourceAsStream("/Schedules.csv"),"UTF-8")
        var recordList:List<Record> = csvParser.parseAllRecords(reader)

        for(record: Record in recordList){

            var entryList:MutableList<Int> = mutableListOf()

            var count = 0
            for(entry:String in record.values){

                if(count != 0) { //column 0 is TrainID

                    entryList.add(entry.toInt())

                }
                ++count

            }

            scheduleList.add(Schedule(entryList.toList()))

        }

        return scheduleList.toList()

    }

}