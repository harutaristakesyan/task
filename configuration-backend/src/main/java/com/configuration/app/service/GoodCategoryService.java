package com.configuration.app.service;

import com.configuration.core.data.Void;
import com.configuration.core.supported.AddSupported;
import com.configuration.core.supported.DeleteSupported;
import kafka.models.goods.GoodCategoryKafkaModel;

import java.util.UUID;

public interface GoodCategoryService extends DeleteSupported<UUID, Void>,
        AddSupported<GoodCategoryKafkaModel, Void> {
}
