package com.xk.eyepetizer.ui.view.banner

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import com.xk.eyepetizer.mvp.model.bean.Item


/**
 * Created by xuekai on 2017/8/21.
 */
class BannerAdapter(context: Context) : PagerAdapter() {
    var datas: ArrayList<Item>? = null
    var viewList: ArrayList<HomeBannerItem> = ArrayList()

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        if (datas == null) {
            return 0
        } else {
            return datas!!.size
        }
    }


    override fun destroyItem(container: ViewGroup, position: Int,
                             `object`: Any) {
        container.removeView(viewList[position])
        viewList[position].releasePlayer()
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        if (viewList.size <= position) {
            val homeBannerItem = HomeBannerItem(container.context, datas!![position])
            viewList.add(homeBannerItem)
        }
        val view = viewList[position]
        container.addView(view)
        viewList[position].play()

        return view
    }


}