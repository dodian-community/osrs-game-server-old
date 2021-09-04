package com.jagex.entity.model;

import javafx.geometry.Point3D;
import lombok.Data;

@Data
public class VertexNormal {

	// Class33

	public int magnitude;

	public int x;
	public int y;
	public int z;

	public Point3D getAsPoint3D() {
		return new Point3D(x, y, z);
	}

	public VertexNormal(){

	}
	public VertexNormal(VertexNormal var1) {
		this.x = var1.x;
		this.y = var1.y;
		this.z = var1.z;
		this.magnitude = var1.magnitude;
	}
}