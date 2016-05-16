package com.nway.wform.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nway.wform.entity.ComponentEntity;
import com.nway.wform.entity.FormEntity;
import com.nway.wform.service.component.AbstractCmpService;
import com.nway.wform.service.component.MultiValueCmpService;
import com.nway.wform.service.component.SelectCmpService;
import com.nway.wform.service.component.TextCmpService;

@Service
public class FormService
{
    private static final Map<String, AbstractCmpService> componentService = new HashMap<>();
    
    static
    {
        componentService.put("text", new TextCmpService());
        componentService.put("select", new SelectCmpService());
        componentService.put("multiValue", new MultiValueCmpService());
        
    }
    
    @Autowired
    private SqlSessionFactory sessionFactory;
    
    public String buildSelectMapper(FormEntity form)
    {
        StringBuilder selectedColumnes = new StringBuilder("select ");
        StringBuilder selectedTables = new StringBuilder(" ");
        StringBuilder resultMap = new StringBuilder(" ");
        
        for (ComponentEntity component : form.getComponents())
        {
            selectedColumnes
                    .append(componentService.get(component.getType()).buildQuerySql(component).getColumnes())
                    .append(',');
            selectedTables
                    .append(componentService.get(component.getType()).buildQuerySql(component).getWithTable())
                    .append(' ');
            resultMap.append(componentService.get(component.getType()).buildResultMap(component));
        }
        
        selectedColumnes = selectedColumnes.length() > 7
                ? selectedColumnes.deleteCharAt(selectedColumnes.length() - 1) : selectedColumnes;
        
        return selectedColumnes.append(" from t_main ").append(selectedTables).toString()+"\n" +resultMap;
    }
    
    public FormEntity queryForm(int formId,int version)
    {
        Map<String,Object> param = new HashMap<>();
        
        param.put("formId", formId);
        param.put("version", version);
        
        SqlSession session = sessionFactory.openSession();
        FormEntity form = (FormEntity) session.selectOne("selectForm", param);
        session.close();
        return form;
    }
}