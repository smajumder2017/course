package com.learnsageway.course.course_api.Topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {

  @Autowired
  private TopicDao topicDao;

  private List<Topic> topics = new ArrayList<>();

  @Override
  public List<Topic> getAllTopics() {
    topicDao.findAll().forEach(topics::add);
    return topics;
  }

  @Override
  public Topic getTopicById(Long id) {
    return topicDao.findById(id).get();
  }

  @Override
  public Topic addTopic(Topic topic) {
    topicDao.save(topic);
    return topic;
  }

  @Override
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
