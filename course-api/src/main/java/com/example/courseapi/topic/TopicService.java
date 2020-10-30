package com.example.courseapi.topic;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

        List<Topic> topics = new ArrayList<>(Arrays.asList(
                new Topic("spring", "Spring Framework", "Spring Framework Description"),
                new Topic("java", "Core Java", "Core Java Description"),
                new Topic("javascript", "JavaScript Framework", "JavaScript Framework Description")
        ));

        public List<Topic> getALlTopics(){
            return topics;
        }

        public Topic getTopic(String id){
            for (Topic topic : topics) {
                // check if the id is equal to the element id at the index
                if (id.equals(topic.getId())) {
                    return topic;
                }
            }
            return null;
        }

        public void addTopic(Topic topic) {
            topics.add(topic);
        }


    public void updateTopic(String id, Topic topic) {
        for(int index = 0; index < topics.size(); index++) {
            Topic t = topics.get(index);
            // check if the id is equal to the element id at the index
            if (t.getId().equals(id)) {
                topics.set(index, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
        }
}
