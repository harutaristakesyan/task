package kafka.models.menu;

import kafka.models.base.KafkaBaseModel;
import kafka.models.base.KafkaTextModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MenuKafkaModel extends KafkaBaseModel {

    private String route;
    private String iconName;
    private Boolean isNavBar;
    private Set<KafkaTextModel> names;
    private Set<MenuKafkaModel> children;
}
