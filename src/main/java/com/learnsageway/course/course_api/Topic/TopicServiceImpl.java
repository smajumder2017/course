package com.learnsageway.course.course_api.Topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TopicServiceImpl implements TopicService {

  @Autowired
  private TopicDao topicDao;

  private List<Topic> topics = new ArrayList<>();

  @Override
  public List<Topic> getAllTopics() {
    topicDao.findAll().forEach(topics::add);
    log.info("Working");
    return topics;
  }

  @Override
  public Topic getTopicById(Long id) {
    Optional<Topic> topic = topicDao.findById(id);
    if (topic.isPresent()) {
      return topic.get();
    }
    throw new RuntimeException("Topic Not Found");
  }

  @Override
  public Topic addTopic(Topic topic) {
    topicDao.save(topic);
    return topic;
  }

  @Override
  public Topic updateTopicById(Long id, Topic topic) {

    Topic t = this.getTopicById(id);
    t.setId(id);
    t.setName(topic.getName());
    t.setDescription(t.getDescription());

    Topic newTopic = topicDao.save(t);
    return newTopic;
  }

  public void removeTopicById(Long id) {
    topicDao.deleteById(id);
  }

}
