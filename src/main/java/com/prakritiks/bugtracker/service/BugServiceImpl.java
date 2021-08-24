package com.prakritiks.bugtracker.service;

import com.prakritiks.bugtracker.models.Bug;
import com.prakritiks.bugtracker.repositories.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BugServiceImpl implements BugService{

    @Autowired
    BugRepository bugRepository;

    @Override
    public Bug showIssuesById(int bugId)
    {
        Optional<Bug> bugDAO = bugRepository.findById(bugId);

        Bug bug = new Bug();

        bug.setBugId(bugDAO.get().getBugId());
        bug.setBugName(bugDAO.get().getBugName());
        bug.setBugDescription(bugDAO.get().getBugDescription());
        bug.setBugPriority(bugDAO.get().getBugPriority());
        bug.setBugStatus(bugDAO.get().getBugStatus());
        
        return bug;
    }

    @Override
    public List<Bug> showAllIssue()
    {
        return bugRepository.findAll();
    }

    @Override
    public void saveNewIssue(Bug bug)
    {
        bugRepository.save(bug);
    }

    @Override
    public void deleteIssue(Integer bugId)
    {
        bugRepository.deleteById(bugId);
    }
}
