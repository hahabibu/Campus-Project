package com.zstu.pms.declare.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zstu.pms.declare.dto.DeclareRecordDTO;
import com.zstu.pms.declare.service.DeclareRecordService;
import com.zstu.pms.mapper.DeclareRecordMapper;
import com.zstu.pms.mapper.DeclareTypeMapper;
import com.zstu.pms.mapper.ItemInfoMapper;
import com.zstu.pms.mapper.UserInfoMapper;
import com.zstu.pms.model.DeclareRecord;
import com.zstu.pms.model.DeclareRecordExample;
import com.zstu.pms.model.DeclareRecordExample.Criteria;
import com.zstu.pms.model.DeclareType;
import com.zstu.pms.model.ItemInfo;
import com.zstu.pms.model.UserInfo;
import com.zstu.pms.utils.ConstantUtils;

@Service("declareRecordServiceImpl")
@Transactional
public class DeclareRecordServiceImpl implements DeclareRecordService {

	@Resource(name = "declareRecordMapper")
	private DeclareRecordMapper declareRecordMapper;

	@Resource(name = "itemInfoMapper")
	private ItemInfoMapper itemInfoMapper;

	@Resource(name = "declareTypeMapper")
	private DeclareTypeMapper declareTypeMapper;

	@Resource(name = "userInfoMapper")
	private UserInfoMapper userInfoMapper;

	@Override
	public boolean addItemInfo(ItemInfo itemInfo, DeclareRecord declareRecord) {
		// 添加项目详情
		int i = itemInfoMapper.insert(itemInfo);
		// 设置记录属性并添加记录详情
		declareRecord.setDeclareId(UUID.randomUUID().toString().replaceAll("-", ""));
		declareRecord.setItemId(itemInfo.getItemId());
		// declareRecord.setTypeId("1");
		// declareRecord.setUserId("1");
		declareRecord.setCreateTime(new Date());
		declareRecord.setModifiedTime(new Date());
		declareRecord.setProcessStatus(ConstantUtils.PROCESS_STATUS_DECLARE);
		declareRecord.setResult("申报处理中");
		declareRecord.setDelTag(ConstantUtils.DEL_TAG_SAVE);
		int j = declareRecordMapper.insert(declareRecord);
		return (i > 0 && j > 0);
	}

	@Override
	public boolean updateItemInfo(ItemInfo itemInfo,DeclareRecord declareRecord) {
		int i = itemInfoMapper.updateByPrimaryKeySelective(itemInfo);
		if(declareRecord!=null) {
			declareRecord.setModifiedTime(new Date());
			declareRecordMapper.updateByPrimaryKey(declareRecord);
		}
		return i > 0;
	}

	@Override
	public List<DeclareRecordDTO> listDeclareRecord(DeclareRecord declareRecord) {
		DeclareRecordExample declareRecordExample = new DeclareRecordExample();
		Criteria criteria = declareRecordExample.createCriteria();
		if (declareRecord != null) {
			if (!StringUtils.isEmpty(declareRecord.getUserId())) {
				criteria.andUserIdEqualTo(declareRecord.getUserId());
			}
			if (!StringUtils.isEmpty(declareRecord.getTypeId())) {
				if (!ConstantUtils.DEFAULT_CHECK_CONDITION.equals(declareRecord.getTypeId())) {
					criteria.andTypeIdEqualTo(declareRecord.getTypeId());
				}
			}
			if (!StringUtils.isEmpty(declareRecord.getProcessStatus())) {
				if (!ConstantUtils.DEFAULT_CHECK_CONDITION.equals(declareRecord.getProcessStatus())) {
					criteria.andProcessStatusEqualTo(declareRecord.getProcessStatus());
				}
			}
		} else {
			// 初始化只显示已提交的记录
			criteria.andProcessStatusEqualTo(ConstantUtils.PROCESS_STATUS_DECLARE);
		}
		List<DeclareRecord> declareRecordList = declareRecordMapper.selectByExample(declareRecordExample);
		List<DeclareRecordDTO> declareRecordDTOList = null;
		if (declareRecordList != null) {
			declareRecordDTOList = new ArrayList<>(declareRecordList.size());
			for (DeclareRecord dr : declareRecordList) {
				declareRecordDTOList.add(getDTObyModel(dr));
			}
		}
		return declareRecordDTOList;
	}

	@Override
	public DeclareRecord getDeclareRecord(String declareId) {
		return declareRecordMapper.selectByPrimaryKey(declareId);
	}

