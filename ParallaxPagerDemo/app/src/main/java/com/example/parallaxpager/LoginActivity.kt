package com.example.parallaxpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), ViewPager.OnPageChangeListener,
    ViewPager.PageTransformer {

    private lateinit var loginPagerAdapter: LoginPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewpager.setPageTransformer(false, this)
        viewpager.addOnPageChangeListener(this)
        loginPagerAdapter = LoginPagerAdapter(supportFragmentManager, createFragmentList());
        viewpager.adapter = loginPagerAdapter
    }

    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        when {
            position < -1 -> page.alpha = 0f
            position <= 1 -> {
                page.findViewById<View>(R.id.tv_app_name).translationX = -(pageWidth * position)
                page.findViewById<View>(R.id.tv_app_subtitle).translationX = -(pageWidth * position)

                page.findViewById<View>(R.id.userView).translationX = pageWidth * position
                page.findViewById<View>(R.id.tv_user_label).translationX = pageWidth * position
                page.findViewById<View>(R.id.view_user_underline).translationX = pageWidth * position
                page.findViewById<View>(R.id.profileImage).translationX = pageWidth * position

                page.findViewById<View>(R.id.passView).translationX = pageWidth * position
                page.findViewById<View>(R.id.tv_pass_label).translationX = pageWidth * position
                page.findViewById<View>(R.id.view_pass_underline).translationX = pageWidth * position
                page.findViewById<View>(R.id.iv_pass_icon).translationX = pageWidth * position

                page.findViewById<View>(R.id.commandButton).translationX = -(pageWidth * position)
            }
            else -> page.alpha = 0f
        }
    }

    private fun createFragmentList(): List<LoginFragment> {
        return listOf(LoginFragment.newInstance(LoginFragment.LOGIN),
            LoginFragment.newInstance(LoginFragment.SIGN_UP))
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        val x = ((viewpager.width * position + positionOffsetPixels) * computeFactor())
        scrollView.scrollTo(x.toInt() + imageView.width / 3, 0)
    }

    override fun onPageSelected(position: Int) {
    }

    private fun computeFactor(): Float {
        return (imageView.width / 2 - viewpager.width) / (viewpager.width *
                loginPagerAdapter.count - 1).toFloat()
    }
}
