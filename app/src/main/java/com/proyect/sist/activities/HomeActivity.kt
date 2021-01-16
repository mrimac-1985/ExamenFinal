package com.proyect.sist.activities

import android.content.Context
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
import com.bumptech.glide.Glide
import com.proyect.sist.R
import com.proyect.sist.base.BaseActivity
import com.proyect.sist.databinding.ActivityHomeBinding
import com.proyect.sist.databinding.ActivityLoginBinding
import com.proyect.sist.databinding.NavHeaderMainBinding
import com.proyect.sist.utilitarios.AdministradorDePreferencias
import com.proyect.sist.views.MenuSesionView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.view.*
import kotlinx.android.synthetic.main.activity_home.view.nav_view
import kotlinx.android.synthetic.main.item_carrito_compras.view.*
import kotlinx.android.synthetic.main.nav_header_main.view.*


class HomeActivity : BaseActivity() , MenuSesionView {

    private lateinit var appBarConfiguration: AppBarConfiguration

    lateinit var binding: ActivityHomeBinding

    private var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val viewHeader = nav_view.getHeaderView(0)
        val navViewHeaderBinding : NavHeaderMainBinding = NavHeaderMainBinding.bind(viewHeader)

        navViewHeaderBinding.lblusuariosesion.setText( AdministradorDePreferencias.obtenerUsuario( this))
        navViewHeaderBinding.lblcorreo.setText( AdministradorDePreferencias.obtenerCorreo( this))

        Glide.with(this).load("https://lh3.googleusercontent.com/-FAWcbf5_kkU/ULmI8OMS0pI/AAAAAAAAD5k/b9AWKmWVakAxsQ7iulmYKS8u4jfiaCcQQCEwYBhgLKtQDAL1Ocqz7JeVdE3Ji3Bu5qPnWsKng49JxUFUwgiu1-TxBWLv-O3xauFASVwRBrdqr4Zy40qiZWcc-VaDYXG2Vd_0DAINXznHOUNyn3T1njGmmkRyy2NUJ2KvPjDkM2CIo924iGiX1iA71XIyHpUlNNvBnIlbHXqSvsTV7Zj8ItSMDD3bLq40Oyfw8x1YZ6cHupZBUTC527adUVWSowHpeO0NssT_uRi3W0zP9-1ZQ1Ugt6F9SXk0Bzt4QmNEBzeaNWf2qJlyClC4AIzqPX-IML0EWGCo1pbzzPYjOECEc-Mt-ICwQJceHhyAJ6fFXKCDW_jAzXi1YT8HbyKzwQQqldQ5_lxLB84g2jJv4LsadqZscogS86AbqAsGbYtJqNvibUkYJj_1ayuHDsiPc2rJXmT1H8ReNdvrOhkucj88k7Hkx8g1jo_X5SFWRx3jUCLxmMWpQ0EtG-SKEUlbLzIrcGcbSejOKkuKU4rA1HiOu0CkJYFy_YUhUWN1kRboPDctOpr8p_BwrREXTT3b6D3rtf5mTltWpjXlg5pxKmW_0ptBImTmZOWPT2qjmJAuEryjcO_s3qCr5BdXr9w3AGhFdCFFojZz0wN641DNCZdm6TLBOtaiwMKiWiIAG/w139-h140-p/CIMG0705.JPG")
            .placeholder(R.drawable.ic_menu_camera)
            .error(R.drawable.ic_menu_camera)
            .into(navViewHeaderBinding.fotousuario);


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //navView.lblusuariosesion.setText("Maximo Rimac")
        //binding.navView.lblusuariosesion.setText("Maximo Rimac")


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)

        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    override fun mostrarCargando() {
        TODO("Not yet implemented")
    }

    override fun ocultarCargando() {
        TODO("Not yet implemented")
    }
}