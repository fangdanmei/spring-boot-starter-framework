package cn.cebest.framework.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@TableName("ROLE_2_PERMISSION")
public class Role2Permission extends Model<Role2Permission>{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer roleId;
	
	private Integer permissionId;
	
	private Date createTime;
	
	private Date updateTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	
}
