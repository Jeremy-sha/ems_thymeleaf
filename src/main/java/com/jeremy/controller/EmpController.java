package com.jeremy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeremy.entity.Emp;
import com.jeremy.service.EmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private EmpService empService;
	// 修改员工信息
	@PostMapping("/update")
	public String update(Emp emp) {
	    empService.update(emp);
	    return "redirect:/emp/findAll";
	}

	// 根据id查询员工
	@GetMapping("/find")
	public String find(String id, Model model) {
	    Emp emp = empService.find(id);
	    model.addAttribute("emp", emp);
	    return "/ems/updateEmp";
	}

   //删除员工

	 @GetMapping("/delete")
	public String Delete (String id) {
		empService.delete(id);

		return "redirect:/emp/findAll";
	}

	//	保存员工
	@PostMapping("/save")
	public String save(Emp emp) {
		empService.save(emp);



		return "redirect:/emp/findAll";

	}

	//	查询所有
	@GetMapping("/findAll")
	public String findAll(Model model) {
		List<Emp> emps = empService.findAll();
		model.addAttribute("emps", emps);
		return "ems/emplist";

	}

}
