/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/17/2020
 **************************************************************************** */

/**
 * Main
 * Take the name of a file as a command-line argument.
 * Read the genetic sequence from the file using the In class.
 * Remove any whitespace (spaces, tabs, and newlines).
 * Count the number of CAG repeats.
 * Print a medical diagnosis in the format below.
 */

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int n = dna.length();
        int maxCount = 0;
        int count = 0;

        int i = 0;
        while (i < n - 3) {
            if (dna.charAt(i) == 'C') {
                String condon = dna.substring(i, i + 3);
                if (condon.equals("CAG")) {
                    count++;
                    maxCount = Math.max(count, maxCount);
                    i += 3;
                    continue;
                }
            }
            count = 0;
            i++;
        }
        return maxCount;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        return s.replace("\n", "").replace("\t", "").replace(" ", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9 || maxRepeats >= 181) return "not human\n";
        if (maxRepeats <= 35) return "normal\n";
        if (maxRepeats <= 39) return "high risk\n";
        return "Huntington’s\n";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);

        String data = in.readAll();
        String dna = removeWhitespace(data);
        int maxRepeats = maxRepeats(dna);

        StdOut.println("max repeats = " + maxRepeats);
        StdOut.println(diagnose(maxRepeats));
    }
}
