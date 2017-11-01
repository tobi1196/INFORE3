
class RailNetwork(segments:List<RailSegment>, trains:List<Train>){

    private var simulationStep:Int=1
    private var segments:List<RailSegment> = segments
    private var trains:List<Train> = trains

    fun simulateOneStep(){

        for(train:Train in trains){

            var currentSegment:Int = train.getCurrentSegment()
            if(currentSegment > 0) {

                segments[currentSegment - 1].addTrain(train) // -1 because Segment 1 in the Schedule is here Segment 0 in the Array.

            }

        }

        for(segment:RailSegment in segments){

            segment.setTrainsDelayed(segment.isCapacityReached())

        }

    }

    fun getNetworkStatus():List<Train>{

       return trains

    }

    fun increaseSimulationStep(){

        ++simulationStep;
        for(train:Train in trains){

            train.setSimulationStep(simulationStep)

        }

    }

}