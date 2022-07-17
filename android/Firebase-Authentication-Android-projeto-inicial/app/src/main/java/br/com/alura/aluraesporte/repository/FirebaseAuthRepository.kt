package br.com.alura.aluraesporte.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

class FirebaseAuthRepository(
    private val firebaseAuth: FirebaseAuth
) {

    fun createUser(email: String, password: String): LiveData<Boolean> {
        val mutableLiveData = MutableLiveData<Boolean>()
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                mutableLiveData.postValue(true)
            }
            .addOnFailureListener { e: Exception ->
                when(e){

                }
                e.printStackTrace()
                mutableLiveData.postValue(false)
            }
        return mutableLiveData
    }

    fun signOut() {
        firebaseAuth.signOut()
    }

    fun signIn(email: String, password: String): LiveData<Boolean> {
        val mutableLiveData = MutableLiveData<Boolean>()
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                mutableLiveData.postValue(true)
            }
            .addOnFailureListener {
                mutableLiveData.postValue(false)
            }
        return mutableLiveData
    }

    fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }


}