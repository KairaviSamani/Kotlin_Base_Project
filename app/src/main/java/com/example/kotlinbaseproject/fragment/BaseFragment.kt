package com.example.kotlinbaseproject.fragment

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * This class is extended by all application fragments
 */
abstract class BaseFragment: Fragment() {
    private var _binding: ViewBinding? = null

    /**
     * This method is used to initialization process of fragment
     */
    abstract fun init()

    fun bindView(_binding: ViewBinding?) {
        this._binding = _binding
        if (_binding != null) {
            init()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}