package org.ivc.nikstanov;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class KafkaProducerWikimediaApplication  implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerWikimediaApplication.class, args);

    }

    @Autowired
    private WikimediaChangesProducer wikimediaChangesProducer;

    @Override
    public void run(String... args) throws Exception {
        log.info("server started");
        wikimediaChangesProducer.sendMessage();
    }
}