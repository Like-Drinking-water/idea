package com.huanleichen.idea.service.sso.service;

import com.huanleichen.idea.common.domain.IdeaSysUser;

public interface SSOService {
    IdeaSysUser login(String loginCode, String plantPassword);
}
