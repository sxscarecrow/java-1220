package com.shenxu.zuul.domain.po.Test;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author ly
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "user")
public class User extends Model<User> {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
