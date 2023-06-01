package com.example.demo.entity;

import com.example.demo.validator.annotation.ValidPhongBanId;
import com.example.demo.validator.annotation.ValidUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="NhanVien")
public class NhanVien {
    @Id
    @Column(name = "ma_NV")
    private String Ma_NV;
    @Column(name = "ten_NV")
    private String Ten_NV;
    @Column(name = "Phai")
    private String Phai;
    @Column(name = "Noi_Sinh")
    private String Noi_Sinh;
    @Column(name = "Luong")
    private int Luong;
    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    private PhongBan PhongBan;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @ValidUserId
    private User user;
}
