package com.zstu.pms.audit.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zstu.pms.audit.service.EndCheckService;
import com.zstu.pms.declare.dto.DeclareRecordDTO;
import com.zstu.pms.model.DeclareRecord;

@Controller
@RequestMapping("/audit/endcheck/")
public class EndCheckController {
	
	@Resource(name="endCheckServiceImpl")
    private EndCheckService endCheckService;

    // 列出申报记录信息
    @RequestMapping("listDeclareRecord.action")
    public String listDeclareRecord(DeclareRecord declareRecord,Model model) {
        List<DeclareRecordDTO> list = endCheckService.listDeclareRecord(declareRecord);
        model.addAttribute("list",list);
        return "audit/endcheck/endcheck_list";
    }

    // 查询单个申报记录详细信息
    @RequestMapping("showDeclareRecord.action")
    public String showDeclareRecord(String declareId,Model model) {
    	DeclareRecordDTO declareRecordDTO = endCheckService.getDTObyModel(endCheckService.getDeclareRecord(declareId));
        model.addAttribute("declareRecordDTO", declareRecordDTO);
        return "audit/endcheck/endcheck_show";
    }

    // 通过结题验收
    @RequestMapping("passMidCheck.action")
    public String passMidCheck(String declareId,String result,Model model) {
        boolean remark = endCheckService.passEndCheck(declareId, result);
        if(remark) {
            model.addAttribute("info","该记录已通过结题验收");
        }else {
            model.addAttribute("info","申报记录信息修改失败");
        }
        // 修改完成之后跳转到列表页面
        return listDeclareRecord(null, model);
    }
    
    // 结题验收未通过
    @RequestMapping("unPassMidCheck.action")
    public String unPassMidCheck(String declareId,String result,Model model) {
    	boolean remark = endCheckService.unPassEndCheck(declareId, result);
        if(remark) {
            model.addAttribute("info","该记录未通过结题验收");
        }else {
            model.addAttribute("info","申报记录信息修改失败");
        }
        // 修改完成之后跳转到列表页面
        return listDeclareRecord(null, model);
    }
}
