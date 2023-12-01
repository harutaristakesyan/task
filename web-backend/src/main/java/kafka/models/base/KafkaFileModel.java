package kafka.models.base;

import java.io.Serializable;

public record KafkaFileModel(String id, String name, String type) implements Serializable {
}
