
fun main(args:Array<String>){

    scenario()
    external()

}

fun scenario(){

    var schedules:List<Schedule> = listOf(Schedule(listOf(1,2,3,4,5)),
            Schedule(listOf(2,4,2,4,4)),
            Schedule(listOf(4,2,5,3,2)),
            Schedule(listOf(5,2,3,4,1)),
            Schedule(listOf(5,3,4,2,1)),
            Schedule(listOf(2,4,1,3,2)),
            Schedule(listOf(3,2,1,4,5)),
            Schedule(listOf(5,2,3,5,5)),
            Schedule(listOf(3,2,4,1,5)),
            Schedule(listOf(1,3,2,4,2)),
            Schedule(listOf(5,3,3,4,5)),
            Schedule(listOf(4,2,4,1,1)))

    var trains:List<Train> = executeScenario(schedules)

    var dataIO = DataIO()

    dataIO.printResults(trains)

}

fun external(){

    var dataIO = DataIO()

    var trains:List<Train> = executeScenario(dataIO.readScheduleCSV())

    dataIO.safeAsCSV(trains)

}

fun executeScenario(scheduleList:List<Schedule>):List<Train>{

    var segments:MutableList<RailSegment> = createSegments(5)
    var trains:List<Train> = createTrains(scheduleList)

    var network = RailNetwork(segments, trains)
    network.simulateOneStep()

    return trains;

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