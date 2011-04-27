package animation;

import cube.Cube;

public class CubeRotationAnimation extends AbstractAnimation {
	public enum Rotation {
		X,
		Y,
		Z
	}
	
	private int totalTime;
	private Cube c;
	private Rotation r;
	private float targetRot;
	private float elapsedTime;
	
	
	public CubeRotationAnimation(AnimationCaller caller, Cube c, int totalTime, Rotation r, float targetRot) throws IllegalArgumentException{
		super(caller);
		
		if(totalTime <= 0)
			throw new IllegalArgumentException("totalTime cannot be under 0!");
		
		this.c = c;
		this.totalTime = totalTime;
		this.r = r;
		this.targetRot = targetRot;
	}

	@Override
	public void update(int delta) {
		if(elapsedTime + delta >= totalTime)
			setRotation(r, targetRot/totalTime * (totalTime - elapsedTime));
		else
			setRotation(r, targetRot/totalTime * delta);
		
		elapsedTime += delta;
		if(elapsedTime >= totalTime) 
			stop();
	}
	
	private void setRotation(Rotation r, float n) {
		switch(r) {
			case X:
				c.setRotX(c.getRotX() + n);
				break;
			case Y:
				c.setRotY(c.getRotY() + n);
				break;
			case Z:
				c.setRotZ(c.getRotZ() + n);
				break;
		}
	}
	
	public Rotation getRotation () {
		return r;
	}
}
