package com.example.demo.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MemberRepository extends CrudRepository<Member, Integer> {

}
