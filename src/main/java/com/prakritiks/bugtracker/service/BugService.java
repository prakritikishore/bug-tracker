package com.prakritiks.bugtracker.service;

import com.prakritiks.bugtracker.models.Bug;

import java.util.List;

public interface BugService {

    List<Bug> showAllIssue();
    Bug showIssuesById(int bugId);
    void saveNewIssue(Bug bug);
    void deleteIssue(Integer bugId);
}
