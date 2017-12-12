package com.nway.wform.access.component;

public interface BaseComponent {

	/**
	 * 根据组件所需的实际类型，转换页面参数值
	 * 
	 * @return
	 */
	Object getValue(String pageData);
	
}
