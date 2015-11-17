package com.tomrenn.swap.api

import okio.Okio
import java.io.File

/**
 * Handle saving and retrieving a user profile.
 */
class ProfileManager(val saveDir : File) {
    val PROFILE_FILE = "profile.json"

    init {
        saveDir.mkdirs();
    }

    fun profileFile() = File(saveDir, PROFILE_FILE)


    fun fromJson(json: String) : Profile {
        return Profile("Somebody", "He's unidentified")
    }
    fun toJson(profile: Profile) : String {
        return ""
    }


    fun saveProfile(profile: Profile) {
        val profileFile = profileFile()
        val json = toJson(profile)

//        val fileSink = Okio.buffer(Okio.sink(profileFile))
//        fileSink.writeAll(Okio.source(json))
//        fileSink.close()
    }

    fun restoreProfile() {
        val fileSource = Okio.buffer(Okio.source(profileFile()))
        val json = ""
    }
}