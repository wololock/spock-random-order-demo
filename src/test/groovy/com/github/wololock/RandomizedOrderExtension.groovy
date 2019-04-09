package com.github.wololock

import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.SpecInfo

final class RandomizedOrderExtension extends AbstractAnnotationDrivenExtension<RandomizedOrder> {

    public static final String SPOCK_RANDOM_ORDER_SEED = "spock.random.order.seed"

    @Override
    void visitSpecAnnotation(RandomizedOrder annotation, SpecInfo spec) {
        final long seed = System.getProperty(SPOCK_RANDOM_ORDER_SEED)?.toLong() ?: System.nanoTime()

        final Random random = new Random(seed)

        println "Random seed used: ${seed}\nYou can re-run the test with predefined seed by passing -D${SPOCK_RANDOM_ORDER_SEED}=${seed}\n\n"

        final List<Integer> order = (0..(spec.features.size())) as ArrayList

        Collections.shuffle(order, random)

        spec.features.each { feature ->
            feature.executionOrder = order.pop()
        }
    }
}
