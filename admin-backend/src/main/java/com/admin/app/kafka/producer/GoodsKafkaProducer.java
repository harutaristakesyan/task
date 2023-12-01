package com.admin.app.kafka.producer;

import com.admin.core.data.Void;
import com.admin.core.supported.AddSupported;
import com.admin.core.supported.DeleteSupported;
import kafka.models.goods.GoodsKafkaModel;

public interface GoodsKafkaProducer extends AddSupported<GoodsKafkaModel, Void>,
        DeleteSupported<GoodsKafkaModel, Void> {

}
