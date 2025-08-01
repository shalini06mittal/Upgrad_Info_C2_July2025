package techgatha;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class CDRAnalyzer {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "CDR_Sample.csv";
        CallDetailDataSource detailDataSource = new CallDetailDataSource();
        List<CallDetail> callLogs = detailDataSource.getDetails();//readCallDetails(filePath);
        printAllCalls(callLogs);
        printUserSummary(callLogs);
        printPeakUsageHours(callLogs);
        printFrequentContacts(callLogs);
        detectFraud(callLogs);
    }

    static List<CallDetail> readCallDetails(String filePath) throws FileNotFoundException {
        List<CallDetail> calls = new ArrayList<>();
        URL url = CDRAnalyzer.class.getResource(filePath);

        if (url != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
                String line;

                br.readLine(); // Skip header
                DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    CallDetail call = new CallDetail(
                            parts[0], parts[1],
                            LocalDateTime.parse(parts[2], formatter),
                            LocalDateTime.parse(parts[3], formatter),
                            parts[4]
                    );
                    calls.add(call);
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
        return calls;
    }

    static void printAllCalls(List<CallDetail> calls) {
        System.out.println("\n📞 All Call Records:");
        for (CallDetail c : calls) {
            System.out.println(c);
        }

    }

    static void printUserSummary(List<CallDetail> calls) {
        System.out.println("\n📊 User-wise Summary:");

        System.out.println((calls.stream().collect(Collectors.groupingBy(CallDetail::getCaller, Collectors.counting()))));


        Map<String, Map<String, Integer>> userStats = new HashMap<>();

        for (CallDetail c : calls) {
            userStats.putIfAbsent(c.caller, new HashMap<>());
            Map<String, Integer> stat = userStats.get(c.caller);
            stat.put(c.callType, stat.getOrDefault(c.callType, 0) + 1);
        }

        for (String user : userStats.keySet()) {
            System.out.println("User: " + user + " -> " + userStats.get(user));
        }
    }

    static void printPeakUsageHours(List<CallDetail> calls) {
        System.out.println("\n⏰ Peak Usage Hours:");
        Map<Integer, Integer> hourCount = new TreeMap<>();

        for (CallDetail c : calls) {
            int hour = c.getStartHour();
            hourCount.put(hour, hourCount.getOrDefault(hour, 0) + 1);
        }

        int peakHour = Collections.max(hourCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Most active hour: " + peakHour + ":00 - " + (peakHour + 1) + ":00");
    }

    static void printFrequentContacts(List<CallDetail> calls) {
        System.out.println("\n👥 Frequent Contacts per User:");
        Map<String, Map<String, Integer>> contactMap = new HashMap<>();

        for (CallDetail c : calls) {
            contactMap.putIfAbsent(c.caller, new HashMap<>());
            Map<String, Integer> freqMap = contactMap.get(c.caller);
            freqMap.put(c.receiver, freqMap.getOrDefault(c.receiver, 0) + 1);
        }

        for (String user : contactMap.keySet()) {
            Map.Entry<String, Integer> topContact = Collections.max(
                    contactMap.get(user).entrySet(),
                    Map.Entry.comparingByValue()
            );
            System.out.println("User: " + user + " → Most Contacted: " + topContact.getKey() + " (" + topContact.getValue() + " times)");
        }
    }

    static void detectFraud(List<CallDetail> calls) {
        System.out.println("\n🚨 Potential Fraud Detection:");
        for (CallDetail c : calls) {
            if (c.getDurationInSeconds() > 3600) {
                System.out.println("⚠️ Long Call Detected: " + c);
            }
        }

        // Detect rapid-fire calls (e.g., > 3 calls in same minute)
        Map<String, List<LocalDateTime>> userCallTimes = new HashMap<>();
        for (CallDetail c : calls) {
            userCallTimes.putIfAbsent(c.caller, new ArrayList<>());
            userCallTimes.get(c.caller).add(c.startTime);
        }

        for (String user : userCallTimes.keySet()) {
            List<LocalDateTime> times = userCallTimes.get(user);
            Collections.sort(times);

            for (int i = 0; i < times.size() - 3; i++) {
                long seconds = Duration.between(times.get(i), times.get(i + 3)).getSeconds();
                if (seconds <= 60) {
                    System.out.println("⚠️ Rapid-fire calls by " + user + " between " + times.get(i) + " and " + times.get(i + 3));
                    break;
                }
            }
        }
    }

}
