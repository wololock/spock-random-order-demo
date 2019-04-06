package com.github.wololock


import org.spockframework.runtime.extension.IAnnotationDrivenExtension
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.FieldInfo
import org.spockframework.runtime.model.MethodInfo
import org.spockframework.runtime.model.SpecInfo

class RandomizedOrderExtension implements IAnnotationDrivenExtension<RandomizedOrder> {

    @Override
    void visitSpecAnnotation(RandomizedOrder annotation, SpecInfo spec) {

    }

    @Override
    void visitFeatureAnnotation(RandomizedOrder annotation, FeatureInfo feature) {

    }

    @Override
    void visitFixtureAnnotation(RandomizedOrder annotation, MethodInfo fixtureMethod) {

    }

    @Override
    void visitFieldAnnotation(RandomizedOrder annotation, FieldInfo field) {

    }

    @Override
    void visitSpec(SpecInfo spec) {
        final List<Integer> order = (0..(spec.features.size())) as ArrayList

        Collections.shuffle(order)

        spec.features.each { feature ->
            feature.executionOrder = order.pop()
        }
    }
}
