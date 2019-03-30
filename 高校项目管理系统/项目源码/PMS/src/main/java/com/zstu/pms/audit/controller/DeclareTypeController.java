package com.zstu.pms.audit.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zstu.pms.audit.dto.DeclareTypeDTO;
import com.zstu.pms.audit.service.DeclareTypeService;
import com.zstu.pms.model.DeclareType;
import com.zstu.pms.utils.ConstantUtils;

@Controller
@RequestMapping("/audit/declaretype/")
public class DeclareTypeController {
	
	@Resource(name="declareTypeServiceImpl")
    private DeclareTypeService declareTypeService;

    // 添加申报记录类型信息
    @RequestMapping("addDeclareTypeUI.action")
    public String addDeclareTypeUI(DeclareType declareType, Model model) {
        // 跳转到添加申报记录类型页面
        return "audit/declaretype/declaretype_add";
    }

    // 添加申报记录类型信息
    @RequestMapping("addDeclareType.action")
    public String addDeclareType(DeclareType declareType, Model model) {
        declareType.setTypeId(UUID.randomUUID().toString().replace("-",""));
        declareType.setDelTag(ConstantUtils.DEL_TAG_SAVE);
        boolean remark = declareTypeService.saveDeclareType(declareType);
        if(remark) {
            model.addAttribute("info","申报记录类型信息添加成功");
        }else {
            model.addAttribute("info","申报记录类型信息添加失败");
        }
        // 添加完成之后跳转到列表页面
        return listDeclareType(null, model);
    }

    // 列出申报记录类型信息
    @RequestMapping("listDeclareType.action")
    public String listDeclareType(DeclareTypeDTO declareTypeDTO,Model model) {
        List<DeclareTypeDTO> list = declareTypeService.listDeclareType(declareTypeDTO);
        model.addAttribute("list",list);
        return "audit/declaretype/declaretype_list";
    }

    // 查询单个申报记录类型详细信息
    @RequestMapping("showDeclareType.action")
    public String showDeclareType(String typeId,Model model) {
        DeclareType declareType = declareTypeService.getDeclareType(typeId);
        DeclareTypeDTO declareTypeDTO = declareTypeService.getDTOByModel(declareType);
        model.addAttribute("declareType", declareTypeDTO);
        return "audit/declaretype/declaretype_show";
    }

    // 获取要修改申报记录类型信息进行数据回显
    @RequestMapping("updateDeclareTypeUI.action")
    public String updateDeclareTypeUI(String typeId,Model model) {
        // 根据id查找申报记录类型信息，并将数据回显
        DeclareType declareType = declareTypeService.getDeclareType(typeId);
        model.addAttribute("declareType", declareType);
        return "audit/declaretype/declaretype_update";
    }

    // 修改申报记录类型信息
    @RequestMapping("updateDeclareType.action")
    public String updateDeclareType(DeclareType declareType,Model model) {
        boolean remark = declareTypeService.updateDeclareType(declareType);
        if(remark) {
            model.addAttribute("info","申报记录类型信息修改成功");
        }else {
            model.addAttribute("info","申报记录类型信息修改失败");
        }
        // 修改完成之后跳转到列表页面
        return listDeclareType(null, model);
    }

    // 删除申报记录类型信息
    @RequestMapping("deleteDeclareType.action")
    public String deleteDeclareType(@Param(value="typeId")String typeId, Model model) {
        // 此处是根据id先查找到指定的申报记录类型信息在进行操作
        DeclareType declareType = declareTypeService.getDeclareType(typeId);
        declareType.setDelTag(ConstantUtils.DEL_TAG_DELETE);
        // 此处删除申报记录类型是通过修改申报记录类型状态为0作为删除，而非真正意义上的删除
        boolean remark = declareTypeService.updateDeclareType(declareType);
        if(remark) {
            model.addAttribute("info","申报记录类型信息删除成功");
        }else {
            model.addAttribute("info","申报记录类型信息删除失败");
        }
        // 修改完成之后跳转到列表页面
        return listDeclareType(null, model);
    }
}
