package com.nway.platform.wform.design.entity;

public class PageFieldForm extends Field {
	
	private String id;
	
	private String fieldId;
	
	private String pageId;

	/** 行号 **/
	private int rowNum;

	/** 列 **/
	private int colNum;

	/** 跨列数 **/
	private int colSpan;
	
	private boolean editable;
	
	// 需要在待办表现实，值为待办表中使用的名字
	private String forWorkItem;
	
	// 可作为流程变量，值为流程变量中使用的名字
	private String forWorkflow;

	// VO
	private String updateFieldNames;

	private String viewFieldNames;
	
	private boolean isMultiValue;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getColNum() {
		return colNum;
	}

	public void setColNum(int colNum) {
		this.colNum = colNum;
	}

	public int getColSpan() {
		return colSpan;
	}

	public void setColSpan(int colSpan) {
		this.colSpan = colSpan;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String getForWorkItem() {
		return forWorkItem;
	}

	public void setForWorkItem(String forWorkItem) {
		this.forWorkItem = forWorkItem;
	}

	public String getForWorkflow() {
		return forWorkflow;
	}

	public void setForWorkflow(String forWorkflow) {
		this.forWorkflow = forWorkflow;
	}

	public boolean isMultiValue() {
		return isMultiValue;
	}

	public void setMultiValue(boolean isMultiValue) {
		this.isMultiValue = isMultiValue;
	}

	public String getUpdateFieldNames() {
		return updateFieldNames;
	}

	public void setUpdateFieldNames(String updateFieldNames) {
		this.updateFieldNames = updateFieldNames;
	}

	public String getViewFieldNames() {
		return viewFieldNames;
	}

	public void setViewFieldNames(String viewFieldNames) {
		this.viewFieldNames = viewFieldNames;
	}
	
}
