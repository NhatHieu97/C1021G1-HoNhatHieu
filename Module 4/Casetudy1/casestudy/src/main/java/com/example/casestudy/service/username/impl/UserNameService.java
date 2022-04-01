package com.example.casestudy.service.username.impl;

import com.example.casestudy.model.person.UserName;
import com.example.casestudy.repository.IUserNameRepository;
import com.example.casestudy.service.username.IUserNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserNameService implements IUserNameService {
    @Autowired
    private IUserNameRepository iUserNameRepository;
    @Override
    public List<UserName> findAll() {
        return iUserNameRepository.findAll();
    }
}
