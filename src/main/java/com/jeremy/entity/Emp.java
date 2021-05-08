package com.jeremy.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Emp {


    private  String id;
    private String name;

    private String salary;
    private  String age;
    private String bir;


}

