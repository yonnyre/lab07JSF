package com.tecsup.lab7.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "userDataAttribute", eager = true)
@SessionScoped
public class UserDataAttribute implements Serializable {

	private static final long serialVersionUID = 1L;

	public String data = "1";

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void attributeListener(ActionEvent event) {
		data = (String) event.getComponent().getAttributes().get("username");
	}
}
