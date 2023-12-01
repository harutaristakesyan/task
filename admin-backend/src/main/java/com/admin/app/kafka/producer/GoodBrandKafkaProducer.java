package com.admin.app.kafka.producer;

import com.admin.core.data.Void;
import com.admin.core.supported.AddSupported;
import com.admin.core.supported.DeleteSupported;
import kafka.models.goods.GoodBrandKafkaModel;
import kafka.models.goods.GoodCategoryKafkaModel;

public interface GoodBrandKafkaProducer extends AddSupported<GoodBrandKafkaModel, Void>,
        DeleteSupported<GoodBrandKafkaModel, Void> {

}
