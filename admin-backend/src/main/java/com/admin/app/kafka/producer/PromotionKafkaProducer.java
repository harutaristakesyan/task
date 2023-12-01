package com.admin.app.kafka.producer;

import com.admin.core.data.Void;
import com.admin.core.supported.AddSupported;
import com.admin.core.supported.DeleteSupported;
import kafka.models.promotion.PromotionKafkaModel;

public interface PromotionKafkaProducer extends AddSupported<PromotionKafkaModel, Void>,
        DeleteSupported<PromotionKafkaModel, Void> {

}
