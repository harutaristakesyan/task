package kafka.models.goods;

import kafka.models.base.KafkaBaseModel;
import kafka.models.base.KafkaFileModel;
import kafka.models.base.KafkaTextModel;
import kafka.models.promotion.PromotionKafkaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GoodsKafkaModel extends KafkaBaseModel implements Serializable {

    private String area;
    private String color;
    private String usage;
    private String finish;
    private String volume;
    private String material;
    private BigDecimal price;
    private String vendorCode;
    private BigDecimal warranty;
    private BigDecimal salePrice;
    private Boolean availability;
    private Set<KafkaTextModel> titles;
    private Set<KafkaFileModel> images;
    private PromotionKafkaModel promotion;
    private GoodCategoryKafkaModel category;
    private Set<KafkaTextModel> descriptions;
    private GoodCollectionKafkaModel collection;
}
