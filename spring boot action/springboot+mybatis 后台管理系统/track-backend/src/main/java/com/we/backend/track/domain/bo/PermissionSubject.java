package com.we.backend.track.domain.bo;

import org.apache.shiro.subject.Subject;


/**
 * 权限验证BO，支持el表达式,调用方式<br>
 * ${currentUser.isPermitted('resModelCode')} true:false
 * @author YK
 * @date 2017/7/11
 */
public class PermissionSubject {
	private Subject subject;

	public PermissionSubject(Subject subject) {
		this.subject = subject;
	}
	public boolean isPermitted(String permission) {
		return subject.isPermitted(permission);
	}
}
