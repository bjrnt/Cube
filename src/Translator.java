public class Translator {
	Camera camera;
	Vector3D centerOfProjection;
	
	public Translator(Camera camera) {
		this.camera = camera;
		centerOfProjection = new Vector3D(camera.getX()+100,camera.getY(),camera.getZ());
	}
	
	public Vector2D translateTo2D(Vector3D v3d) {
		float w = v3d.getX()/(centerOfProjection.getX() - camera.getX()) + 1;
		float z = v3d.getZ()/w;
		float y = v3d.getY()/w;
		return new Vector2D(y,z);
	}
	
	
}
