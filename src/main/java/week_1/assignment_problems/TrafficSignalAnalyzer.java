package week_1.assignment_problems;

public class TrafficSignalAnalyzer {
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) return;
        int maxLen = 0;
        char maxChar = ' ';
        int currentLen = 1;
        char currentChar = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentLen++;
            } else {
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    maxChar = currentChar;
                }
                currentChar = signalLog.charAt(i);
                currentLen = 1;
            }
        }
        if (currentLen > maxLen) {
            maxLen = currentLen;
            maxChar = currentChar;
        }
        System.out.printf("Longest Streak: '%c' repeated %d times\n", maxChar, maxLen);
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}
