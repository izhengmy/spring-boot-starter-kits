package izhengmy.springboot.common.mybatisflex;

import com.mybatisflex.annotation.UpdateListener;
import com.mybatisflex.core.update.UpdateWrapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class UpdatedAtListener implements UpdateListener {

    @Override
    public void onUpdate(Object o) {
        if (UpdateWrapper.class.isAssignableFrom(o.getClass())) {
            try {
                Method method = o.getClass().getMethod("setUpdatedAt", LocalDateTime.class);
                method.invoke(o, LocalDateTime.now());
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignored) {
            }
            return;
        }

        try {
            Field updatedAt = o.getClass().getDeclaredField("updatedAt");
            updatedAt.setAccessible(true);
            updatedAt.set(o, LocalDateTime.now());
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
    }

}
