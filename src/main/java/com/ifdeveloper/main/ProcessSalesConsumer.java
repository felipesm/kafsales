package com.ifdeveloper.main;

import com.ifdeveloper.configuration.KafkaConfiguration;
import com.ifdeveloper.core.domain.Sale;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;

public class ProcessSalesConsumer {

    private final static String TOPIC = "sales";

    public static void main(String[] args) {

        var properties = new KafkaConfiguration().getConfigurationConsumer();

        var consumer = new KafkaConsumer<String, Sale>(properties);

        consumer.subscribe(Arrays.asList(TOPIC));

        while (true) {
            ConsumerRecords<String, Sale> sales = consumer.poll(Duration.ofMillis(300));

            for (ConsumerRecord<String, Sale> record: sales) {
                String sale = String.format("Key: %s - Sale: %s", record.key(), record.value());
                System.out.println(sale);
            }
        }
    }
}
