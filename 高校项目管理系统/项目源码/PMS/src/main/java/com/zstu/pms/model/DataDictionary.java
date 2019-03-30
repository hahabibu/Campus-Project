package com.zstu.pms.model;

public class DataDictionary {
    private String dataId;

    private String dataContent;

    private String dataType;

    private String dataDescr;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId == null ? null : dataId.trim();
    }

    public String getDataContent() {
        return dataContent;
    }

    public void setDataContent(String dataContent) {
        this.dataContent = dataContent == null ? null : dataContent.trim();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public String getDataDescr() {
        return dataDescr;
    }

    public void setDataDescr(String dataDescr) {
        this.dataDescr = dataDescr == null ? null : dataDescr.trim();
    }
}