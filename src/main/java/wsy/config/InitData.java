package wsy.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wsy.model.*;
import wsy.repository.AuthorityRepository;
import wsy.repository.CourseRepository;
import wsy.repository.StudentProfileRepository;
import wsy.repository.UserRepository;
import wsy.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class InitData implements CommandLineRunner{

    private static Logger logger = Logger.getLogger(InitData.class.getName());

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public CourseRepository courseRepository;
    @Autowired
    public AuthorityRepository authorityRepository;
    @Autowired
    public StudentProfileRepository studentProfileRepository;

    @Autowired
    public UserService userService;

    public void run(String ...var) throws Exception
    {
        List<User> users = new ArrayList<>();

        users.add(new User("李进", "123456"));
        users.add(new User("胡新春", "123456"));
        users.add(new User("程宽", "123456"));
        users.add(new User("王龙", "123456"));

        users.add(new User("潘雪峰", "123456"));
        users.add(new User("周方", "123456"));
        users.add(new User("张倩", "123456"));
        users.add(new User("魏妮妮", "123456"));
        users.add(new User("陶广", "123456"));
        users.add(new User("李兵", "123456"));
        users.add(new User("周罗", "123456"));
        users.add(new User("黄高琴", "123456"));

        for (User user : users) {
            userRepository.save(user);
        }

        List<Course> courses = new ArrayList<>();

        courses.add(new Course("操作系统", 12, 2));
        courses.add(new Course("嵌入式操作系统实训", 16, 4));
        courses.add(new Course("Java实训", 23, 2));
        courses.add(new Course("CPP面向对象", 14, 2));
        courses.add(new Course("Word基本操作", 16, 4));
        courses.add(new Course("计算组成原理", 16, 2));
        courses.add(new Course("声乐鉴赏", 21, 2));
        courses.add(new Course("计算机网络安全", 21, 2));
        courses.add(new Course("散打", 23, 2));
        courses.add(new Course("花艺", 21, 2));
        courses.add(new Course("羽毛球", 23, 2));
        courses.add(new Course("网球", 21, 2));
        courses.add(new Course("拳击", 23, 2));
        courses.add(new Course("女子防身术", 21, 2));

        for (Course course : courses) {
            courseRepository.save(course);
        }

        List<Authority> authorities = new ArrayList<>();

        authorities.add(new Authority("ROLE_STUDENT"));
        authorities.add(new Authority("ROLE_TEACHER"));

        for (Authority authority : authorities) {
            authorityRepository.save(authority);
        }

        Authority student = authorityRepository.findByName("ROLE_STUDENT");
        Authority teacher = authorityRepository.findByName("ROLE_TEACHER");


        assignRole("李进", Arrays.asList(student));
        assignRole("胡新春", Arrays.asList(student));
        assignRole("王龙", Arrays.asList(student));
        assignRole("程宽", Arrays.asList(student));

        assignRole("周方", Arrays.asList(teacher));
        assignRole("潘雪峰", Arrays.asList(teacher));

        Long[] id = {1l, 2l, 3l};
        Iterable<Long> ids = Arrays.asList(id);
        Collection<Course> courses1 = courseRepository.findAll(ids);
        assignCourseForStudent("李进", courses1);
        assignCourseForStudent("胡新春", courses1);
        assignCourseForStudent("王龙", courses1);
        assignCourseForStudent("程宽", courses1);

        assignCourseForTeacher("周方", courseRepository.findByName("操作系统"));
        assignCourseForTeacher("潘雪峰", courseRepository.findByName("嵌入式操作系统实训"));
        assignCourseForTeacher("陶广", courseRepository.findByName("Java实训"));
        assignCourseForTeacher("魏妮妮", courseRepository.findByName("CPP面向对象"));
        assignCourseForTeacher("黄高琴", courseRepository.findByName("Word基本操作"));
        assignCourseForTeacher("周罗", courseRepository.findByName("计算组成原理"));
        assignCourseForTeacher("周方", courseRepository.findByName("声乐鉴赏"));
        assignCourseForTeacher("陶广", courseRepository.findByName("计算机网络安全"));
        assignCourseForTeacher("李兵", courseRepository.findByName("散打"));
        assignCourseForTeacher("张倩", courseRepository.findByName("花艺"));
        assignCourseForTeacher("李兵", courseRepository.findByName("羽毛球"));
        assignCourseForTeacher("李兵", courseRepository.findByName("网球"));
        assignCourseForTeacher("李兵", courseRepository.findByName("拳击"));
        assignCourseForTeacher("李兵", courseRepository.findByName("女子防身术"));
    }

    private void assignRole(String name, Collection<Authority> authority)
    {
        User user = userService.loadUserByUsername(name);
        user.setAuthorities(authority);
        userRepository.save(user);
    }

    @Transactional
    private void assignCourseForStudent(String name, Collection<Course> courses)
    {
        User user = userService.loadUserByUsername(name);
        StudentProfile studentProfile = new StudentProfile();
        Collection<StudentCourse> studentCourses = new ArrayList<>();

        for(Course course : courses) {

            StudentCourse studentCourse = new StudentCourse();
            studentCourse.setCourse(course);
            studentCourse.setState("已获得");

            studentCourses.add(studentCourse);
        }

        studentProfile.setStudentCourses(studentCourses);
        user.setStudentProfile(studentProfile);
        userRepository.save(user);

    }

    @Transactional
    private void assignCourseForTeacher(String name, Course course)
    {
        User user = userService.loadUserByUsername(name);
        TeacherProfile teacherProfile = user.getTeacherProfile() != null ?
                user.getTeacherProfile() : new TeacherProfile();

        Collection<TeacherCourse> teacherCourses = new ArrayList<>();
        TeacherCourse teacherCourse = new TeacherCourse();
        teacherCourse.setCourse(course);
        teacherCourse.setTeacherProfile(teacherProfile);

        teacherCourses.add(teacherCourse);

        teacherProfile.setTeacherCourses(teacherCourses);
        user.setTeacherProfile(teacherProfile);
        userRepository.save(user);
    }
}
