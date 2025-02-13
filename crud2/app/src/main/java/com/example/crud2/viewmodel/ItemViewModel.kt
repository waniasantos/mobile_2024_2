package com.example.crud2.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import com.example.crud2.model.Item
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration


class ItemViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()

    private var listenerRegistration: ListenerRegistration? = null

    var items = mutableStateOf<List<Item>>(listOf())
        private set

    init {

    }

    private fun listenToItems() {
        listenerRegistration = db.collection("items")
            .addSnapshotListener { snapshot, exception ->
                if (exception != null) {
                    return@addSnapshotListener
                }

                if (snapshot != null){
                    val fetchedItems = snapshot.documents.map { document ->
                        document.toObject(Item::class.java)?.copy(id = document.id)
                    }.filterNotNull()

                    items.value = fetchedItems
                }

            }
    }

    fun addItem(item: Item){
        db.collection("Items").add(item)
    }

    fun deleteItem(itemId: String){
        db.collection("items").document(itemId).delete()
    }

    override fun onCleared() {
        super.onCleared()
        listenerRegistration?.remove()
    }

    fun updateItem(item: Item){
        db.collection("Items")
            .document(item.id)
            .set(item)
            .addOnSuccessListener{
                Log.d("ItemViewModel", "Item criado com sucesso")
            }
            .addOnFailureListener{ exception ->
                Log.e("ItemViewModel", "Erro ao atualizar o item", exception)
            }
    }

}