package com.zstu.pms.utils;

public class CommonException extends Exception{
	
	 //异常代码   
    private String key;  
      
    private Object[] values;//一些其他信息   
      
    public CommonException() {  
        super();  
    }  
  
    public CommonException(String message, Throwable throwable) {  
        super(message, throwable);  
    }  
  
    public CommonException(String message) {  
        super(message);  
    }  
  
    public CommonException(Throwable throwable) {  
        super(throwable);  
    }  
      
    public CommonException(String message,String key){  
        super(message);  
        this.key = key;  
    }  
      
    public CommonException(String message,String key,Object value){  
        super(message);  
        this.key = key;  
        this.values = new Object[]{value};  
    }  
      
    public CommonException(String message,String key,Object[] values){  
        super(message);  
        this.key = key;  
        this.values = values;  
    }  
  
    public String getKey() {  
        return key;  
    }  
  
    public Object[] getValues() {  
        return values;  
    }  
}
