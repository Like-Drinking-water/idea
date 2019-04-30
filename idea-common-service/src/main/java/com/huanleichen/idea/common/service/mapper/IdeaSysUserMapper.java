package com.huanleichen.idea.common.service.mapper;

import com.huanleichen.idea.common.domain.IdeaSysUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

@Repository
public interface IdeaSysUserMapper extends MyMapper<IdeaSysUser> {
}