package guru.springframework.spring7restmvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
//@AllArgsConstructor(onConstructor_ = {@JsonCreator}) // better use that one below!
@JsonDeserialize(builder = Beer.BeerBuilder.class)
public class Beer {

    private UUID id;
    private Integer version;
    @JsonProperty("beerName")
    private String beerName;
    private BeerStyle beerStyle;
    private String upc;
    private Integer quantityOnHand;
    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
