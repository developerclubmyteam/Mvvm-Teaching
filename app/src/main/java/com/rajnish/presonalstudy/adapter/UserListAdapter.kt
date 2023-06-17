package com.rajnish.presonalstudy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.rajnish.presonalstudy.R
import com.rajnish.presonalstudy.db.UserDetails


class UserListAdapter(context: Context, userList: List<UserDetails>) : ArrayAdapter<UserDetails>(context, 0, userList) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var itemView = convertView
            if (itemView == null) {
                itemView = LayoutInflater.from(context).inflate(R.layout.list_item_user, parent, false)
            }

            val userDetails = getItem(position)

            // Bind the user details to the list item view
            val nameTextView = itemView!!.findViewById<TextView>(R.id.nameTextView)
            val ageTextView = itemView.findViewById<TextView>(R.id.ageTextView)
            val emailTextView = itemView.findViewById<TextView>(R.id.emailTextView)

            nameTextView.text = userDetails?.name
            ageTextView.text = userDetails?.age
            emailTextView.text = userDetails?.email

            return itemView
        }
    }

