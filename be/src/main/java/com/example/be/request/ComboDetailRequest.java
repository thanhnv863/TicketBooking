package com.example.be.request;

import com.example.be.entity.Combo;
import com.example.be.entity.ComboDetail;
import com.example.be.entity.Snacks;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComboDetailRequest {

    private String combo;

    private String snack;

    private Integer quantity;

    public ComboDetail dtoEntity(ComboDetail comboDetail) {
        comboDetail.setCombo(Combo.builder().id(Long.valueOf(this.combo)).build());
        comboDetail.setSnacks(Snacks.builder().id(Long.valueOf(this.snack)).build());
        comboDetail.setQuantity(this.quantity);
        return comboDetail;
    }
}
