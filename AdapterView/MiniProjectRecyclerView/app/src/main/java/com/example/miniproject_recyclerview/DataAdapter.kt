package com.example.miniproject_recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.data_list_item.*
import kotlinx.android.synthetic.main.data_list_item.view.*

class DataAdapter(private val items : ArrayList<Pet>,
                  private val context : Context,
                  private val itemSelect : (Pet) -> Unit)
                : RecyclerView.Adapter<ExtensionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtensionViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.data_list_item,parent,false
        ) //아이템 레이아웃
        return ExtensionViewHolder(view, itemSelect)
    }

    override fun onBindViewHolder(holder: ExtensionViewHolder, position: Int) {
        holder.bind(items[position],context)
    }

    override fun getItemCount(): Int {
        return items.size
    }


}

//ViewById 가 아니라 캐쉬값으로 불러올수 있어 성능 향상 - 빌드 그래들에서 experimental추가
class ExtensionViewHolder(

    override val containerView: View,
    itemSelect: (Pet) -> Unit) : RecyclerView.ViewHolder(containerView),LayoutContainer{
        fun bind(pet : Pet,context: Context){
           if (pet.photo != ""){
               val resourceId =
                   context.resources.getIdentifier(pet.photo,"drawable",context.packageName)
               img_pet.setImageResource(resourceId)




           }else{
               img_pet.setImageResource(R.mipmap.ic_launcher)
           }
            tv_breed.text = pet.breed
            tv_gender.text = pet.gender
            tv_age.text= pet.age

        }
}
