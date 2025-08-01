package techgatha;
import java.time.*;


public class CallDetail  {
    String caller;
    String receiver;
    LocalDateTime startTime;
    LocalDateTime endTime;
    String callType;

    public CallDetail(String caller, String receiver, LocalDateTime start, LocalDateTime end, String type) {
        this.caller = caller;
        this.receiver = receiver;
        this.startTime = start;
        this.endTime = end;
        this.callType = type;
    }

    public String getCaller() {
        return caller;
    }

    public String getReceiver() {
        return receiver;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getCallType() {
        return callType;
    }

    public long getDurationInSeconds() {
        return Duration.between(startTime, endTime).getSeconds();
    }

    public int getStartHour() {
        return startTime.getHour();
    }

    @Override
    public String toString() {
        return caller + " -> " + receiver + " | " + callType + " | Duration: " + getDurationInSeconds() + "s";
    }

}
