package org.ivc.nikstanov;

import com.launchdarkly.eventsource.ConnectStrategy;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@AllArgsConstructor
public class WikimediaChangesProducer {


    private String topic;
    private OkHttpClient httpClient;
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(){
        BackgroundEventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        try (BackgroundEventSource source = new BackgroundEventSource.Builder(eventHandler, new EventSource.Builder(
                ConnectStrategy.http(URI.create(url)).httpClient(httpClient)
        )).build()) {
            source.start();
            log.info("Event started");
            TimeUnit.MINUTES.sleep(10);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
