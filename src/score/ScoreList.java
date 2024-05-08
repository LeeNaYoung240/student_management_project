package score;

import student.Student;
import store.SubjectStore;

import java.util.ArrayList;

// N수강생들의 모든 Score 객체가 저장되는 클래스, main 클래스에서 프로그램이 동작함과 동시에 초기화가 필요함.
public class ScoreList {
    private ArrayList<Score> scoreStore;

    public ScoreList(){
        scoreStore = new ArrayList<>();
    };

    public void scoreListAdd (Score score) {
        scoreStore.add(score);
    }

    public Score getScoreList (int studentId, int subjectId) {
        for (Score score : scoreStore) {
            if (score.getStudentId() == studentId && score.getSubjectid() == subjectId) {
                return score;
            }
        }
        return null;
    }

    public ArrayList<Score> getScoreStore() {
        return scoreStore;
    }

    public void setScoreList (int studentId, int subjectId, int round, int scoreValue) {
        scoreStore.stream().filter(score -> score.getStudentId() == studentId && score.getSubjectid() == subjectId).forEach(score -> score.setScore(studentId,subjectId,round,scoreValue));
    }

    public void inquiryToScoreList (int studentId, int subjectId) {
        scoreStore.stream().filter(score -> score.getStudentId() == studentId && score.getSubjectid() == subjectId).forEach(score -> score.getScore());
    }
}
