package com.kangyonggan.site.controller.web;

import com.kangyonggan.server.model.Article;
import com.kangyonggan.server.model.Category;
import com.kangyonggan.server.model.dto.ResponseDto;
import com.kangyonggan.server.service.ArticleService;
import com.kangyonggan.server.service.CategoryService;
import com.kangyonggan.site.controller.BaseController;
import com.kangyonggan.site.util.MarkdownUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * @author kangyonggan
 * @since 16/10/12
 */
@Controller
@RequestMapping("category")
public class CategoryController extends BaseController {

    @Resource
    private ArticleService articleService;

    @Resource
    private CategoryService categoryService;

    /**
     * 某栏目的文章列表
     *
     * @param code
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping(value = "{code:[\\w]+}", method = RequestMethod.GET)
    public String index(@PathVariable("code") String code,
                        @RequestParam(value = "p", required = false, defaultValue = "1") int pageNum,
                        Model model) {
        ResponseDto<Category> categoryDto = categoryService.findCategoryByCode(code);
        Category category = categoryDto.getEntity();

        if (category == null) {
            return "404";
        }

        ResponseDto<Article> articlesDto = articleService.findArticlesByPage(pageNum, category.getCode());

        model.addAttribute("articlesDto", articlesDto);
        model.addAttribute("category", category);
        return "list";
    }

    /**
     * 文章详情
     *
     * @param code
     * @param id
     * @param model
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "{code:[\\w]+}/article/{id:[\\d]+}", method = RequestMethod.GET)
    public String detail(@PathVariable("code") String code, @PathVariable("id") Long id, Model model) throws UnsupportedEncodingException {
        ResponseDto<Article> articleDto = articleService.findArticleById(id);
        Article article = articleDto.getEntity();

        if (article == null) {
            return "404";
        }

        ResponseDto<Category> categoryDto = categoryService.findCategoryByCode(code);

        if (categoryDto.getEntity() == null) {
            return "404";
        }

        /**
         * markdown2html
         */
        article.setBody(MarkdownUtil.markdownToHtml(article.getBody()));

        model.addAttribute("articleDto", articleDto);
        model.addAttribute("categoryDto", categoryDto);
        return "detail";
    }

}
