package com.zstu.pms.audit.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zstu.pms.audit.dto.DeclareTypeDTO;
import com.zstu.pms.audit.service.DeclareTypeService;
import com.zstu.pms.audit.service.MidCheckService;
import com.zstu.pms.declare.dto.DeclareRecordDTO;
import com.zstu.pms.model.DeclareRecord;

@Controller
@RequestMapping("/audit/midcheck/")
public class MidCheckController {
	
	@Resource(name="midCheckServiceImpl")
    private MidCheckService midCheckService;
	
	@Resource(name="declareTypeServiceImpl")
	private DeclareTypeService declareTypeService; 

    // 列出申报记录信息
    @RequestMapping("listDeclareRecord.action")
    public String listDeclareRecord(DeclareRecord declareRecord,Model model) {
    	List<DeclareTypeDTO> declareTypeDTOList = declareTypeService.listDeclareType(null);
        List<DeclareRecordDTO> list = midCheckService.listDeclareRecord(declareRecord);
        model.addAttribute("list",list);
        model.addAttribute("declareTypeDTOList",declareTypeDTOList);
        return "audit/midcheck/midcheck_list";
    }

    // 查询单个申报记录详细信息
    @RequestMapping("showDeclareRecord.action")
    public String showDeclareRecord(String declareId,Model model) {
    	DeclareRecordDTO declareRecordDTO = midCheckService.getDTObyModel(midCheckService.getDeclareRecord(declareId));
        model.addAttribute("declareRecordDTO", declareRecordDTO);
        return "audit/midcheck/midcheck_show";
    }

    // 通过中期检查
    @RequestMapping("passMidCheck.action")
    public String passMidCheck(String declareId,String result,Model model) {
        boolean remark = midCheckService.PassMidCheck(declareId, result);
        if(remark) {
            model.addAttribute("info","该记录已通过中期检查");
        }else {
            model.addAttribute("info","申报记录信息修改失败");
        }
        // 修改完成之后跳转到列表页面
        return listDeclareRecord(null, model);
    }
    
    // 中期检查未通过
    @RequestMapping("unPassMidCheck.action")
    public String unPassMidCheck(String declareId,String result,Model model) {
    	boolean remark = midCheckService.unPassMidCheck(declareId, result);
        if(remark) {
            model.addAttribute("info","该记录未通过中期检查");
        }else {
            model.addAttribute("info","申报记录信息修改失败");
        }
        // 修改完成之后跳转到列表页面
        return listDeclareRecord(null, model);
    }
}
