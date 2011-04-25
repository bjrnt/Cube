package animation;

/**
 * AbstractAnimation is used to provide some baseline functionality for any inheriting classes.
 * Some examples of this is being able to check if the animation is currently running, start it, etc.
 * @author Björn Tegelund
 */
public abstract class AbstractAnimation {
	private boolean active;
	private AnimationCaller caller;
	
	/**
	 * @param caller
	 */
	protected AbstractAnimation (AnimationCaller caller) {
		this.caller = caller;
	}
	
	/**
	 * Sets this animation to run.
	 */
	public void begin() {
		active = true;
	}
	
	/**
	 * @return Boolean with a value describing if this animation is active or not.
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * Runs a part of this animation, determined by how long time has passed since the last frame.
	 * @param delta The amount of time that has passed since the last frame.
	 */
	abstract void update(int delta);
	
	/**
	 * Stops this animation without completing it.
	 */
	public void stop() {
		notifyCaller();
	}
	
	/**
	 * Notifies the caller that this animation either is complete or stopped.
	 */
	protected void notifyCaller() {
		caller.animationDone(this);
	}
}
