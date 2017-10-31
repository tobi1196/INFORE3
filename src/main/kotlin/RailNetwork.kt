
class RailNetwork(segments:List<RailSegment>, trains:List<Train>){

    private var simulationStep:Int=1
    private var segments:List<RailSegment> = segments
    private var trains:List<Train> = trains

    fun simulateOneStep(){

        for(train:Train in trains){

            var currentSegment:Int = train.getCurrentSegment(simulationStep)
            if(currentSegment > 0) {

                segments[currentSegment - 1].addTrain(train) // -1 because Segment 1 in the Schedule is here Segment 0 in the Array.

            }

        }

        for(segment:RailSegment in segments){

            var delayed = false
            if(segment.getTrainCount() > segment.getCapacity()){

                delayed = true

            }

            segment.setTrainsDelayed(delayed)

        }

    }

    fun getNetworkStatus():List<List<String>>{

        var statusList:MutableList<List<String>> = mutableListOf()

        for(train:Train in trains){

            var trainResult:MutableList<String> = mutableListOf()

            trainResult.add(train.getID().toString())

            trainResult.add(train.getCurrentSegment(simulationStep).toString())

            if(train.isDelayed()){

                trainResult.add("Delayed")

            }else{

                trainResult.add("OnTime")

            }

            statusList.add(trainResult.toList())

        }

        return statusList.toList()

    }

    fun increaseSimulationStep(){

        ++simulationStep;

    }

}