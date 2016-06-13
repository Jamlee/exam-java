package wsy.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class TeacherProfile {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer timeOfEnrollment;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<TeacherCourse> teacherCourses = new ArrayList<>();

    public void setTeacherCourses(Collection<TeacherCourse> teacherCourses)
    {
        this.teacherCourses = teacherCourses;
        for (TeacherCourse teacherCourse : teacherCourses) {
            if (teacherCourse.getTeacherProfile() == null)
                teacherCourse.setTeacherProfile(this);
        }
    }

    public Collection<TeacherCourse> getTeacherCourses()
    {
        return teacherCourses;
    }

    public void setUser(User user)
    {
        this.user = user;
        if (user.getTeacherProfile() == null)
            this.user.setTeacherProfile(this);
    }

    public User getUser()
    {
        return user;
    }
}
