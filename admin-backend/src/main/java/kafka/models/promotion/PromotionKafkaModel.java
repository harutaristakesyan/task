package kafka.models.promotion;

import kafka.models.base.KafkaBaseModel;
import kafka.models.base.KafkaTextModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PromotionKafkaModel extends KafkaBaseModel implements Serializable {

    private String route;
    private Set<KafkaTextModel> texts;

}
