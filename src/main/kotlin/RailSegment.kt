
class RailSegment(capacity: Int){

    private var capacity: Int = capacity
    private var trains:MutableList<Train> = mutableListOf()


    fun getCapacity(): Int{

        return capacity

    }

    fun getTrainCount():Int {

        return trains.size

    }

    fun addTrain(train:Train){

        trains.add(train)

    }

    fun setTrainsDelayed(delayed:Boolean){

        for(train:Train in trains){

            train.setDelayed(delayed)

        }

    }

    fun isCapacityReached():Boolean{

        if(getTrainCount() > getCapacity()){

            return true

        }

        return false

    }

}