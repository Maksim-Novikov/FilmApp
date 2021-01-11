package com.maksimnovikov.common.ui.extensions


infix fun String?.join(str: String?) = join(str, " ")
infix fun String?.joinByNewLine(str: String?) = join(str, "\n")

fun String?.join(str: String?, separator: String) =
    listOfNotNull(
        this.takeIf { !it.isNullOrEmpty() },
        str.takeIf { !it.isNullOrEmpty() }).joinToString(separator)
