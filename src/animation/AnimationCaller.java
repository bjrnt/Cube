package animation;

/**
 * An AnimationCaller is a class that can start Animations. This functionality is added so that when an animation is finished it can result in repercussions.
 * @author Björn Tegelund
 */
public interface AnimationCaller {
	/**
	 * Called by an Animation when it is done/has been interrupted.
	 * @param animation The animation that is done/has been interrupted.
	 */
	public void animationDone(AbstractAnimation animation);
}
