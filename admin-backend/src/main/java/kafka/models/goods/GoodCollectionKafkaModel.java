package kafka.models.goods;

import kafka.models.base.KafkaBaseModel;
import kafka.models.base.KafkaFileModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GoodCollectionKafkaModel extends KafkaBaseModel implements Serializable {

    private String name;
    private String route;
    private KafkaFileModel catalog;
    private GoodBrandKafkaModel brand;

}
