package izhengmy.springboot.common.mybatisflex;

import com.mybatisflex.annotation.InsertListener;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

public class CreatedAtListener implements InsertListener {

    @Override
    public void onInsert(Object o) {
        try {
            LocalDateTime now = LocalDateTime.now();

            Field createdAt = o.getClass().getDeclaredField("createdAt");
            createdAt.setAccessible(true);
            createdAt.set(o, now);

            Field updatedAt = o.getClass().getDeclaredField("updatedAt");
            updatedAt.setAccessible(true);
            updatedAt.set(o, now);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
    }

}
