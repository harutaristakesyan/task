package kafka.models.goods;

import kafka.models.base.KafkaBaseModel;
import kafka.models.base.KafkaFileModel;
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
public class GoodBrandKafkaModel extends KafkaBaseModel implements Serializable {

    private String name;

    private String route;

    private String countryOfOrigin;

    private KafkaFileModel logo;

    private Set<KafkaTextModel> descriptions;

}
