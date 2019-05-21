package ca.warp7.rt.router.tba

import ca.warp7.rt.router.impl.ConfigSystem

object TBA {
    var authKey: String? = ConfigSystem.getTBAKey()
}