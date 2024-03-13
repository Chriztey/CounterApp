package com.chris.counterapp

class CounterViewModel () {
    var _count = 0
    val count = _count

    fun increment () {
        _count =+1
        return
    }

    fun decrement () {
        _count =-1
        return
    }
}