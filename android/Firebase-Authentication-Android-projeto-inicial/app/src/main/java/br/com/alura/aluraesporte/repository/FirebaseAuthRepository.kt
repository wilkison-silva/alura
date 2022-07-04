package br.com.alura.aluraesporte.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth

class FirebaseAuthRepository(
    private val firebaseAuth: FirebaseAuth
) {

    fun createUser(email: String, password: String): LiveData<Boolean> {
        val mutableLiveData = MutableLiveData<Boolean>()
        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                mutableLiveData.postValue(true)
            }
            .addOnFailureListener { e: Exception ->
                e.printStackTrace()
                mutableLiveData.postValue(false)
            }
        return mutableLiveData
    }
}