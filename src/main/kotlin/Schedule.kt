
class Schedule(schedule:List<Int>){

    private var schedule:List<Int> = schedule

    fun getScheduleEntry(entryNumber: Int):Int{

        return schedule.get(entryNumber - 1)

    }

}