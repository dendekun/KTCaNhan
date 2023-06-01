package com.example.demo.services;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private INhanVienRepository nhanVienRepository;
    public List<NhanVien> getAllStaff(){
        return nhanVienRepository.findAll();
    }
    public NhanVien getStaffId(String Ma_NV){
        return nhanVienRepository.findById(Ma_NV).orElse(null);
    }
    public void addStaff(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }
    public void deleteStaff(String Ma_NV){
        nhanVienRepository.deleteById(Ma_NV);
    }
    public void updateStaff(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }

}
