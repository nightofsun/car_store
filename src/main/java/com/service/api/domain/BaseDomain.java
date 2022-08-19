package com.service.api.domain;

import java.util.Date;

public class BaseDomain {
    private Date createAt;
    private Date updateAt;
    private String isDelete;

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseDomain{createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDelete").append(isDelete);
        sb.append("}");
        return sb.toString();
    }
}
