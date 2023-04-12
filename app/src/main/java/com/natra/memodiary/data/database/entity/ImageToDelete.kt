package com.natra.memodiary.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.natra.memodiary.util.Constants.IMAGE_TO_DELETE_TABLE

@Entity(tableName = IMAGE_TO_DELETE_TABLE)
data class ImageToDelete(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val remoteImagePath: String
)
