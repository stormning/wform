package com.nway.wform.entity;

public class ComponentEntity
{
    private int id;
    
    /**
     * 中文解释
     */
    private String display;
    
    /**
     * 用做页面元素 id 或 name
     */
    private String name;
    
    private String formId;
    
    /**
     * 组件子数据表名字
     */
    private String tableName;
    
    /**
     * 组件类别
     */
    private String type;
    
    /**
     * 组件渲染类型<br>
     * 1：html页面javascript渲染，数据来自动态后台获取<br>
     * 2：html页面javascript渲染，数据来自静态文件<br>
     * 3：模板生成html时初始化展示数据
     */
    private int renderType;
    
    /**
     * 是否可编辑
     */
    private boolean isEditable;
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getDisplay()
    {
        return display;
    }
    
    public void setDisplay(String display)
    {
        this.display = display;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getFormId()
    {
        return formId;
    }
    
    public void setFormId(String formId)
    {
        this.formId = formId;
    }
    
    public String getTableName()
    {
        return tableName;
    }
    
    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public int getRenderType()
    {
        return renderType;
    }
    
    public void setRenderType(int renderType)
    {
        this.renderType = renderType;
    }
    
    public boolean isEditable()
    {
        return isEditable;
    }
    
    public void setEditable(boolean isEditable)
    {
        this.isEditable = isEditable;
    }
    
}
