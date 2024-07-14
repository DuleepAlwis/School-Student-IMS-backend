package com.school.studentms.constants;

public enum Role {
    ORG_ADMIN(1,"ORG_ADMIN"),ORG_MANAGER(2,"ORG_MANAGER"),SYS_ADMIN(3,"SYSTEM_ADMIN"),SYS_MANAGER(4,"SYSTEM_MANAGER");

    private long index;
    private String name;

    Role(int i, String name) {
        this.index = i;
        this.name = name;
    }

    public long getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
