package com.springboot.app.controller;

import com.springboot.app.model.Topic;
import com.springboot.app.model.Course;
import com.springboot.app.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    //Trae todos los datos que se encuentran
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    }
    //trae solo un dato en especifico indicado por el id
    @RequestMapping("/topics/{topicId}/courses/{Id}")
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }
    //agrega un nuevo valor
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }
    //actualiza un valor en especifico indicado por el id
    @RequestMapping(method = RequestMethod.PUT, value = "/topics//{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }
    //elimina un valor es especifico indicado por el id
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics//{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
