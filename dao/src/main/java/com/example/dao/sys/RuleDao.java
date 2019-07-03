package com.example.dao.sys;

import com.example.entity.sys.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleDao extends JpaRepository<Rule,String> {
    Rule findByRulename(String name);
}
