package com.example.springdatajpapostgresql.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "kisi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}) //idler eşit ise iki nesne birbiri ile eşittir
@ToString
public class Kisi implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_kisi", allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, name = "ad")
    private String ad;

    @Column(length = 100, name = "soyad")
    private String soyad;

    @OneToMany
    @JoinColumn(name = "kisi_adres_id")
    private List<Adres> adresList;
}
