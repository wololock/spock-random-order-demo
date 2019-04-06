package com.github.wololock

import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.SpecInfo

final class RandomizedOrderExtension extends AbstractAnnotationDrivenExtension<RandomizedOrder> {

    @Override
    void visitSpecAnnotation(RandomizedOrder annotation, SpecInfo spec) {
        final List<Integer> order = (0..(spec.features.size())) as ArrayList

        Collections.shuffle(order)

        spec.features.each { feature ->
            feature.executionOrder = order.pop()
        }
    }
}
