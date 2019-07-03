package com.example.dao.sys;

import com.example.entity.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MemberDao extends JpaRepository<Member,Integer> {
    Page<Member> findByEnabledEquals(boolean state, Pageable pageable);
}
