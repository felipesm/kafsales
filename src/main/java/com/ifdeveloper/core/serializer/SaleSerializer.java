package com.ifdeveloper.core.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifdeveloper.core.domain.Sale;
import org.apache.kafka.common.serialization.Serializer;

public class SaleSerializer implements Serializer<Sale> {
    @Override
    public byte[] serialize(String s, Sale sale) {
        try {
            return new ObjectMapper().writeValueAsBytes(sale);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
