package sample;


public class StudentRecord {
    private String id;
    private float midterm;
    private float assignments;
    private float exam;
    private double final_mark;
    private char grade_letter;

    // Constructor
    StudentRecord(String id, float assgn, float mt, float exam) {
        this.id = id;
        this.midterm = mt;
        this.assignments = assgn;
        this.exam = exam;
        this.final_mark = getFinalmark();
        this.grade_letter = getLettergrade();
    }

    public String getId() {
        return this.id;
    }

    public Float getMidterm() {
        return this.midterm;
    }

    public Float getAssignments() {
        return this.assignments;
    }

    public Float getExam() {
        return this.exam;
    }

    public Double getFinalmark() {
        return (this.midterm * 0.3) + (this.assignments * 0.2) + (this.exam * 0.5);
    }

    public Character getLettergrade() {
        if (final_mark < 50) {
            return 'F';
        } else if (final_mark < 60) {
            return 'D';
        } else if (final_mark < 70) {
            return 'C';
        } else if (final_mark < 80) {
            return 'B';
        } else {
            return 'A';
        }
    }


}
