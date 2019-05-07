package ru.kulikovman.docsvisiontest.model;

import java.util.UUID;

public class SessionToken {

    private UUID EmployeeId;
    private UUID TenantId;

    public UUID getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        EmployeeId = employeeId;
    }

    public UUID getTenantId() {
        return TenantId;
    }

    public void setTenantId(UUID tenantId) {
        TenantId = tenantId;
    }
}
