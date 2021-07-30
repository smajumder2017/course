package com.learnsageway.course.course_api.Hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @RequestMapping("/hello")
  public String sayHi() {

    return "Hi Spring Boot !!";
  }

}
