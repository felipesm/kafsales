package com.ifdeveloper.core.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifdeveloper.core.domain.Sale;
import org.apache.kafka.common.serialization.Deserializer;

public class SaleDeserializer implements Deserializer<Sale> {
    @Override
    public Sale deserialize(String topic, byte[] sale) {

        try {
            return new ObjectMapper().readValue(sale, Sale.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
