package ru.geekbrains.handler;

import ru.geekbrains.ResponseSerializer;
import ru.geekbrains.SocketService;
import ru.geekbrains.config.Config;

import org.reflections.Reflections;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnnotatedHandlerFactory {
	public static MethodHandler create(SocketService socketService, ResponseSerializer responseSerializer, Config config) {
		Reflections reflections = new Reflections("ru.geekbrains.handler");
		List<Class<?>> classes = new ArrayList<>(reflections.getTypesAnnotatedWith(Handler.class));
		
		MethodHandler prev = null;
		classes.sort(Comparator.comparingInt(AnnotatedHandlerFactory::getOrder).reversed());
		try {
			for (Class<?> clazz : classes) {
				Constructor<?> constructor = clazz.getConstructor(String.class, MethodHandler.class, SocketService.class, ResponseSerializer.class, Config.class);
				prev = (MethodHandler) constructor.newInstance(getMethod(clazz), prev, socketService, responseSerializer, config);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return prev;
	}
	
	private static int getOrder(Class<?> clazz) {
		return clazz.getAnnotation(Handler.class).order();
	}
	
	private static String getMethod(Class<?> clazz) {
		return clazz.getAnnotation(Handler.class).method();
	}
}
