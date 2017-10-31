
fun main(args:Array<String>){

    var dataIO = DataIO()

    var results:List<List<String>> = executeScenario(dataIO.readScheduleCSV())
    dataIO.printResults(results)
    dataIO.safeAsCSV(results)

}

fun executeScenario(scheduleList:List<Schedule>):List<List<String>>{

    var segments:MutableList<RailSegment> = createSegments(5)
    var trains:List<Train> = createTrains(scheduleList)

    var network = RailNetwork(segments, trains)
    network.simulateOneStep()

    var results:List<List<String>> = network.getNetworkStatus()

    return results

}

fun createTrains(scheduleList:List<Schedule>):List<Train>{

    var trains:MutableList<Train> = mutableListOf()

    var id = 1
    for(schedule:Schedule in scheduleList){

        var train = Train(id, schedule)
        trains.add(train)
        id++

    }

    return trains.toList()

}

fun createSegments(count: Int):MutableList<RailSegment> {

    var segments: MutableList<RailSegment> = mutableListOf()

    var i = 0
    while (i < count) {
        var segment = RailSegment(3)
        segments.add(segment)

        i++

    }

    return segments

}