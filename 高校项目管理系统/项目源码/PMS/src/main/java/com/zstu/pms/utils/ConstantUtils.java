package com.zstu.pms.utils;

public class ConstantUtils {
	
	// 默认没有查找条件的标识
	public final static String DEFAULT_CHECK_CONDITION = "pass";

    // 用户状态：启用
    public final static String USER_STATE_ENABLE = "0";
    public final static String USER_STATE_ENABLE_CONTEXT = "启用";

    // 用户状态：禁用
    public final static String USER_STATE_FORBIDDEN = "1";
    public final static String USER_STATE_FORBIDDEN_CONTEXT = "禁用";

    // 删除标识(0.保存  1.删除)
    public final static String DEL_TAG_SAVE = "0";
    public final static String DEL_TAG_DELETE = "1";
    
    // 已读标识(0.未读  1.已读)
    public final static String READ_STATUS_UNREAD = "0";
    public final static String READ_STATUS_UNREAD_CONTEXT = "未读";
    public final static String READ_STATUS_READ = "1";
    public final static String READ_STATUS_READ_CONTEXT = "已读";

    // 数据字典的数据类型
    public final static String DATA_TYPE_DEPARTMENT = "department";
    
    // 申报类型启用标识
    public final static String START_STATUS_CLOSE ="0";
    public final static String START_STATUS_CLOSE_CONTEXT ="未启用";
    public final static String START_STATUS_OPEN = "1";
    public final static String START_STATUS_OPEN_CONTEXT = "启用中";
    public final static String START_STATUS_OVERDUE = "2";
    public final static String START_STATUS_OVERDUE_CONTEXT = "已过期";
    
    // 申报记录处理标识
    // 用户申报相关
    public final static String PROCESS_STATUS_DECLARE = "0";
    public final static String PROCESS_STATUS_DECLARE_CONTEXT = "已申报";
    // 项目立项相关
    public final static String PROCESS_STATUS_SET = "1";
    public final static String PROCESS_STATUS_SET_CONTEXT = "已立项";
    public final static String PROCESS_STATUS_UNSET = "-1";
    public final static String PROCESS_STATUS_UNSET_CONTEXT = "未立项/待整改";
    // 项目中期检查相关
    public final static String PROCESS_STATUS_MIDCHECK_PASS = "2";
    public final static String PROCESS_STATUS_MIDCHECK_PASS_CONTEXT = "中期检查通过";
    public final static String PROCESS_STATUS_MIDCHECK_UNPASS = "-2";
    public final static String PROCESS_STATUS_MIDCHECK_UNPASS_CONTEXT = "中期检查未通过/待整改";
    // 项目结题验收相关
    public final static String PROCESS_STATUS_ENDCHECK_PASS = "3";
    public final static String PROCESS_STATUS_ENDCHECK_PASS_CONTEXT = "结题验收通过";
    public final static String PROCESS_STATUS_ENDCHECK_UNPASS = "-3";
    public final static String PROCESS_STATUS_ENDCHECK_UNPASS_CONTEXT = "结题验收未通过/待整改";
    
    // 设置限定的角色
    public final static String ROLE_ADMIN = "1";
    public final static String ROLE_ADMIN_CONTEXT = "超级管理员";
    public final static String ROLE_STUDENT = "2";
    public final static String ROLE_STUDENT_CONTEXT = "学生";
    public final static String ROLE_SET = "3";
    public final static String ROLE_SET_CONTEXT = "立项管理";
    public final static String ROLE_MIDCHECK = "4";
    public final static String ROLE_MIDCHECK_CONTEXT = "中期检查管理";
    public final static String ROLE_ENDCHECK = "5";
    public final static String ROLE_ENDCHECK_CONTEXT = "结题验收管理";
    
}
