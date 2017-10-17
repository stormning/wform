package com.nway.wform.access.mybatis;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedIOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.nway.wform.design.entity.ComponentGroup;
import com.nway.wform.design.entity.FormPage;

@Component
public class MybatisMapper {
	
	@Autowired
    private SqlSessionTemplate sqlSession;
	
	public void createMapper(FormPage formPage) {
		
		StringBuilder xml = new StringBuilder();
		
		for(ComponentGroup group : formPage.getComponentGroups()) {
			
			if(formPage.getPageType() == FormPage.PAGE_TYPE_CREATE && group.isModify()) {
				
				
				xml.append(group.getUpdateComponentNames());
			}
			else if(formPage.getPageType() == FormPage.PAGE_TYPE_EDIT && group.isModify()) {
				
				
				xml.append(group.getUpdateComponentNames());
			}
			else if(formPage.getPageType() == FormPage.PAGE_TYPE_DETAILS) {
				
				
				xml.append(group.getUpdateComponentNames());
			}
			else if(formPage.getPageType() == FormPage.PAGE_TYPE_LIST) {
				
				
				xml.append(group.getUpdateComponentNames());
			}
		}
	}

	public void addMapper(String mapperLocation) throws NestedIOException {

		Configuration configuration = sqlSession.getConfiguration();
		ClassPathResource resource = new ClassPathResource(mapperLocation);

		try {
			XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(resource.getInputStream(), configuration,
					resource.toString(), configuration.getSqlFragments());
			xmlMapperBuilder.parse();
		} catch (Exception e) {
			throw new NestedIOException("Failed to parse mapping resource: '" + mapperLocation + "'", e);
		}
	}
	
}