	@Override
	public DeclareRecordDTO getDTObyModel(DeclareRecord declareRecord) {
		DeclareRecordDTO declareRecordDTO = new DeclareRecordDTO();
		BeanUtils.copyProperties(declareRecord, declareRecordDTO);
		if (declareRecord != null) {
			if (!StringUtils.isEmpty(declareRecord.getItemId())) {
				// 查找相关的项目详情
				ItemInfo itemInfo = itemInfoMapper.selectByPrimaryKey(declareRecord.getItemId());
				declareRecordDTO.setItemInfo(itemInfo);
			}
			if (!StringUtils.isEmpty(declareRecord.getTypeId())) {
				// 查找相关的项目类型详情
				DeclareType declareType = declareTypeMapper.selectByPrimaryKey(declareRecord.getTypeId());
				declareRecordDTO.setDeclareType(declareType);
			}
			if (!StringUtils.isEmpty(declareRecord.getUserId())) {
				// 查找相关的用户详情（申报人id）
				UserInfo userInfo = userInfoMapper.selectByPrimaryKey(declareRecord.getUserId());
				declareRecordDTO.setUserInfo(userInfo);
			}
			String processStatus = declareRecord.getProcessStatus();
			String processStatusContext = null;
			if (!StringUtils.isEmpty(processStatus)) {
				if (ConstantUtils.PROCESS_STATUS_DECLARE.equals(processStatus)) {
					processStatusContext = ConstantUtils.PROCESS_STATUS_DECLARE_CONTEXT;
				} else if (ConstantUtils.PROCESS_STATUS_SET.equals(processStatus)) {
					processStatusContext = ConstantUtils.PROCESS_STATUS_SET_CONTEXT;
				} else if (ConstantUtils.PROCESS_STATUS_UNSET.equals(processStatus)) {
					processStatusContext = ConstantUtils.PROCESS_STATUS_UNSET_CONTEXT;
				} else if (ConstantUtils.PROCESS_STATUS_MIDCHECK_PASS.equals(processStatus)) {
					processStatusContext = ConstantUtils.PROCESS_STATUS_MIDCHECK_PASS_CONTEXT;
				} else if (ConstantUtils.PROCESS_STATUS_MIDCHECK_UNPASS.equals(processStatus)) {
					processStatusContext = ConstantUtils.PROCESS_STATUS_MIDCHECK_UNPASS_CONTEXT;
				} else if (ConstantUtils.PROCESS_STATUS_ENDCHECK_PASS.equals(processStatus)) {
					processStatusContext = ConstantUtils.PROCESS_STATUS_ENDCHECK_PASS_CONTEXT;
				} else if (ConstantUtils.PROCESS_STATUS_ENDCHECK_UNPASS.equals(processStatus)) {
					processStatusContext = ConstantUtils.PROCESS_STATUS_ENDCHECK_UNPASS_CONTEXT;
				}
				declareRecordDTO.setProcessStatusContext(processStatusContext);
			}
		}
		return declareRecordDTO;
	}

	@Override
	public void uploadFile(HttpServletRequest request) {

		// a.获取解析工厂
		DiskFileItemFactory df = new DiskFileItemFactory();
		// b.根据解析工厂获取解析器
		ServletFileUpload sfu = new ServletFileUpload(df);
		// c.判断是否为上传表单，如果不是则直接return
		if (!sfu.isMultipartContent(request)) {
			return;
		}
		// d.如果是上传表单则用解析器解析request请求
		try {
			List<FileItem> list = sfu.parseRequest(request);
			// 依次进行遍历，根据不同的FileItem类型进行不同的操作
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					/**
					 * 如果是普通的上传项,获取相关的值进行打印 getFieldName():获取输入项的名称 getString():得到上传项的值
					 */
					String name = fileItem.getFieldName();
					String value = fileItem.getString();
					// 直接获取从表单中读取的数据，存在中文乱码问题，则重新封装该数据再进行输出即可
					try {
						value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					System.out.println("key:" + name + "--value:" + value);
				} else {
					try {
						/**
						 * 如果这个项是上传的文件，则通过io流进行读写操作 getInputStream():获取输入流 getName():获取文件完整路径信息
						 * 如果只需要获取文件名称，进行截取即可
						 */
						InputStream fis = fileItem.getInputStream();
						String filename = fileItem.getName();
						// 通过截取获取文件的名称
						filename = filename.substring(filename.lastIndexOf("\\") + 1);
						// 利用io流知识进行读写操作
						String path = "e:\\upload";
						/**
						 * 1.普通方式： FileOutputStream fos = new FileOutputStream(path + "\\" + filename);
						 */
						/**
						 * 2.通过自定义规则的文件名称进行保存（参考时间） FileOutputStream fos = new
						 * FileOutputStream(getPath(path) + "\\" + getFilename(filename));
						 */
						/**
						 * 3.通过自定义规则的文件名称进行保存（参考filename的hashcode） FileOutputStream fos = new
						 * FileOutputStream(getPath(path,filename) + "\\" + getFilename(filename));
						 */
						FileOutputStream fos = new FileOutputStream(getPath(path, filename) + "\\" + getFilename(filename));
						byte[] buffer = new byte[1024];
						int hasRead = 0;
						while ((hasRead = fis.read(buffer)) != -1) {
							fos.write(buffer, 0, hasRead);
						}
						// 关闭文件流
						fis.close();
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	// 根据UUID获取文件名称
	public String getFilename(String filename) {
		return UUID.randomUUID().toString() + "_" + filename;
	}

	// 根据自定义规则获取文件保存路径(参考时间)
	public String getPath(String path) {
		// 按照时间规则保存上传数据
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String savePath = sdf.format(new Date());
		String dir = path + "/" + savePath;
		File file = new File(dir);
		// 如果指定目录不存在则创建目录即可
		if (!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}

	// 根据自定义规则获取文件保存路径(参考filename的hashcode)
	public String getPath(String path, String filename) {
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf; // 得到0-15之间的数字
		int dir2 = (hashcode & 0xf0) >> 4; // 得到0-15之间的数字
		// 将目录路径进行拼接
		String dir = path + "/" + dir1 + "/" + dir2;
		File file = new File(dir);
		// 如果指定目录不存在则创建目录即可
		if (!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}

}
