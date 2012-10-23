package mymvc.controller;

import mymvc.dao.CategoryDao;
import mymvc.dao.JpaCategoryDao;
import mymvc.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryDao dao;

    public CategoryController() {

    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("message", "hello spring mvc world!");
        return "category/search";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@ModelAttribute("category") Category category, ModelMap model) {
        dao.save(category);
        category.setId(1);
        return "redirect:" + category.getId();
    }

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
    public String view(@PathVariable int categoryId, ModelMap model) {
        Category category = dao.findById(categoryId);
        model.addAttribute("category", category);
        return  "category/view";
    }
}
