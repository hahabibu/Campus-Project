package com.zstu.pms.audit.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zstu.pms.audit.dto.DeclareTypeDTO;
import com.zstu.pms.audit.service.ApprovalService;
import com.zstu.pms.audit.service.DeclareTypeService;
import com.zstu.pms.declare.dto.DeclareRecordDTO;
import com.zstu.pms.model.DeclareRecord;

@Controller
@RequestMapping("/audit/approval/")
public class ApprovalController {
	
	@Resource(name="approvalServiceImpl")
    private ApprovalService approvalService;
	
	@Resource(name="declareTypeServiceImpl")
	private DeclareTypeService declareTypeService; 

    // 列出申报记录信息
    @RequestMapping("listDeclareRecord.action")
    public String listDeclareRecord(DeclareRecord declareRecord,Model model) {
    	List<DeclareTypeDTO> declareTypeDTOList = declareTypeService.listDeclareType(null);
        List<DeclareRecordDTO> list = approvalService.listDeclareRecord(declareRecord);
        model.addAttribute("list",list);
        model.addAttribute("declareTypeDTOList",declareTypeDTOList);
        return "audit/approval/approval_list";
    }

    // 查询单个申报记录详细信息
    @RequestMapping("showDeclareRecord.action")
    public String showDeclareRecord(String declareId,Model model) {
    	DeclareRecordDTO declareRecordDTO = approvalService.getDTObyModel(approvalService.getDeclareRecord(declareId));
        model.addAttribute("declareRecordDTO", declareRecordDTO);
        return "audit/approval/approval_show";
    }

    // 通过立项检查
    @RequestMapping("passApproval.action")
    public String passApproval(String declareId,String result,Model model) {
        boolean remark = approvalService.setUpProject(declareId, result);
        if(remark) {
            model.addAttribute("info","该记录已通过立项检查");
        }else {
            model.addAttribute("info","申报记录信息修改失败");
        }
        // 修改完成之后跳转到列表页面
        return listDeclareRecord(null, model);
    }
    
    // 立项检查未通过
    @RequestMapping("unPassApproval.action")
    public String unPassApproval(String declareId,String result,Model model) {
    	boolean remark = approvalService.unSetUpProject(declareId, result);
        if(remark) {
            model.addAttribute("info","该记录未通过立项检查");
        }else {
            model.addAttribute("info","申报记录信息修改失败");
        }
        // 修改完成之后跳转到列表页面
        return listDeclareRecord(null, model);
    }
}
