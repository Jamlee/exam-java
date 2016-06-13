package wsy.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class StudentCourse {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private StudentProfile studentProfile;

    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;

    private String state;


    public void setCourse(Course course)
    {
        this.course = course;
        if (!course.getStudentCourse().contains(this)) {
            Collection<StudentCourse> studentCourses = this.course.getStudentCourse();
            studentCourses.add(this);
            this.course.setStudentCourses(studentCourses);
        }
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public Course getCourse()
    {
        return course;
    }

    public String getState()
    {
        return state;
    }

    public StudentProfile getStudentProfile()
    {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile)
    {
        this.studentProfile = studentProfile;
        if (!studentProfile.getStudentCourses().contains(this)) {
            Collection<StudentCourse> studentCourses = this.studentProfile.getStudentCourses();
            studentCourses.add(this);
            this.studentProfile.setStudentCourses(studentCourses);
        }
    }
}
