package com.zhukovartemvl.androidacademy.data.mapper

import com.zhukovartemvl.androidacademy.data.model.Actor
import com.zhukovartemvl.androidacademy.ui.movie_details.ActorItem


fun Actor.toActorItem() = ActorItem(name, imageURL)

