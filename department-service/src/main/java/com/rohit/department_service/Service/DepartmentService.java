package com.rohit.department_service.Service;

import com.rohit.department_service.Entity.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);
}