
class Train(id:Int, schedule: Schedule){

    private var id:Int = id
    private var isDelayed:Boolean=false
    private var schedule:Schedule = schedule

    fun getCurrentSegment(stepNumber: Int):Int{

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

}