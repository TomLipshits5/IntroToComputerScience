package com;

public class Student {
    private String studentName;
    protected Link<Course> gradesList;

    public Student(String studentName){
        this.studentName = studentName;
    }

    protected Link whereIs(String courseName){
        Link answerLink = null;
        for (Link<Course> current = gradesList ; current !=null; current = current.next){
            if (current.data.courseName.compareTo(courseName) == 0){
                answerLink = current;
                current = null;
            }
        }
        return answerLink;
    }

    public void insertGrade(String courseName,int grade){
        boolean contains = false;
        for (Link<Course> current = gradesList; current!=null && !contains ;current =current.next){
            if (current.data.courseName.compareTo(courseName) == 0){
                current.data.grade = grade;
                contains = true;
            }
        }
        if(!contains){
            Course course = new Course(courseName,grade);
            Link<Course> newLink= new Link<Course>(course,gradesList);
            gradesList = newLink;
        }
    }

    public int avarageGrade(){
        if (gradesList!=null){
            int ans = 0;
            int counter = 0;
            for (Link<Course> current = gradesList;current !=null; current=current.next){
                ans = ans + current.data.grade;
                counter++;
            }
            return ans/counter;
        }
        return 0;
    }

    public static Student studentBest(Link<Student> studentsList){
        Student best = null;
        int maxAvarage=0;
        for (Link<Student> current = studentsList; current != null; current = current.next){
            if (current.data.avarageGrade()>maxAvarage){
                best = current.data;
            }
        }
        return best;
    }
}
