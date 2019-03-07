package top.kwrcee.sortcourse.manage.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.kwrcee.sortcourse.manage.dao.DepartmentDao;
import top.kwrcee.sortcourse.manage.dao.EmployeeDao;
import top.kwrcee.sortcourse.manage.entities.Department;
import top.kwrcee.sortcourse.manage.entities.Employee;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //查询员工列表
    @GetMapping("/emps")
    public String list (Model model){
        Collection<Employee> employees= employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "admin/index/article-list";
    }
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    //员工添加
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //来到修改页面，查出当前员工，然后回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        return "emp/add";
    }
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
