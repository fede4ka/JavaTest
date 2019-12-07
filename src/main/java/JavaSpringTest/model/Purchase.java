package JavaSpringTest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Purchase")
@Table(name = "purchases")
@ApiModel(description = "Детали заказа")
public class Purchase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated ID")
    public int id;
    @ApiModelProperty(notes = "Уникальный ключ заказа, должен совпадать с id соответствующего пользователя")
    public int pid;
    @ApiModelProperty(notes = "Уникальный ключ списка покупок")
    public int uid;
    @ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "uid",referencedColumnName = "id",insertable=false, updatable=false)
    @ApiModelProperty(hidden = true)
    public User user;
    @OneToMany(
            mappedBy = "purchase",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ApiModelProperty(notes = "Список товаров входящих в заказ")
    public List<Item> items = new ArrayList<>();
    @ApiModelProperty(hidden = true)
    public Date pdate;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @ApiModelProperty(hidden = true)
    public int getP_id() {
        return pid;
    }
    @ApiModelProperty(hidden = true)
    public void setP_id(int p_id) {
        this.pid = p_id;
    }
    @ApiModelProperty(hidden = true)
    public int getU_id() {
        return uid;
    }
    @ApiModelProperty(hidden = true)
    public void setU_id(int u_id) {
        this.uid = u_id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public Date getPdate() {
        return pdate;
    }
    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }


}
