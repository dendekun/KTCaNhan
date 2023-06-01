package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "PhongBan")
public class PhongBan {
    @Id
    @Column(name = "ma_PB")
    private String Ma_Phong;
    @Column(name = "ten_PB")
    private String Ten_Phong;
    @OneToMany(mappedBy = "PhongBan",cascade = CascadeType.ALL)
    private List<NhanVien> nhanViens;
}
