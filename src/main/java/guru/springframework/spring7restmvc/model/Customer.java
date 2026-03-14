package guru.springframework.spring7restmvc.model;

import lombok.Builder;
import lombok.Data;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
//@AllArgsConstructor(onConstructor_ = {@JsonCreator})
@JsonDeserialize(builder = Customer.CustomerBuilder.class)
public class Customer {

    private UUID id;
    private Integer version;
    private String customerName;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
