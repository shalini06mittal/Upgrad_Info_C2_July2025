package model;

import java.time.LocalDate;

public class CDR {
    private String caller;
    private String receiver;
    private LocalDate callDate;
    private int duration; // in seconds

    public CDR(String caller, String receiver, LocalDate callDate, int duration) {
        this.caller = caller;
        this.receiver = receiver;
        this.callDate = callDate;
        this.duration = duration;
    }

    // Getters
    public String getCaller() { return caller; }
    public String getReceiver() { return receiver; }
    public LocalDate getCallDate() { return callDate; }
    public int getDuration() { return duration; }

    @Override
    public String toString() {
        return caller + " → " + receiver + " | " + callDate + " | Duration: " + duration + " sec";
    }
}
