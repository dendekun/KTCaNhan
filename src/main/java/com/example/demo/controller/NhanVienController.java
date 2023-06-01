package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.services.NhanVienService;
import com.example.demo.services.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String showAllStaff(Model model){
        List<NhanVien> nhanViens = nhanVienService.getAllStaff();
        model.addAttribute("nhanviens", nhanViens);
        return "nhanvien/list";
    }
    @GetMapping("/add")
    public String addStaffForm(Model model){
        model.addAttribute("nhanvien",new NhanVien());
        model.addAttribute("PhongBans", phongBanService.getAllDepartment());
        return "nhanvien/add";
    }
    @PostMapping("/add")
    public String addStaff(@Valid @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult result, Model model){
        // check lỗi
        if(result.hasErrors()){
            model.addAttribute("PhongBans", phongBanService.getAllDepartment());
            return "nhanvien/add";
        }
        nhanVienService.addStaff(nhanVien);
        return "redirect:/nhanviens";
    }
    @GetMapping("/delete/{ma_NV}")
    public String deleteStaff(@PathVariable("ma_NV") String ma_NV){
        nhanVienService.deleteStaff(ma_NV);
        return "redirect:/nhanviens";
    }
    @GetMapping("edit/{ma_NV}")
    public String editStaffForm(@PathVariable("ma_NV")String ma_NV, Model model){
        NhanVien editStaff = nhanVienService.getStaffId(ma_NV);
        if (editStaff != null ){
            model.addAttribute("nhanvien",editStaff);
            model.addAttribute("PhongBans", phongBanService.getAllDepartment());
            return "nhanvien/edit";
        }else {
            return "redirect:/nhanviens";
        }
    }

    @PostMapping("edit/{ma_NV}")
    public String editNhanVien(@PathVariable("ma_NV")String ma_NV, @ModelAttribute("nhanvien") @Valid NhanVien editStaff, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("PhongBans", phongBanService.getAllDepartment());
            return "nhanvien/edit";
        }else {
            NhanVien existingNhanVien = nhanVienService.getStaffId(ma_NV);
            if ( existingNhanVien != null){
                existingNhanVien.setTen_NV(editStaff.getTen_NV());
                existingNhanVien.setPhai(editStaff.getPhai());
                existingNhanVien.setNoi_Sinh(editStaff.getNoi_Sinh());
                existingNhanVien.setLuong(editStaff.getLuong());
                existingNhanVien.setPhongBan((editStaff.getPhongBan()));
                nhanVienService.updateStaff(existingNhanVien);
            }
            return "redirect:/nhanviens";
        }
    }

}
