package org.ivc.nikstanov;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ivc.nikstanov.entity.WikimediaData;
import org.ivc.nikstanov.repository.WikimediaDataRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaDatabaseConsume {

    private WikimediaDataRepository wikimediaDataRepository;

    @KafkaListener(topics = "${application.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message){
        log.info(String.format("Event message received -> %s", message));
        WikimediaData data = new WikimediaData();
        data.setWikiEventData(message);
        wikimediaDataRepository.save(data);
    }

}
