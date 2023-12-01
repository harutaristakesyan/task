package com.web.app.kafka.consumer;


import com.web.app.service.GoodCategoryService;
import kafka.models.base.OperationType;
import kafka.models.goods.GoodCategoryKafkaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoodsCategoriesKafkaConsumer {


    private final GoodCategoryService goodCategoryService;

    @KafkaListener(topics = "goodsCategories")
    public void consume(@Payload final GoodCategoryKafkaModel model) {
        if (model.getOperationType() == OperationType.DELETE) {
            goodCategoryService.delete(model.getId());
            return;
        }
        goodCategoryService.add(model);
    }

}
