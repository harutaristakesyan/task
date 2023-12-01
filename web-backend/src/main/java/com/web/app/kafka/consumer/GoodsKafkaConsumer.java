package com.web.app.kafka.consumer;


import com.web.app.service.GoodsService;
import kafka.models.base.OperationType;
import kafka.models.goods.GoodsKafkaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoodsKafkaConsumer {

    private final GoodsService goodsService;

    @KafkaListener(topics = "goods")
    public void consume(@Payload final GoodsKafkaModel model) {
        if (model.getOperationType() == OperationType.DELETE) {
            goodsService.delete(model.getId());
            return;
        }
        goodsService.add(model);
    }


}
