package cn.cebest.framework.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@TableName("USER_ROLE")
public class UserRole extends Model<UserRole>{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String roleCode;
	
	private String description;
	
	private Date createTime;
	
	private Date updateTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	
}
