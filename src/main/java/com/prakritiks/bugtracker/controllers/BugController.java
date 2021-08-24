package com.prakritiks.bugtracker.controllers;

import com.prakritiks.bugtracker.models.Bug;
import com.prakritiks.bugtracker.service.BugServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BugController {

    @Autowired
    BugServiceImpl bugService;

    @RequestMapping("/all")
    public String showBug(Model model)
    {
        model.addAttribute("list1",bugService.showAllIssue());
        return "bugHome";
    }

    @RequestMapping("/new")
    public String newBug(Model model)
    {
        model.addAttribute("bug",new Bug());
        return "BugForm";
    }

    @RequestMapping("/edit/{bugId}")
    public String editBug(@PathVariable int bugId, Model model)
    {
        model.addAttribute("bug",bugService.showIssuesById(bugId));
        return "BugForm";
    }

    @RequestMapping("/save")
    public String saveBug(@ModelAttribute Bug bug)
    {
        bugService.saveNewIssue(bug);
        return "redirect:" + "/all";
    }
    @RequestMapping("/delete/{bugId}")
    public String deleteBug(@PathVariable int bugId)
    {
        bugService.deleteIssue(bugId);
        return "redirect:" + "/all";
    }

}
