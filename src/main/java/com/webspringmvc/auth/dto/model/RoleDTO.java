package com.webspringmvc.auth.dto.model;

import java.sql.Timestamp;

import com.webspringmvc.core.dto.AbstractDTO;

public class RoleDTO extends AbstractDTO {
    private String code;
    private String name;

    public RoleDTO(Long id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy,
                     String code, String name) {
        super(id, createdDate, modifiedDate, createdBy, modifiedBy);
        this.code = code;
        this.name = name;
    }

    public RoleDTO() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleModel [code=" + code + ", name=" + name + ", getId()=" + getId() + ", getCreatedDate()="
                + getCreatedDate() + ", getModifiedDate()=" + getModifiedDate() + ", getCreatedBy()=" + getCreatedBy()
                + ", getModifiedBy()=" + getModifiedBy() + ", getPage()=" + getPage() + ", getMaxPageItem()="
                + getMaxPageItem() + ", getTotalPage()=" + getTotalPage() + ", getTotalItem()=" + getTotalItem()
                + ", getSortName()=" + getSortName() + ", getSortBy()=" + getSortBy() + ", toString()="
                + super.toString() + "]";
    }

}
