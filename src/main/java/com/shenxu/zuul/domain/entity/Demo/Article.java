package com.shenxu.zuul.domain.entity.Demo;

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
@TableName(value = "article")
public class Article extends Model<Article> {
    private Integer id;
    private String title;
    private Integer view;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
