package com.nway.platform.wform.commons.freemarker;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

import com.nway.platform.wform.commons.freemarker.directive.FileExistsDirective;
import com.nway.platform.wform.commons.freemarker.directive.PdKeyPrinterDirective;

import freemarker.template.Configuration;
import freemarker.template.SimpleScalar;

public class FreemarkerFactory implements FactoryBean<Configuration>, ObjectFactory<Configuration>, ApplicationContextAware {

	private ApplicationContext context;
	
	private String templatePath;

	@Override
	public Configuration getObject() throws BeansException {

		Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
		
		String baseWebPath = ((WebApplicationContext) context).getServletContext().getRealPath("/");

		File templateDir = new File(baseWebPath, templatePath);
		
		cfg.setDefaultEncoding("UTF-8");
		cfg.setOutputEncoding("UTF-8");
		cfg.setSharedVariable("exists", new FileExistsDirective());
		cfg.setSharedVariable("pdKey", new PdKeyPrinterDirective());
		cfg.setSharedVariable("baseWebPath", new SimpleScalar(baseWebPath));
		cfg.setSharedVariable("absoluteTemplateDir", new SimpleScalar(templateDir.getAbsolutePath()));
		
		try {
			cfg.setDirectoryForTemplateLoading(templateDir);
		} catch (IOException e) {
			throw new BeanCreationException(e.toString(), e);
		}

		return cfg;
	}

	@Override
	public Class<?> getObjectType() {

		return Configuration.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		
		this.context = context;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}
}
