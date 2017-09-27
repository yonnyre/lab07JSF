package com.tecsup.lab7.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userDataManyCheckbox", eager = true)
@SessionScoped
public class UserDataManyCheckbox implements Serializable {

	private static final long serialVersionUID = 1L;

	public String[] data = { "1", "2", "3" };

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}
}
