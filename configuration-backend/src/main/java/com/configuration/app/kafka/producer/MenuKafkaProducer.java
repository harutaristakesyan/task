package com.configuration.app.kafka.producer;

import com.configuration.core.data.Void;
import com.configuration.core.supported.AddSupported;
import com.configuration.core.supported.DeleteSupported;
import kafka.models.menu.MenuKafkaModel;

public interface MenuKafkaProducer extends AddSupported<MenuKafkaModel, Void>,
        DeleteSupported<MenuKafkaModel, Void> {
}
