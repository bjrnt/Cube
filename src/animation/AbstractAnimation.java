package animation;

public abstract class AbstractAnimation {
	private boolean active;
	private AnimationCaller caller;
	
	protected AbstractAnimation (AnimationCaller caller) {
		this.caller = caller;
	}
	
	public void begin() {
		active = true;
	}
	
	public boolean isActive() {
		return active;
	}
	
	abstract void update(int delta);
	
	public void stop() {
		notifyCaller();
	}
	
	protected void notifyCaller() {
		caller.animationDone(this);
	}
}
