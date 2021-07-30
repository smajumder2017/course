package com.learnsageway.course.course_api.Topic;

import java.util.List;

public interface TopicService {
  public List<Topic> getAllTopics();

  public Topic getTopicById(Long id);

  public Topic addTopic(Topic topic);

  public Topic updateTopicById(Long id, Topic topic);

  public void removeTopicById(Long id);
}
