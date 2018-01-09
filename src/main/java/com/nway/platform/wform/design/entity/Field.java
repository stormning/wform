package com.nway.platform.wform.design.entity;

import com.nway.platform.wform.access.component.BaseComponent;

public class Field {
	
	private String id;

	/**
	 * 用做页面元素 id 或 name
	 */
	private String name;

	/**
	 * 中文解释
	 */
	private String display;

	/** 所属模块  **/
	private String moduleId;

	/**
	 * 组件类别
	 */
	private String type;
	
	/** 行号 **/
	private int rowNum;

	/** 列 **/
	private int colNum;

	/** 跨列数 **/
	private int colSpan;
	
	private int size;
	
	// VO
	private BaseComponent objType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public BaseComponent getObjType() {
		return objType;
	}

	public void setObjType(BaseComponent objType) {
		this.objType = objType;
	}
	
}
