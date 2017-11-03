package io.xhub.confIOMessenger

import io.vertx.core.Launcher

object Main {
    @JvmStatic fun main(args: Array<String>) {
        val argList = mutableListOf("run", "io.xhub.confIOMessenger.RootVerticle")
        argList.addAll(args)

        Launcher().dispatch(argList.toTypedArray())
    }
}
