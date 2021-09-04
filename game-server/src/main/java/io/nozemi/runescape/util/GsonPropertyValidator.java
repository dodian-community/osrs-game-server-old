package io.nozemi.runescape.util;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class GsonPropertyValidator implements TypeAdapterFactory {
	
	@Override
	public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
		TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
		
		if (delegate instanceof ReflectiveTypeAdapterFactory.Adapter) {
			try {
				Field f = delegate.getClass().getDeclaredField("boundFields");
				f.setAccessible(true);
				Map<?, ?> boundFields = (Map<?, ?>) f.get(delegate);
				
				boundFields = new LinkedHashMap<Object, Object>(boundFields) {
					@Override
					public Object get(Object key) {
						Object value = super.get(key);
						if (value == null) {
							throw new JsonParseException("invalid property name: " + key);
						}
						return value;
						
					}
				};
				
				f.set(delegate, boundFields);
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
			
		}
		return delegate;
	}
	
}