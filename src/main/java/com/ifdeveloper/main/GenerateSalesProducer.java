package com.ifdeveloper.main;

import com.ifdeveloper.configuration.KafkaConfiguration;
import com.ifdeveloper.core.domain.Sale;
import com.ifdeveloper.core.enums.PaymentMethod;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static com.ifdeveloper.core.utils.Utils.getIntValue;
import static com.ifdeveloper.core.utils.Utils.getLongValue;
import static com.ifdeveloper.core.utils.Utils.getUUIDValue;

public class GenerateSalesProducer {

    private final static String TOPIC = "sales";

    public static void main(String[] args) {

        var properties = new KafkaConfiguration().getConfigurationProducer();

        var producer = new KafkaProducer<String, Sale>(properties);

        var sales = GenerateSalesProducer.generateSales();

        for (Sale sale: sales) {
            var record = new ProducerRecord<>(TOPIC, getUUIDValue(), sale);
            producer.send(record);
        }

        producer.close();
    }

    private static List<Sale> generateSales() {
        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(getLongValue(), getLongValue(), getIntValue(), new BigDecimal(4031.87).setScale(2, RoundingMode.CEILING), PaymentMethod.CREDIT_CARD));
        sales.add(new Sale(getLongValue(), getLongValue(), getIntValue(), new BigDecimal(1022.30).setScale(2, RoundingMode.CEILING), PaymentMethod.VOUCHER));
        sales.add(new Sale(getLongValue(), getLongValue(), getIntValue(), new BigDecimal(403).setScale(2, RoundingMode.CEILING), PaymentMethod.PIX));
        sales.add(new Sale(getLongValue(), getLongValue(), getIntValue(), new BigDecimal(203.15).setScale(2, RoundingMode.CEILING), PaymentMethod.DEBIT_CARD));
        return sales;
    }
}
