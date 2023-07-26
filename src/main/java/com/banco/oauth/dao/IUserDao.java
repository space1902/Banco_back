package com.banco.oauth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.oauth.dto.UserCredit;

public interface IUserDao extends JpaRepository<UserCredit, Integer>{

}
