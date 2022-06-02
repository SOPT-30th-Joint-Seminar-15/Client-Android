package sopt.org.joint15_29cm.feature.mino

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sopt.org.joint15_29cm.data.remote.models.ResponseInquiryData
import sopt.org.joint15_29cm.databinding.ItemConsultingRecyclerviewBinding

class InquiryListAdapter(
    private val layoutClickListener: (ResponseInquiryData, LinearLayout) -> Unit,
    private val itemClickListener: (ResponseInquiryData) -> Unit
) :
    ListAdapter<ResponseInquiryData, InquiryListAdapter.InquiryViewHolder>(InquiryListDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InquiryViewHolder {
        val binding = ItemConsultingRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return InquiryViewHolder(binding, layoutClickListener, itemClickListener)
    }

    override fun onBindViewHolder(holder: InquiryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class InquiryViewHolder(
        private val binding: ItemConsultingRecyclerviewBinding,
        private val layoutClickListener: (ResponseInquiryData, LinearLayout) -> Unit,
        private val itemClickListener: (userItem: ResponseInquiryData) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ResponseInquiryData) {
            with(binding) {
                inquiryModel = item
                constraint.setOnClickListener {
                    layoutClickListener(item, itemLayoutDetail)
                }
                btnItemDelete.setOnClickListener {
                    itemClickListener(item)
                }
            }
        }
    }

    companion object {
        object InquiryListDiffUtil :
            DiffUtil.ItemCallback<ResponseInquiryData>() {
            override fun areItemsTheSame(
                oldItem: ResponseInquiryData,
                newItem: ResponseInquiryData
            ): Boolean {
                return oldItem.inquiryId == newItem.inquiryId
            }

            override fun areContentsTheSame(
                oldItem: ResponseInquiryData,
                newItem: ResponseInquiryData
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
