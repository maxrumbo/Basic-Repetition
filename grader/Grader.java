import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Grader {
    static class TestCase {
        String input;
        String expectA;
        String expectB;
        String expectC;
        int scoreA = 30;
        int scoreB = 30;
        int scoreC = 40;
    }

    public static void main(String[] args) throws Exception {
        List<TestCase> tests = buildTests();
        List<String> studentMains = findStudentMainClasses();
        if (studentMains.isEmpty()) {
            System.out.println("No student Java classes with main found.");
            System.exit(1);
        }
        String mainClass = null;
        for (String c : studentMains) {
            if (c.equals("T00") || c.endsWith(".T00")) {
                mainClass = c;
                break;
            }
        }
        if (mainClass == null) mainClass = studentMains.get(0);
        System.out.println("Grading main class: " + mainClass);
        int totalScore = 0, maxScore = 0;
        for (int i = 0; i < tests.size(); i++) {
            TestCase t = tests.get(i);
            System.out.println("--- Running test " + (i + 1) + " ---");
            String output = runStudent(mainClass, t.input);
            System.out.println("Student output:\n" + output);
            int s = 0;
            if (containsAll(output, t.expectA)) s += t.scoreA;
            if (containsAll(output, t.expectB)) s += t.scoreB;
            if (containsAll(output, t.expectC)) s += t.scoreC;
            System.out.println(String.format("Score for test %d: %d/%d", i + 1, s, t.scoreA + t.scoreB + t.scoreC));
            totalScore += s;
            maxScore += t.scoreA + t.scoreB + t.scoreC;
        }
        System.out.println("=== Final score: " + totalScore + " / " + maxScore + " ===");
    }

    static boolean containsAll(String output, String expected) {
        if (expected == null || expected.isEmpty()) return true;
        String[] lines = expected.split("\\n");
        for (String l : lines) {
            String t = l.trim();
            if (t.isEmpty()) continue;
            if (!output.contains(t)) return false;
        }
        return true;
    }

    static String runStudent(String mainClass, String input) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "classes", mainClass);
        pb.redirectErrorStream(true);
        Process p = pb.start();
        if (input != null && !input.isEmpty()) {
            try (OutputStream os = p.getOutputStream()) {
                os.write(input.getBytes());
                os.flush();
            } catch (IOException e) {
                // ignore
            }
        }
        StringWriter out = new StringWriter();
        try (InputStream is = p.getInputStream()) {
            int n;
            byte[] buf = new byte[4096];
            while ((n = is.read(buf)) > 0) out.write(new String(buf, 0, n));
        }
        p.waitFor();
        return out.toString();
    }

    static List<TestCase> buildTests() {
        List<TestCase> list = new ArrayList<>();
        TestCase t1 = new TestCase();
        t1.input = "5\\nH001 3 rice\\nH002 2 rice\\nH001 1 beans\\nH003 5 rice\\nH004 4 beans\\n";
        t1.expectA = "Total items = 15";
        t1.expectB = "Distinct households = 4\\nItems per type: rice=10 beans=5\\ninvalid_count = 0";
        t1.expectC = "Households with >3 items: H003(5) H004(4)\\nTop donor(s): H003 (5)";
        list.add(t1);

        TestCase t2 = new TestCase();
        t2.input = "7\\nA1 2 rice\\nA2 -1 beans\\nA3 3 rice\\nA2 3 beans\\nA4 3 rice\\nA5 abc beans\\nA6 3 rice\\n";
        t2.expectA = "Total items = 14";
        t2.expectB = "Distinct households = 5\\nItems per type: rice=11 beans=3\\ninvalid_count = 2";
        t2.expectC = "Top donor(s): A3 A2 A4 A6 (each 3)";
        list.add(t2);

        TestCase t3 = new TestCase();
        t3.input = "4\\nX1 0 rice\\nX2 0 beans\\nX3 -5 rice\\nX4 abc rice\\n";
        t3.expectA = "Total items = 0";
        t3.expectB = "Distinct households = 2\\nItems per type: rice=0 beans=0\\ninvalid_count = 2";
        t3.expectC = "Tidak ada data valid\\ninvalid_count = 2";
        list.add(t3);

        return list;
    }

    static List<String> findStudentMainClasses() throws IOException {
        List<String> mains = new ArrayList<>();
        Path dir = Paths.get("classes");
        if (!Files.exists(dir)) return mains;
        Files.walk(dir).forEach(p -> {
            if (p.toString().endsWith(".class")) {
                try {
                    String className = dir.relativize(p).toString().replace(File.separatorChar, '.');
                    if (className.endsWith(".class")) className = className.substring(0, className.length() - 6);
                    mains.add(className);
                } catch (Exception e) {
                    // ignore
                }
            }
        });
        return mains;
    }
}
