package sample;

public interface EventListener<T> {
	void onEvent(T event);
}
