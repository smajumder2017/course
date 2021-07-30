package com.learnsageway.course.course_api.Topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {

  @Autowired
  private TopicService topicService;

  @RequestMapping("")
  public List<Topic> getAllTopic() {
    return topicService.getAllTopics();
  }

  @RequestMapping("/{id}")
  public Topic getTopic(@PathVariable Long id) {

    return topicService.getTopicById(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/")
  public Topic addNewTopic(@RequestBody Topic topic) {
    return topicService.addTopic(topic);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
  public Topic updateTopic(@PathVariable Long id, @RequestBody Topic topic) {
    return topicService.updateTopicById(id, topic);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public void deleteTopic(@PathVariable Long id) {
    topicService.removeTopicById(id);
  }

}
