package com.maksimnovikov.common.data

import timber.log.Timber
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class NoRequiredFieldException(
    clazz: KClass<*>,
    property: KProperty<*>,
    errorObject: String
) : RuntimeException("Absent required field ${clazz.qualifiedName}.${property.name} \n\nerror object = $errorObject")

fun Any.noRequiredField(property: KProperty<*>): NoRequiredFieldException {
    Timber.d("noRequiredField object $this")
    return NoRequiredFieldException(this::class, property, this.toString())
}

fun <T> Any.logIgnoreObject(property: KProperty<*>?): T? {
    Timber.d("ignore by field ${property?.name} object $this")
    return null
}
