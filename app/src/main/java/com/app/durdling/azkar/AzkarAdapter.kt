package com.app.durdling.azkar

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.durdling.azkar.databinding.AzkarItemBinding

class AzkarAdapter : ListAdapter<DataSet, AzkarAdapter.ViewHolder>(AzkarAdapterComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AzkarItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: AzkarItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(azkarItem: DataSet) {
            binding.apply {
                title.text = azkarItem.text
                root.setOnClickListener {
                    it.context.startActivity(Intent(it.context, CounterActivity::class.java).apply {
                        putExtra(CounterActivity.ZEKER_POSITION, adapterPosition)
                    })
                }
            }
        }
    }
}

class AzkarAdapterComparator : DiffUtil.ItemCallback<DataSet>() {
    override fun areItemsTheSame(oldItem: DataSet, newItem: DataSet) =
        oldItem.text == newItem.text

    override fun areContentsTheSame(oldItem: DataSet, newItem: DataSet) =
        oldItem == newItem
}