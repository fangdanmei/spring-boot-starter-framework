package cn.cebest.framework.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@TableName("USER_2_ROLE")
public class User2Role extends Model<User2Role>{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer userId;
	
	private Integer roleId;
	
	private Date createTime;
	
	private Date updateTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
