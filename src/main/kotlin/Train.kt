
class Train(id:Int, schedule: Schedule){

    private var id:Int = id
    private var stepNumber:Int = 1
    private var isDelayed:Boolean=false
    private var schedule:Schedule = schedule

    fun getCurrentSegment():Int{

        return schedule.getScheduleEntry(stepNumber)

    }

    fun setDelayed(status:Boolean){

        isDelayed=status

    }

    fun isDelayed():Boolean {

        return isDelayed

    }

    fun getID():Int{

        return id

    }

    fun setSimulationStep(simulationStep:Int){

        stepNumber = simulationStep

    }

    fun getStatus():List<String>{

        var status = ""
        if(isDelayed()){

            status = "Delayed"

        }else{

            status = "OnTime"

        }

        return listOf(getID().toString(), getCurrentSegment().toString(), status)

    }

}