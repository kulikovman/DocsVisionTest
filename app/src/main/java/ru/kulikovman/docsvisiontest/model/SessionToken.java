package ru.kulikovman.docsvisiontest.model;

import java.util.UUID;

public class SessionToken {

    private UUID employeeId;
    private UUID tenantId;

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public UUID getTenantId() {
        return tenantId;
    }

    public void setTenantId(UUID tenantId) {
        this.tenantId = tenantId;
    }
}
