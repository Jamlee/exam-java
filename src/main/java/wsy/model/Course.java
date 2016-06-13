package wsy.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer classHour;
    private Integer score;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<StudentCourse> studentCourses =  new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private TeacherCourse teacherCourse;

    protected Course() {}

    public Course(String name, Integer classHour, Integer score) {
        this.name = name;
        this.classHour = classHour;
        this.score = score;
    }

    public String getName()
    {
        return name;
    }

    public Integer getClassHour()
    {
        return  classHour;
    }

    public void setStudentCourses(Collection<StudentCourse> studentCourses)
    {
        this.studentCourses = studentCourses;
        for (StudentCourse studentCourse : this.studentCourses)
            if (studentCourse.getCourse() == null ) {
                studentCourse.setCourse(this);
            }
    }

    public  void setTeacherCourse(TeacherCourse teacherCourse)
    {
        this.teacherCourse = teacherCourse;
        if (teacherCourse.getCourse() == null )
            this.teacherCourse.setCourse(this);
    }

    public Collection<StudentCourse> getStudentCourse()
    {
        return studentCourses;
    }

    public TeacherCourse getTeacherCourse()
    {
        return teacherCourse;
    }

    public Integer getScore()
    {
        return score;
    }
}
