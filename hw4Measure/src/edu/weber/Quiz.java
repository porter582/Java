package edu.weber;

public class Quiz implements  Measurable{
    private int score; //numeric grade
    private String grade; //alpha grade

    public void setScore(int score) { //set the numeric score
        this.score = score;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public double getMeasure()
    {
        return this.score;
    };

    public int getScore()
    {
        return this.score;
    }
}
