package com.shubilee.entity;

public class Template {
	
	
	private int template_id;
	
    private String template_code;
    
    private int is_html;
    
    private String template_subject;
    
    private String template_content;
    
    private long last_modify;

    private long last_send;
    
    private String type;
    
	
	
	
	public int getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(int template_id) {
		this.template_id = template_id;
	}

	public String getTemplate_code() {
		return template_code;
	}

	public void setTemplate_code(String template_code) {
		this.template_code = template_code;
	}

	public int getIs_html() {
		return is_html;
	}

	public void setIs_html(int is_html) {
		this.is_html = is_html;
	}

	public String getTemplate_subject() {
		return template_subject;
	}

	public void setTemplate_subject(String template_subject) {
		this.template_subject = template_subject;
	}

	public String getTemplate_content() {
		return template_content;
	}

	public void setTemplate_content(String template_content) {
		this.template_content = template_content;
	}

	public long getLast_modify() {
		return last_modify;
	}

	public void setLast_modify(long last_modify) {
		this.last_modify = last_modify;
	}

	public long getLast_send() {
		return last_send;
	}

	public void setLast_send(long last_send) {
		this.last_send = last_send;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



    
    
}