package me.geeksploit.builditbigger;

import android.support.annotation.Nullable;
import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicBoolean;

class SimpleIdlingResource implements IdlingResource {

    @Nullable
    private volatile ResourceCallback mCallback;
    private AtomicBoolean mIsIdle = new AtomicBoolean(true);

    /**
     * Returns the name of the resources (used for logging and idempotency of registration).
     */
    @Override
    public String getName() {
        return getClass().getName();
    }

    /**
     * Returns {@code true} if resource is currently idle. Espresso will <b>always</b> call this
     * method from the main thread, therefore it should be non-blocking and return immediately.
     */
    @Override
    public boolean isIdleNow() {
        return mIsIdle.get();
    }

    /**
     * Registers the given {@link ResourceCallback} with the resource. Espresso will call this method:
     * <p>
     * <ul>
     * <li>with its implementation of {@link ResourceCallback} so it can be notified asynchronously
     * that your resource is idle
     * <li>from the main thread, but you are free to execute the callback's onTransitionToIdle from
     * any thread
     * <li>once (when it is initially given a reference to your IdlingResource)
     * </ul>
     * <p>
     * <p>You only need to call this upon transition from busy to idle - if the resource is already
     * idle when the method is called invoking the call back is optional and has no significant
     * impact.
     *
     * @param callback
     */
    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        mCallback = callback;
    }
}
