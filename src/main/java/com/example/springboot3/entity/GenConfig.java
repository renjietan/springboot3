package com.example.springboot3.entity;

import java.util.Date;

/**
 * 代码生成基础配置表
 * 自动生成代码
 * @author tanrenjie
 * @date Thu Mar 19 17:58:46 CST 2026
 */
public class GenConfig {

            /**  */
            private Long id;

            /** 表名 */
            private String tablename;

            /** 模块名 */
            private String modulename;

            /** 包名 */
            private String packagename;

            /** 业务名 */
            private String businessname;

            /** 实体类名 */
            private String entityname;

            /** 作者 */
            private String author;

            /** 父目录id */
            private Long parentmenuid;

            /** 创建时间 */
            private Date createtime;

            /** 更新时间 */
            private Date updatetime;

            /** 是否删除 */
            private Integer isdelete;

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getTablename() {
                return tablename;
            }

            public void setTablename(String tablename) {
                this.tablename = tablename;
            }

            public String getModulename() {
                return modulename;
            }

            public void setModulename(String modulename) {
                this.modulename = modulename;
            }

            public String getPackagename() {
                return packagename;
            }

            public void setPackagename(String packagename) {
                this.packagename = packagename;
            }

            public String getBusinessname() {
                return businessname;
            }

            public void setBusinessname(String businessname) {
                this.businessname = businessname;
            }

            public String getEntityname() {
                return entityname;
            }

            public void setEntityname(String entityname) {
                this.entityname = entityname;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public Long getParentmenuid() {
                return parentmenuid;
            }

            public void setParentmenuid(Long parentmenuid) {
                this.parentmenuid = parentmenuid;
            }

            public Date getCreatetime() {
                return createtime;
            }

            public void setCreatetime(Date createtime) {
                this.createtime = createtime;
            }

            public Date getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(Date updatetime) {
                this.updatetime = updatetime;
            }

            public Integer getIsdelete() {
                return isdelete;
            }

            public void setIsdelete(Integer isdelete) {
                this.isdelete = isdelete;
            }

        }