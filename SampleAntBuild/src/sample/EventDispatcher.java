package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDispatcher {
	private Map<Class<?>, List<EventListener<?>>> registeredListeners;

	public EventDispatcher() {
		registeredListeners = new HashMap<Class<?>, List<EventListener<?>>>();
	}

	public <T> void registerListener(Class<T> eventType, EventListener<T> listener) {
		List<EventListener<?>> listeners = registeredListeners.get(eventType);
		if (listeners == null) {
			listeners = new ArrayList<>();
			registeredListeners.put(eventType, listeners);
		}
		if (!listeners.contains(listeners)) {
			listeners.add(listener);
		}
	}

	public <T> void unregisterListener(EventListener<T> eventListener) {
		for (List<EventListener<?>> listeners : registeredListeners.values()) {
			listeners.remove(eventListener);
		}
	}
	
	public void 

}
