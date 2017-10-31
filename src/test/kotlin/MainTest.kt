import org.junit.Test

class MainTest{

    @Test
    fun main(){

        var dataIO = DataIO()

        var results:List<List<String>> = executeScenario(dataIO.readScheduleCSV())

        dataIO.printResults(results)
        dataIO.safeAsCSV(results)

    }

}