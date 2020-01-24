package ru.dvilnikov.springinaction.shavacloud;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private Date placedAt;
    @NotBlank(message = "Это обязательное поле")
    private String street;
    @NotBlank(message = "Это обязательное поле")
    private String city;
    @CreditCardNumber(message = "Что-то не так с цифрами. Введите номер карты корректно.")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Дата должна быть в формате ММ/ГГ")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "CVV некорректный")
    private String ccCVV;
    @OneToMany(targetEntity = Shava.class)
    private List<Shava> shavaList = new ArrayList<>();

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

    public void addShava(Shava shava){
        this.shavaList.add(shava);
    }
}
