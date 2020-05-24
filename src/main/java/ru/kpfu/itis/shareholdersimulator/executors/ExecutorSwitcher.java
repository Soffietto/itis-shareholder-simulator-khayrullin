package ru.kpfu.itis.shareholdersimulator.executors;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.shareholdersimulator.entity.enums.BetTypes;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExecutorSwitcher {

    private final Map<BetTypes, Executor> executors;

    public ExecutorSwitcher(@NonNull Executor dropExecutor,
                            @NonNull Executor raiseExecutor) {
        this.executors = new HashMap<>();
        executors.put(BetTypes.DROP, dropExecutor);
        executors.put(BetTypes.RAISE, raiseExecutor);
    }

    Executor getExecutor(BetTypes betTypes) {
        return executors.get(betTypes);
    }
}
