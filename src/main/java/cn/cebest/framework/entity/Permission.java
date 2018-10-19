package cn.cebest.framework.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@TableName("PERMISSION")
public class Permission extends Model<Permission>{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String uniqueCode;
	
	private String name;
	
	private String type;
	
	private String url;
	
	private String permission;
	
	private Integer parentId;
	
	private String parentCode;
	
	private Date createTime;
	
	private Date updateTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
