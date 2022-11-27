package com.example.springbootapidocs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Pet Nesnesi", description = "pet")
public class Pet {

    @ApiModelProperty(value = "pet nesnesinin id alanı")
    private int id;

    @ApiModelProperty(value = "pet nesnesinin ad alanı")
    private String ad;

    @ApiModelProperty(value = "pet nesnesinin tarih alanı")
    private Date Tarih;
}
