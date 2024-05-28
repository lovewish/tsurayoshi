package com.example.demo.form;

public class Clothing {
	 private String gender;
	    private String imageUrl;

	    public Clothing(String gender, String imageUrl) {
	        this.gender = gender;
	        this.imageUrl = imageUrl;
	    }

	    // Getter and setter methods
	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public String getImageUrl() {
	        return imageUrl;
	    }

	    public void setImageUrl(String imageUrl) {
	        this.imageUrl = imageUrl;
	    }
	}


