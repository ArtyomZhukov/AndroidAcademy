package com.zhukovartemvl.androidacademy.ui.utils

import com.zhukovartemvl.androidacademy.data.model.Actor
import com.zhukovartemvl.androidacademy.ui.model.ActorView


fun Actor.toActorItem() = ActorView(name, imageURL)

