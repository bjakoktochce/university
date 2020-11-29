/*
 * 2.2 Program sedziowski
 * 
 * Bartosz Jakoktochce 
 */

package semester_I;

import java.util.*;

public class ProgramSedziowski {

    static Scanner reader = new Scanner(System.in);

    public static double getJudgeScore(int judge) {
        double score = 0;

        do {
            System.out.print("Score for judge " + judge + " (score must be between 0 and 10): ");

            score = reader.nextDouble();
            reader.nextLine();

            if (score < 0)
                System.out.println("*** ERROR: The score can not be negative. Please enter value between 0 and 10.\n");
            if (score > 10)
                System.out.println(
                        "***ERROR: The score can not be greater than 10. Please enter value between 0 and 10.\n");

        } while ((score < 0) || (score > 10));

        return score;
    }

    public static int getNumberOfJudges() {
        int numberOfJudges;
        boolean properNumberOfJudges = false;

        do {
            System.out.print("Enter number of judges between 3 and 10: ");
            numberOfJudges = reader.nextInt();
            reader.nextLine();

            properNumberOfJudges = (numberOfJudges >= 3) && (numberOfJudges <= 10);

            if (!properNumberOfJudges)
                System.out.println("*** ERROR: The number of judges must be between 3 and 10! ***\n");
        } while (!properNumberOfJudges);

        return numberOfJudges;
    }

    public static void main(String[] args) {

        System.out.println("This simple program helps judges to calculate scores for competitors.\n");

        int numberOfJudges = 0, judgeCount = 0;
        double score = 0, totalScore, maxScore, minScore, averageScore = 0;
        char exitOrNot;

        do {
            totalScore = maxScore = minScore = 0;

            numberOfJudges = getNumberOfJudges();

            for (judgeCount = 1; judgeCount <= numberOfJudges; judgeCount++) {
                score = getJudgeScore(judgeCount);

                // if this is the first loop run assign the first entered value as minimum one
                // to overwrite initialized value
                if (judgeCount == 1)
                    minScore = score;

                maxScore = (score > maxScore) ? score : maxScore;
                minScore = (score < minScore) ? score : minScore;

                totalScore += score;
            }

            System.out.println("* Dropping minimum score value: " + minScore);
            System.out.println("* Dropping maximum score value: " + maxScore);

            // if all scores are NOT EQUAL drop minimum and maximum scores from 2 judges
            if (minScore != maxScore) {
                numberOfJudges -= 2;
                totalScore = totalScore - minScore - maxScore;
            }
            averageScore = totalScore / (numberOfJudges);

            System.out.println("* Total average score from " + (numberOfJudges) + " judge(s) for this competitor: "
                    + averageScore);

            System.out.print("Do you want to play once again? y/n : ");
            exitOrNot = reader.next().charAt(0);

        } while (exitOrNot != 'n');

        System.out.println("\nThank you for using this simple score-board calculator.");
    }
}
