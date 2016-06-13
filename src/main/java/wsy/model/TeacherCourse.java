package wsy.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class TeacherCourse {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private TeacherProfile teacherProfile;

    @OneToOne(cascade = CascadeType.ALL)
    private Course course;

    public void setCourse(Course course)
    {
        this.course = course;
        if (course.getTeacherCourse() == null)
            this.course.setTeacherCourse(this);
    }

    public Course getCourse()
    {
        return course;
    }

    public TeacherProfile getTeacherProfile()
    {
        return teacherProfile;
    }

    public void setTeacherProfile(TeacherProfile teacherProfile)
    {
        this.teacherProfile = teacherProfile;
        if (!teacherProfile.getTeacherCourses().contains(this)) {
            Collection<TeacherCourse> teacherCourses = this.teacherProfile.getTeacherCourses();
            teacherCourses.add(this);
            this.teacherProfile.setTeacherCourses(teacherCourses);
        }
    }
}
