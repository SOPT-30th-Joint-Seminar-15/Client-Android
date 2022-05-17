package sopt.org.joint15_29cm.feature.mino

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sopt.org.joint15_29cm.databinding.ItemConsultingRecyclerviewBinding

class InquiryListAdapter(private val itemClickListener: (InquiryData, LinearLayout) -> Unit) :
    ListAdapter<InquiryData, InquiryListAdapter.InquiryViewHolder>(InquiryListDiffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InquiryViewHolder {
        val binding = ItemConsultingRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return InquiryViewHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: InquiryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class InquiryViewHolder(
        private val binding: ItemConsultingRecyclerviewBinding,
        private val itemClickListener: (InquiryData, LinearLayout) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: InquiryData) {
            with(binding) {
                inquiryModel = item
                constraint.setOnClickListener {
                    itemClickListener(item, itemLayoutDetail)
                }
            }
        }
    }

    companion object InquiryListDiffUtil : DiffUtil.ItemCallback<InquiryData>() {
        override fun areItemsTheSame(oldItem: InquiryData, newItem: InquiryData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: InquiryData, newItem: InquiryData): Boolean {
            return oldItem == newItem
        }

    }
}