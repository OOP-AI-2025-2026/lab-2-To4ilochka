package ua.opnu;


public class TimeSpan {

    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        this.hours = Math.max(hours, 0);
        this.minutes = (minutes >= 0 && minutes <= 59) ? minutes : 0;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(int hours, int minutes) {
        addAndNormalize(hours,  minutes);
    }

    public void addTimeSpan(TimeSpan timespan) {
        addAndNormalize(timespan.getHours(), timespan.getMinutes());
    }

    public double getTotalHours() {
        return this.hours + this.minutes / 60.0;
    }

    public int getTotalMinutes() {
        return this.hours * 60 + this.minutes;
    }

    public void subtract(TimeSpan span) {
        int totalCurrent = this.getTotalMinutes();
        int totalOther = span.getTotalMinutes();

        if (totalOther > totalCurrent) {
//            throw new IllegalArgumentException();
            return;
        }

        int result = totalCurrent - totalOther;

        this.hours = result / 60;
        this.minutes = result % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) {
//            throw new IllegalArgumentException();
            return;
        }

        int totalMinutes = getTotalMinutes() * factor;

        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    private void addAndNormalize(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            return;
        }

        this.hours += hours;
        this.minutes += minutes;

        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }
}