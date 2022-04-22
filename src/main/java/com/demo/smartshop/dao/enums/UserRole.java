package com.demo.smartshop.dao.enums;

public enum UserRole {
    ADMIN(1, "Administrator"),
    CUSTOMER(2, "Customer"),
    SELLER(3, "Seller");

    final int idUserRole;
    final String roleName;

    UserRole(int idUserRole, String roleName) {
        this.idUserRole = idUserRole;
        this.roleName = roleName;
    }

    public int getIdUserRole() {
        return idUserRole;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return "UserRole{" + "idUserRole=" + idUserRole + ", roleName=" + roleName + '}';
    }

}