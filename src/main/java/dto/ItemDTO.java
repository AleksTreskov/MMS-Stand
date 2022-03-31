package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private long id;

    private String name;

    private String category;

    private String imgName;

    private String description;

    private String brand;

    private String model;

    private double weight;

    private int quantity;

    private double price;

    private int sold;

}
