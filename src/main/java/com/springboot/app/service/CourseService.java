package com.springboot.app.service;

import com.springboot.app.repository.CourseRepository;
import com.springboot.app.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    /*private  List<Course> courses = new ArrayList<>( Arrays.asList(
            new Course("Spring", "Spring boot", "Spring boot description", ""),
            new Course("java", "java core", "java core description", ""),
            new Course("javascript", "javascript core", "javascript core description", "")
    ));*/

    public List<Course> getAllCourses(String topicId){
        //return topics;
        /*List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);*/
        return courseRepository.findByTopicId(topicId);
    }

    public Course getCourse (String id){
        //return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course) {
        //topics.add(topic);
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        /*for (int i = 0; i < topics.size(); i++){
            Topic t = topics.get(i);
            if (t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }*/
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);
    }
}
