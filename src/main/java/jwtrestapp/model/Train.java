package jwtrestapp.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trains")
@Data
public class Train extends BaseEntity {
    @Column(name = "train_no")
    private String trainNo;

    @Column(name = "dispatch_place")
    private String dispatchPlace;

    @Column(name = "income_place")
    private String incomePlace;

    @Column(name = "dispatch_time")
    private Date dispatchTime;

    @Column(name = "income_time")
    private Date incomeTime;

    @Column(name = "wagons_plazkart")
    private Integer wagonsPlazkart;

    @Column(name = "wagons_kupe")
    private Integer wagonsKupe;

    @Column(name = "wagons_vip")
    private Integer wagonsVip;
}
