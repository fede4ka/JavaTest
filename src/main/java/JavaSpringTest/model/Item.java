package JavaSpringTest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity(name = "Item")
@Table(name = "items")
@ApiModel(description = "Список товаров")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated ID")
    public int id;
    @ApiModelProperty(notes = "Уникальный ключ товара, должен совпадать с id соответствующего заказа")
    public int ig_id;
    @ApiModelProperty(notes = "Название товара")
    public String name;
    @ApiModelProperty(notes = "Цена товара")
    public Double price;
    @ApiModelProperty(notes = "Количество товара")
    public int count;
    @ManyToOne(targetEntity = Purchase.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "ig_id", referencedColumnName = "pid",insertable=false, updatable=false)
    @ApiModelProperty(hidden = true)
    private Purchase purchase;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIg_id() {
        return ig_id;
    }

    public void setIg_id(int ig_id) {
        this.ig_id = ig_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return count+" "+ name +" " + "за"+" " + price;
    }
}
