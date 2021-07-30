package com.learnsageway.course.course_api.Topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

  @Autowired
  private TopicDao topicDao;

  private List<Topic> topics = new ArrayList<>();

  public List<Topic> getAllTopics() {

    topicDao.findAll().forEach(topics::add);

    return topics;
  }

  public Topic getTopicById(Long id) {
    return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
  }

  public Topic addTopic(Topic topic) {
    topics.add(topic);
    return topic;
  }

  public Topic updateTopicById(Long id, Topic topic) {

    for (int i = 0; i < topics.size(); i++) {
      Topic t = topics.get(i);
      if (t.getId().equals(id)) {
        topics.set(i, topic);
      }
    }

    return topic;
  }

  public void removeTopicById(Long id) {
    topics.removeIf(t -> t.getId().equals(id));
  }

}
