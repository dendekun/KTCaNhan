package com.example.demo.services;

import com.example.demo.entity.PhongBan;
import com.example.demo.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository phongBanRepository;
    public List<PhongBan> getAllDepartment(){ return phongBanRepository.findAll();}
    public PhongBan getDepartmentById(String id){return phongBanRepository.findById(id).orElse(null);}
    public PhongBan saveDepartment(PhongBan phongBan) { return phongBanRepository.save(phongBan);}
    public void deleteDepartment(String id){ phongBanRepository.deleteById(id);}
}
