package com.example.dao.sys;

import com.example.entity.sys.Cate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CateDao extends JpaRepository<Cate,Integer> {
    Cate findByCatename(String catename);
}
