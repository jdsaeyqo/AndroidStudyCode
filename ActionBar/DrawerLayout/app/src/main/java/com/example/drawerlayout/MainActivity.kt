package com.example.drawerlayout

import android.os.Bundle
import android.view.Menu
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //아래 메시지 처럼 생긴 플로트 버튼 불필요시 삭제
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_sub), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
/*
activity_main.xml 은 include 와 nav_view로 구성되어 있다
include는 다른 layout을 포함시키는 요소인데 프래그먼트가 교체되는 화면 부분에 해당
nav_view는 좌측에서 나타나는 메뉴에 해당


Controller 설정
DrawerLayout을 통해 교체될 Fragment를 관리하고 각 Fragment 교체 처리를 해주는 Controller가 제공
전에는 Controller가 없어서 개발자가 직접 구현을 해야 했지만 지금은 이 Controller에 Fragment들만 셋팅해주면 된다

mobile_navigation.xml
Controller가 관리할 Fragment들을 등록하는 xml파일이다

이 파일에 Fragment를 등록할 때 설정하는 id가 매우 중요하다
좌측에서 나타나는 메뉴를 클릭했을 때 클릭한 메뉴의 id와 동일한 id가 세팅되어 있는 fragment가 화면에 나타남
이 부분은 모두 설정되어 있기 때문에 개발자는 Fragment를 등록할 때 id를 메뉴의 id와 동일하게만 설정해주면 됨됨 */