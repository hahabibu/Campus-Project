package com.zstu.pms.system.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zstu.pms.model.DataDictionary;
import com.zstu.pms.system.service.DataDictionaryService;

@Controller
@RequestMapping("/system/datadictionary/")
public class DataDictionaryController {

	// 记录日志信息
	private static final Logger LOGGER = Logger.getLogger(DataDictionaryController.class);
	private StringBuilder sb = new StringBuilder();

	@Resource(name = "dataDictionaryServiceImpl")
	private DataDictionaryService dataDictionaryService;

	// 添加数据字典信息
	@RequestMapping("addDataDictionaryUI.action")
	public String addDataDictionaryUI(DataDictionary dataDictionary, Model model) {
		// 跳转到添加数据字典页面
		sb.append("跳转页面到添加数据字典页面");
		LOGGER.info(sb.toString());
		return "system/datadictionary/datadictionary_add";
	}

	// 添加数据字典信息
	@RequestMapping("addDataDictionary.action")
	public String addDataDictionary(DataDictionary dataDictionary, Model model) {
		dataDictionary.setDataId(UUID.randomUUID().toString().replace("-", ""));
		boolean remark = dataDictionaryService.saveDataDictionary(dataDictionary);
		if (remark) {
			model.addAttribute("info", "数据字典信息添加成功");
		} else {
			model.addAttribute("info", "数据字典信息添加失败");
		}
		// 添加完成之后跳转到列表页面
		return listDataDictionary(null, model);
	}

	// 列出数据字典信息
	@RequestMapping("listDataDictionary.action")
	public String listDataDictionary(DataDictionary dataDictionary, Model model) {
		// 将所有的数据类型传入页面
		List<String> dataTypeList = dataDictionaryService.getAllDataType();
		List<DataDictionary> dataDictionaryList = dataDictionaryService.listDataDictionary(dataDictionary);
		model.addAttribute("dataDictionaryList", dataDictionaryList);
		model.addAttribute("dataTypeList", dataTypeList);
		return "system/datadictionary/datadictionary_list";
	}

	// 查询单个数据字典详细信息
	@RequestMapping("showDataDictionary.action")
	public String showDataDictionary(String userId, Model model) {
		DataDictionary dataDictionary = dataDictionaryService.getDataDictionary(userId);
		model.addAttribute("dataDictionary", dataDictionary);
		return "system/datadictionary/datadictionary_show";
	}

	// 获取要修改数据字典信息进行数据回显
	@RequestMapping("updateDataDictionaryUI.action")
	public String updateDataDictionaryUI(@Param(value = "dataId") String dataId, Model model) {
		// 根据id查找数据字典信息，并将数据回显
		DataDictionary dataDictionary = dataDictionaryService.getDataDictionary(dataId);
		model.addAttribute("dataDictionary", dataDictionary);
		return "system/datadictionary/datadictionary_update";
	}

	// 修改数据字典信息
	@RequestMapping("updateDataDictionary.action")
	public String updateDataDictionary(DataDictionary dataDictionary, Model model) {
		boolean remark = dataDictionaryService.updateDataDictionary(dataDictionary);
		if (remark) {
			model.addAttribute("info", "数据字典信息修改成功");
		} else {
			model.addAttribute("info", "数据字典信息修改失败");
		}
		// 修改完成之后跳转到列表页面
		return listDataDictionary(null, model);
	}

	// 删除数据字典信息
	@RequestMapping("deleteDataDictionary.action")
	public String deleteDataDictionary(@Param(value = "dataId") String dataId, Model model) {
		// 此处删除数据字典的数据是硬删除
		boolean remark = dataDictionaryService.deleteDataDictionary(dataId);
		if (remark) {
			model.addAttribute("info", "数据字典信息删除成功");
		} else {
			model.addAttribute("info", "数据字典信息删除失败");
		}
		// 修改完成之后跳转到列表页面
		return listDataDictionary(null, model);
	}

}
