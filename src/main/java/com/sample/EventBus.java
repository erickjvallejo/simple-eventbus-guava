
package com.sample;

/**
 *
 * @author erick
 */
public class EventBus {

    public static void register(final Object listener) {
        DemoUI.getEventBus().register(listener);
    }

    public static void unregister(final Object listener) {
        DemoUI.getEventBus().unregister(listener);
    }

    public static void post(final Object event) {
        DemoUI.getEventBus().post(event);
    }

}
