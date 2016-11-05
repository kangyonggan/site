package com.kangyonggan.site.controller.web;

import com.kangyonggan.server.model.Article;
import com.kangyonggan.server.model.Category;
import com.kangyonggan.server.model.dto.ResponseDto;
import com.kangyonggan.server.service.ArticleService;
import com.kangyonggan.site.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author kangyonggan
 * @since 16/10/12
 */
@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

    private static final String PATH_ROOT = "web/default/";
    private static final String PATH_LIST = PATH_ROOT + "list";
    private static final String PATH_ABOUT = PATH_ROOT + "about";

    @Resource
    private ArticleService articleService;

    /**
     * 首页
     *
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index(@RequestParam(value = "p", required = false, defaultValue = "1") int pageNum,
                        Model model) {
        ResponseDto<Article> articlesDto = articleService.findArticlesByPage(pageNum, null);
        Category category = new Category();
        category.setCode("all");
        category.setName("首页");

        model.addAttribute("articlesDto", articlesDto);
        model.addAttribute("category", category);
        return PATH_LIST;
    }

    /**
     * 全文检索
     *
     * @param pageNum
     * @param key
     * @param model
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(@RequestParam(value = "p", required = false, defaultValue = "1") int pageNum,
                         @RequestParam(value = "key") String key, Model model) {
        ResponseDto<Article> articlesDto = articleService.searchArticles(pageNum, key);
        Category category = new Category();
        category.setCode("search");
        category.setName(key);

        model.addAttribute("articlesDto", articlesDto);
        model.addAttribute("category", category);
        return PATH_LIST;
    }

    /**
     * 关于我
     *
     * @return
     */
    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String about() {
        return PATH_ABOUT;
    }

}
