package ge.edu.sangu.unisys.server.models;

import java.io.Serializable;

public class Image implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * fields of this class will be saved in the mongodb
	 */

	private Integer userId; // the ID of the USERS table. ( owner's ID )

	private String imageName;

	private byte[] imageInBinary;

	// getters and setters

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public byte[] getImageInBinary() {
		return imageInBinary;
	}

	public void setImageInBinary(byte[] imageInBinary) {
		this.imageInBinary = imageInBinary;
	}

}