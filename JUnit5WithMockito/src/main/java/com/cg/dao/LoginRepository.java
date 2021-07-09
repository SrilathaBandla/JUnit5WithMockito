package com.cg.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Login;

@Repository
@Transactional
public interface LoginRepository extends JpaRepository <Login,Long>{

}
