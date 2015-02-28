package cn.mobiledaily.childhood.parentingknowledge.web;

import cn.mobiledaily.childhood.parentingknowledge.common.Result;
import cn.mobiledaily.childhood.parentingknowledge.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Johnson on 2015/2/28.
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/categories/{id}/subcategories", method = RequestMethod.GET)
    @ResponseBody
    public Result getCategories(@PathVariable Long id) {
        return Result.successResult(articleService.getSubCategories(id));
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ResponseBody
    public Result getCategories() {
        return Result.successResult(articleService.getCategories());
    }

    @RequestMapping(value = "/categories/{cid}/articles", method = RequestMethod.GET)
    @ResponseBody
    public Result getArticlesBy(@PathVariable Long cid,
                                @RequestParam("page") Integer page,
                                @RequestParam("size") Integer size) {
        return Result.successResult(articleService.getArticlesBy(cid, page, size));
    }
}