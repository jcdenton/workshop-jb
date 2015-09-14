package ii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override operator fun compareTo(other: MyDate): Int {
        if (year != other.year) return year - other.year
        if (month != other.month) return month - other.month
        return dayOfMonth - other.dayOfMonth
    }
}

operator fun MyDate.rangeTo(end: MyDate) = DateRange(this, end)

operator fun MyDate.plus(interval: TimeInterval) = addTimeIntervals(interval, 1)

operator fun MyDate.plus(intervals: TimeIntervals) = addTimeIntervals(intervals.type, intervals.num)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

operator fun TimeInterval.times(num: Int) = TimeIntervals(this, num)

class TimeIntervals(val type: TimeInterval, val num: Int)

class DateRange(public override val start: MyDate, public override val end: MyDate) :
        Iterable<MyDate>, Range<MyDate> {

    override fun contains(item: MyDate): Boolean =
            start <= item && item <= end

    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            private var current = start

            override fun next(): MyDate {
                if (!hasNext()) IllegalStateException(current.toString())

                val result = current
                current = current.nextDay()
                return result
            }

            override fun hasNext(): Boolean = current <= end
        }
    }
}
