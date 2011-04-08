public class Translator {
	Camera camera;
	
	public Translator(Camera camera) {
		this.camera = camera;
	}
	
	public Vector2D translateTo2D(Vector3D v3d) {
		Vector3D eye = new Vector3D(600,0,0); //Experimental use
		
		float x = (
				(float)
				(Math.cos(camera.getRotY()) 
				* ((v3d.getY() - camera.getY())
				+ Math.cos(camera.getRotZ())
				* (v3d.getX() - camera.getX()))
				- Math.sin(camera.getRotY())
				* (v3d.getZ() - camera.getZ())));
		
		float y = (
				(float)
				(Math.sin(camera.getRotX()) 
				* (Math.cos(camera.getRotY()) 
						* (v3d.getZ() - camera.getZ())
						+ Math.sin(camera.getRotY()) 
						* (Math.sin(camera.getRotZ())
								* (v3d.getY() - camera.getY())
						+ Math.cos(camera.getRotZ())
						* (v3d.getX() - camera.getX())))
				+ Math.cos(camera.getRotX())
				* (Math.cos(camera.getRotZ())
						* (v3d.getY() - camera.getY())
						- Math.sin(camera.getRotZ())
						* (v3d.getX() - camera.getX()))));
		float z = (
				(float)
				(Math.cos(camera.getRotX()) 
				* (Math.cos(camera.getRotY()) 
						* (v3d.getZ() - camera.getZ())
						+ Math.sin(camera.getRotY()) 
						* ((v3d.getY() - camera.getY())
						+ Math.cos(camera.getRotZ())
						* (v3d.getX() - camera.getX())))
				- Math.sin(camera.getRotX())
				* (Math.cos(camera.getRotZ()
						* (v3d.getY() - camera.getY())
						- Math.sin(camera.getRotZ())
						* (v3d.getX() - camera.getX())))));
		
		System.out.println(x + "  " + y + "  " + z);
		return new Vector2D((y-eye.getY()*(eye.getX()/x)), (z-eye.getZ()*(eye.getX()/x)));
	}
}
