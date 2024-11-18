package com.example.profileapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.profileapp.ExperienceAdapter


class ExperienceAdapter(
    private val context: Context,
    private val titles: List<String>,
    private val details: List<String>
) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int = titles.size

    override fun getChildrenCount(groupPosition: Int): Int = 1

    override fun getGroup(groupPosition: Int): Any = titles[groupPosition]

    override fun getChild(groupPosition: Int, childPosition: Int): Any = details[groupPosition]

    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int): Long = childPosition.toLong()

    override fun hasStableIds(): Boolean = true

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = true

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_expandable_list_item_1, parent, false)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.text = getGroup(groupPosition) as String
        return view
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.text = getChild(groupPosition, childPosition) as String
        textView.textSize = 14f
        return view
    }
}
