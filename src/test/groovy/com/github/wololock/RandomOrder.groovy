package com.github.wololock

import org.junit.runner.notification.RunNotifier
import org.junit.runners.model.InitializationError
import org.spockframework.runtime.RunContext
import org.spockframework.runtime.Sputnik
import org.spockframework.runtime.model.SpecInfo

class RandomOrder extends Sputnik {
    RandomOrder(Class<?> clazz) throws InitializationError {
        super(clazz)
    }

    @Override
    void run(RunNotifier notifier) {
        super.runExtensionsIfNecessary()
        super.generateSpecDescriptionIfNecessary()

        final SpecInfo spec = super.getSpec()
        final List<Integer> order = (0..(spec.features.size())) as ArrayList

        Collections.shuffle(order)

        spec.features.each { feature ->
            feature.executionOrder = order.pop()
        }

        RunContext.get().createSpecRunner(spec, notifier).run()
    }
}
