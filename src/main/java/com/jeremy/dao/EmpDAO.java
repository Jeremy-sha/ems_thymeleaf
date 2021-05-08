package com.jeremy.dao;

import java.util.List;

import com.jeremy.entity.Emp;

public interface EmpDAO {
List<Emp> findAll();

void save(Emp emp);
void delete(String id);
Emp find (String id);
void update(Emp emp);
}
