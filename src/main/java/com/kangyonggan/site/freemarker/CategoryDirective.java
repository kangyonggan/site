package com.kangyonggan.site.freemarker;

import com.kangyonggan.server.model.Category;
import com.kangyonggan.server.model.dto.ResponseDto;
import com.kangyonggan.server.service.CategoryService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * @author kangyonggan
 * @since 16/10/14
 */
@Component
public class CategoryDirective implements TemplateDirectiveModel {

    @Resource
    private CategoryService categoryService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        ResponseDto<Category> categoriesDto = categoryService.findAllCategories();

        env.setVariable("categories", ObjectWrapper.DEFAULT_WRAPPER.wrap(categoriesDto.getData()));
        if (body != null) {
            body.render(env.getOut());
        }
    }

}
